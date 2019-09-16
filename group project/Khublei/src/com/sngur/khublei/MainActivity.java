package com.sngur.khublei;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void openCardDesign(View view) {
		int i=view.getId();
		
		switch (i) {
		case R.id.khasi:
			Toast.makeText(this, "Khais", Toast.LENGTH_SHORT).show();
			break;
		case R.id.garo:
			Toast.makeText(this, "Garos", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
}
