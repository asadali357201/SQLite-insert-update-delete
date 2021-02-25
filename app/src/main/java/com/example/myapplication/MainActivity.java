package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getWritableDatabase();
//        simple query
        Cursor cursor=database.rawQuery("SELECT NAME,PRICE FROM PRODUCTS",new String[]{});

//        query with where clause variation
//        Cursor cursor=database.rawQuery("SELECT NAME,PRICE FROM PRODUCTS WHERE NAME=?",new String[]{"Jam"});

//        updatation and deletion od data
        ContentValues values=new ContentValues();
        values.put("PRICE",120);
        database.update("PRODUCTS",values,"_id=?",new String[]{"1"});
        database.delete("PRODUCTS","_id=?",new String[]{"2"});




        if(cursor!=null){
            cursor.moveToNext();
        }
        StringBuilder builder=new StringBuilder();

        do{
            String name =cursor.getString(0);
            double price=cursor.getDouble(1);
            builder.append("NAME : "+name+"_ PRICE : "+price+"\n");
        }
        while (cursor.moveToNext());
        TextView text=findViewById(R.id.text);
        text.setText(builder.toString());

    }
}