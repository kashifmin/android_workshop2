package me.kashifminhaj.starwars.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kashif on 23/2/17.
 */

public class SQLiteHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "starwars";

    // Table name for storing character info
    private static final String TABLE_USER = "people";

    public SQLiteHandler(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_PEOPLE_TABLE = "create table " + TABLE_USER +
                "( id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "dob TEXT, " +
                "height TEXT );" ;
        sqLiteDatabase.execSQL(CREATE_PEOPLE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addChar(String name, String dob, String height) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("dob", dob);
        cv.put("height", height);

        db.insert(TABLE_USER, null, cv);


    }
}
