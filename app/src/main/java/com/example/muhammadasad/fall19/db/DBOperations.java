package com.example.muhammadasad.fall19.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.muhammadasad.fall19.ApplicationContext;

public class DBOperations {
    DatabaseHandler db;

    public  DBOperations(){
        db = new DatabaseHandler(ApplicationContext.getAppContext());
    }

    public long writeUserinDB(User user){
        long isSuccesful= 0;
        ContentValues value = new ContentValues();
        value.put(UserTable.COLUMN_FIRSTNAME,user.getFirstName());
        value.put(UserTable.COLUMN_LASTNAME,user.getLastName());
        value.put(UserTable.COLUMN_EMAIL,user.getEmail());
        value.put(UserTable.COLUMN_ADDRESS,user.getAddress());
        value.put(UserTable.COLUMN_PASSWORD,user.getPassword());
        value.put(UserTable.COLUMN_GENDER,user.getGender());
        value.put(UserTable.COLUMN_PHONENUMBER,user.getPhoneNumber());

        isSuccesful = getWritableSqlDb().insert(UserTable.TABLE_NAME, null,value);

        return isSuccesful;
    }

    public SQLiteDatabase getWritableSqlDb() {
        return  db.getWritableDatabase();

    }

    public SQLiteDatabase getReadableSqlDb() {
        return db.getReadableDatabase();

    }

    public User getUserInformation(String email){
        User myUser = new User();
        String[] projection = {
                UserTable._ID,
                UserTable.COLUMN_FIRSTNAME,
                UserTable.COLUMN_LASTNAME,
                UserTable.COLUMN_GENDER,
                UserTable.COLUMN_PASSWORD,
                UserTable.COLUMN_EMAIL,
                UserTable.COLUMN_ADDRESS,
                UserTable.COLUMN_PHONENUMBER
        };

        String selection = UserTable.COLUMN_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = getReadableSqlDb().query(
                UserTable.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows (Group by)
                null,                   // don't filter by row groups
                null               // The sort order
        );

        while(cursor.moveToNext()) {
            myUser.setAddress(cursor.getString(
                    cursor.getColumnIndexOrThrow(UserTable.COLUMN_ADDRESS)));
            myUser.setEmail(cursor.getString(
                    cursor.getColumnIndexOrThrow(UserTable.COLUMN_EMAIL)));
            myUser.setFirstName(cursor.getString(
                    cursor.getColumnIndexOrThrow(UserTable.COLUMN_FIRSTNAME)));


        }



        return myUser;
    }

}
