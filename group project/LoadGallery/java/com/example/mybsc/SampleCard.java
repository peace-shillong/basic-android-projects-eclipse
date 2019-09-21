package com.example.mybsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SampleCard extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1;
    private ImageView img;
    private  Uri selectedImage;
    EditText name;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_card);
        img=findViewById(R.id.imageView);
        name=findViewById(R.id.editText);
        display=findViewById(R.id.textView);
    }

    public void loadImage(View view) {
        Intent i = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
           selectedImage = data.getData();
            img.setImageURI(selectedImage);
        }
    }

    public void shareImage(View view) {
        //display.setText(name.getText().toString());
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, selectedImage);
        //intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Happy Birthday "+name.getText().toString()+"");
        startActivity(Intent.createChooser(intent, "Share"));
    }
}
