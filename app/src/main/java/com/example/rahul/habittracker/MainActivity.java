package com.example.rahul.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView displayView = (TextView) findViewById(R.id.habit);
        HabitDbHelper habitDbHelper = new HabitDbHelper(this);
        Cursor cursor = habitDbHelper.readHabit();

        habitDbHelper.insertHabit("Rahul", HabitContract.HabitEntry.HABIT_CODING);
        habitDbHelper.insertHabit("George", HabitContract.HabitEntry.HABIT_WORKOUT);
        habitDbHelper.insertHabit("Ronan", HabitContract.HabitEntry.HABIT_CODING);


        try{
            displayView.setText("The Habit table contains " + cursor.getCount() + " habit.\n\n");
            displayView.append(HabitContract.HabitEntry._ID + " - " + HabitContract.HabitEntry.COLUMN_NAME + "\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_NAME);

            while (cursor.moveToNext()){
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" + currentID + " - " +
                        currentName));
            }
        }finally {
            cursor.close();
        }
    }
}