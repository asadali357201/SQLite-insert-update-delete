package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private static final String dbname="mydb";
    private static final int version=1;
    public MyHelper(Context context){

        super(context,dbname,null,version);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE PRODUCTS(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DESCRIPTION TEXT,PRICE REAL)";
        db.execSQL(sql);
        insertdata("Jam","Jam",300.67,db);
        insertdata("juice","orange juice",200,db);
        insertdata("Pulp","mango pulp",150,db);

//        on create called only one time when user install the app

    }
    private void insertdata(String name,String description,double price,SQLiteDatabase dtb)
    {
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("DESCRIPTION",description);
        values.put("PRICE",price);
        dtb.insert("PRODUCTS",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if you make some changes to the app than we can change the version and calls the on upgrade method to make changes to the app

    }
}
