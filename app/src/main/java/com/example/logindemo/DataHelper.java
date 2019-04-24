package com.example.logindemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Information.db";
    public static final String TABLE_NAME = "info";
    public static final String ROLL = "Roll";
    public static final String NAME = "Name";
    public static final String ADDRESS = "Address";
    public static final String HOME_DISTRICT = "Home_District";
    public static final String MOBILE_NUMBER = "Mobile_Number";
    public static final String GENDER = "Gendar";
    public static final String SSC = "Ssc";
    public static final String HSC = "Hsc";
    public static final String DIPLOMA = "Diploma";
    public static final String BSC = "Bsc";


    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql = "create table " + TABLE_NAME + "(" + ROLL + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT," + ADDRESS + " TEXT, " + HOME_DISTRICT + " TEXT," + MOBILE_NUMBER + " TEXT," + GENDER + " TEXT," + SSC + " TEXT, " + HSC + " TEXT, " + DIPLOMA + " TEXT," + BSC + " TEXT )";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("Drop table if exists " + TABLE_NAME);
        onCreate(db);


    }

    public long insertData(int Roll, String Name,String Address,String Home_district,String Mobile_number,String Gender,String Ssc, String Hsc, String Diploma,String Bsc )
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues  contentValues = new ContentValues();
        contentValues.put(ROLL,Roll);
        contentValues.put(NAME,Name);
        contentValues.put(ADDRESS,Address);
        contentValues.put(HOME_DISTRICT,Home_district);
        contentValues.put(MOBILE_NUMBER,Mobile_number);
        contentValues.put(GENDER,Gender);
        contentValues.put(SSC,Ssc);
        contentValues.put(HSC,Hsc);
        contentValues.put(DIPLOMA,Diploma);
        contentValues.put(BSC,Bsc);

        long row = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        return row;



    }

    public Cursor showdata(Integer valu)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" where "+ROLL+" = "+valu+" ",null);


        return cursor;

    }

    public boolean UpdateDate(int Roll, String Name,String Address,String Home_district,String Mobile_number,String Gender,String Ssc, String Hsc, String Diploma,String Bsc )
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues  contentValues = new ContentValues();
        contentValues.put(ROLL,Roll);
        contentValues.put(NAME,Name);
        contentValues.put(ADDRESS,Address);
        contentValues.put(HOME_DISTRICT,Home_district);
        contentValues.put(MOBILE_NUMBER,Mobile_number);
        contentValues.put(GENDER,Gender);
        contentValues.put(SSC,Ssc);
        contentValues.put(HSC,Hsc);
        contentValues.put(DIPLOMA,Diploma);
        contentValues.put(BSC,Bsc);
        sqLiteDatabase.update(TABLE_NAME,contentValues,ROLL+" = ?",new String[]{String.valueOf(Roll)});
        return true;


    }

    public int DeleteRow(int roll)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int lon = sqLiteDatabase.delete(TABLE_NAME,ROLL+" = ? ",new String[]{String.valueOf(roll)});

        return lon;

    }
}
