package com.example.muhammadasad.fall19.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "classwork.db";
    public static final int DATABASE_VERSION = 1;

    public  DatabaseHandler(Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserTable.TABLE_NAME + " (" +
                    UserTable._ID + " INTEGER PRIMARY KEY," +
                    UserTable.COLUMN_FIRSTNAME + " TEXT," +
                    UserTable.COLUMN_LASTNAME + " TEXT," +
                    UserTable.COLUMN_ADDRESS + " TEXT," +
                    UserTable.COLUMN_PHONENUMBER + " TEXT," +
                    UserTable.COLUMN_PASSWORD + " TEXT," +
                    UserTable.COLUMN_GENDER + " TEXT," +
                    UserTable.COLUMN_EMAIL + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserTable.TABLE_NAME;

}
