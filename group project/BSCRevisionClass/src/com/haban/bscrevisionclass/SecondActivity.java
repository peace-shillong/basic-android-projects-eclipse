package com.haban.bscrevisionclass;
import com.haban.bscrevisionclass.R;
import com.haban.bscrevisionclass.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Toast;

public class SecondActivity extends Activity implements AdapterView.OnItemSelectedListener {
	Spinner spinner;
	String[] countries={"India","nepal","Russia"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		spinner=(Spinner)findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,countries);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		Toast.makeText(this, ""+countries[position], Toast.LENGTH_SHORT).show();
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {// TODO Auto-generated method stub		
	}
}
