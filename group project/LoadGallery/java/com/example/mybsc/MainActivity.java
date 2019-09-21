package com.example.mybsc;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCardDesign(View view) {
   /* int id=view.getId();
    switch (id){
        case R.id.khasi:
            Toast.makeText(this,"khasi",Toast.LENGTH_SHORT).show();
            break;
        case R.id.english:
            Toast.makeText(this, "english",Toast.LENGTH_SHORT ).show();
            break;
        case R.id.garo:
            Toast.makeText(this, "garo", Toast.LENGTH_SHORT).show();
            break;
        case R.id.hindi:
            Toast.makeText(this,"hindi",Toast.LENGTH_SHORT).show();
            break;*/
    }


    public void openCardDesign(android.view.View view) {
        int id = view.getId();
        switch (id) {
            case R.id.khasi:
                Toast.makeText(this, "khasi", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(this,SampleCard.class);
                startActivity(i);
                break;
            case R.id.english:
                Toast.makeText(this, "english", Toast.LENGTH_SHORT).show();
                break;
            case R.id.garo:
                Toast.makeText(this, "garo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hindi:
                Toast.makeText(this, "hindi", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
