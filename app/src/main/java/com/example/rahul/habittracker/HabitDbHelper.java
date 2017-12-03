package com.example.rahul.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rahul on 2017-12-02.
 */

public class HabitDbHelper extends SQLiteOpenHelper {


    // Database name and version
    private static final String DATABASE_NAME = "habitTracker.db";
    private static final int DATABASE_VERSION = 1;

    //initialize the class constructor
    public HabitDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //will create the table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_HABIT_TRACKER = "CREATE TABLE "+ HabitContract.HabitEntry.TABLE_NAME+"("
                + HabitContract.HabitEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + HabitContract.HabitEntry.COLUMN_NAME+" STRING,"
                + HabitContract.HabitEntry.COLUMN_DAILY_HABIT+" INTEGER NOT NULL);";

        db.execSQL(CREATE_TABLE_HABIT_TRACKER);
    }

    //update the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

// inser the data in the table
    public void insertHabit(String name,int habit){

    SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_NAME,name);
        values.put(HabitContract.HabitEntry.COLUMN_DAILY_HABIT,habit);
        db.insert(HabitContract.HabitEntry.TABLE_NAME,null,values);
    }


    //read the data through the database
    public Cursor readHabit(){

        SQLiteDatabase db  = getReadableDatabase();

        String[] projection = {

                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_NAME,
                HabitContract.HabitEntry.COLUMN_DAILY_HABIT,
        };
//return the cursor objects
        Cursor cursor =db.query(HabitContract.HabitEntry.TABLE_NAME,projection,null,null,null,null,null);

            return cursor;
    }
}
