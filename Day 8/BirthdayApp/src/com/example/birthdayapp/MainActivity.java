package com.example.birthdayapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.os.Build;
import android.provider.MediaStore;

public class MainActivity extends ActionBarActivity {

	private static int RESULT_LOAD_IMAGE = 1;
	static Button btn2;
	static RelativeLayout myView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn2=(Button) findViewById(R.id.button2);
		myView=(RelativeLayout) findViewById(R.id.myview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	public void loadImg(View v)
	{
		Intent i = new Intent(
				Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);				
				startActivityForResult(i, RESULT_LOAD_IMAGE);
				
	}
	
	 @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    	super.onActivityResult(requestCode, resultCode, data);
	    	
			if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
				Uri selectedImage = data.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };

				Cursor cursor = getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				cursor.moveToFirst();

				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				String picturePath = cursor.getString(columnIndex);
				cursor.close();
				
				ImageView imageView = (ImageView) findViewById(R.id.imageView1);
				imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
				//Enable btn2 and set onCLickListener
				btn2.setEnabled(true);
				btn2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						//save and share image
						
						myView.setDrawingCacheEnabled(true);
						Bitmap b = myView.getDrawingCache();
						try {
							//b.compress(CompressFormat.JPEG, 95, new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() +"/image.jpg"));
							 	
							
							File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "shared_image.png");
			                    FileOutputStream stream = new FileOutputStream(file);
			                    b.compress(Bitmap.CompressFormat.JPEG, 95, stream);
			                    stream.flush();
			                    stream.close();
			                    Uri uri = Uri.fromFile(file);
			                    //Uri uri  = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName()+ ".provider", file);
			                    //share
			                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
			                    intent.putExtra(Intent.EXTRA_STREAM, uri);
			                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
			                    intent.setType("image/*");
			                    intent.putExtra(Intent.EXTRA_TEXT, "Happy Birhtday to YOU!");
			                    startActivity(Intent.createChooser(intent, "Share"));
			                    
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				
			}
	    
	    
	    }
}
