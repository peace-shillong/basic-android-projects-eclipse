package com.example.day7savingsharedpref;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	
	 SharedPreferences sharedpreferences;
	    TextView name;
	    TextView email;
	    public static final String mypreference = "mypref";
	    public static final String Name = "nameKey";
	    public static final String Email = "emailKey";

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        name = (TextView) findViewById(R.id.etName);
	        email = (TextView) findViewById(R.id.etEmail);
	        sharedpreferences = getSharedPreferences(mypreference,
	                Context.MODE_PRIVATE);
	        if (sharedpreferences.contains(Name)) {
	            name.setText(sharedpreferences.getString(Name, ""));
	        }
	        if (sharedpreferences.contains(Email)) {
	            email.setText(sharedpreferences.getString(Email, ""));

	        }

	    }

	    public void Save(View view) {
	        String n = name.getText().toString();
	        String e = email.getText().toString();
	        SharedPreferences.Editor editor = sharedpreferences.edit();
	        editor.putString(Name, n);
	        editor.putString(Email, e);
	        editor.commit();
	    }

	    public void clear(View view) {    	
	    	name = (TextView) findViewById(R.id.etName);
	        email = (TextView) findViewById(R.id.etEmail);
	        name.setText("");
	        email.setText("");

	    }

	    public void Get(View view) {
	        name = (TextView) findViewById(R.id.etName);
	        email = (TextView) findViewById(R.id.etEmail);
	        sharedpreferences = getSharedPreferences(mypreference,
	                Context.MODE_PRIVATE);

	        if (sharedpreferences.contains(Name)) {
	            name.setText(sharedpreferences.getString(Name, ""));
	        }
	        if (sharedpreferences.contains(Email)) {
	            email.setText(sharedpreferences.getString(Email, ""));

	        }
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
