package com.example.sqlitelist;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ListActivity {
	
	private StudentOperations studentDBoperation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 studentDBoperation = new StudentOperations(this);
	     studentDBoperation.open();
	 
	     List values = studentDBoperation.getAllStudents();
	 
	        // Use the SimpleCursorAdapter to show the
	        // elements in a ListView
	     ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, values);
	     
	     setListAdapter(adapter);
		
	}
	
	 public void addUser(View view) {
		 
	        ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
	 
	        EditText text = (EditText) findViewById(R.id.editText1);
	        Student stud = studentDBoperation.addStudent(text.getText().toString());
	 
	        adapter.add(stud);
	 
	    }
	 
	    public void deleteFirstUser(View view) {
	 
	        ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
	        Student stud = null;
	 
	        if (getListAdapter().getCount() > 0) {
	            stud = (Student) getListAdapter().getItem(0);
	            studentDBoperation.deleteStudent(stud);
	            adapter.remove(stud);
	        }
	 
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

}
