package com.example.sqlitelist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWrapper extends SQLiteOpenHelper {
	
		public static final String STUDENTS = "Students";
	    public static final String STUDENT_ID = "_id";
	    public static final String STUDENT_NAME = "_name";
	 
	    private static final String DATABASE_NAME = "Students.db";
	    private static final int DATABASE_VERSION = 1;

	    // creation SQLite statement
	    private static final String DATABASE_CREATE = "create table " + STUDENTS
	            + "(" + STUDENT_ID + " integer primary key autoincrement, "
	            + STUDENT_NAME + " text not null);";
	    
	public DataBaseWrapper(Context context) {
		//super(context, name, factory, version);
		 super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		 db.execSQL("DROP TABLE IF EXISTS " + STUDENTS);
	     onCreate(db);
	}
}
