package com.example.passingextradatatoactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

	
	TextView tv;
	Bundle bo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		tv=(TextView) findViewById(R.id.textView2);
		bo=getIntent().getExtras();
		
		tv.setText(bo.getString("user"));		
		
	}

}
