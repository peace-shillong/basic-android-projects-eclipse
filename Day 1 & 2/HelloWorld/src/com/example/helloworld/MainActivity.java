package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
    
    public void openActivity(View v)
    {
    	int i=v.getId();
    	
    	if(i==R.id.button1)
    	{
    	   Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    	}
    	else if(i==R.id.button2){
    		Intent intent=new Intent(this,SecondActivity.class);
    		startActivity(intent);
    	}
    	
    }

	
    
}
