package com.example.rahul.habittracker;

import android.provider.BaseColumns;

/**
 * Created by rahul on 2017-12-02.
 */

public final class HabitContract {

    //initialize the constructor
    public HabitContract() {}

    public static final class HabitEntry implements BaseColumns {

        // Table and column names
        public final static String TABLE_NAME = "HabitsTracker";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "Name";
        public final static String COLUMN_DAILY_HABIT = "Habits";
        public static final int HABIT_CODING = 0;
        public static final int HABIT_RUNNING = 1;
        public static final int HABIT_WORKOUT = 2;


    }

}
