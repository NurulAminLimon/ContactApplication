package com.example.nextlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dataconnection extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Information.db";
    public static final String TABLE_NAME = "student";
    public static final String ROLL = "Roll";
    public static final String NAME = "Name";
    public static final String ADDRESS = "Address";


    public Dataconnection( Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+TABLE_NAME+"( "+ROLL+" INTEGER PRIMARY KEY, "+NAME+" TEXT(25),"+ADDRESS+" TEXT(25) )";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exists "+TABLE_NAME);
        onCreate(db);

    }

    public long Datainsert(Integer roll, String name, String address)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROLL,roll);
        contentValues.put(NAME,name);
        contentValues.put(ADDRESS,address);
        long rowid = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;
    }


    public Cursor displydate(String n)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" where "+NAME+" = '"+n+"' ",null);
        return cursor;


    }
}
