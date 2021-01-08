package com.example.transactionapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname="dbTransaction";
    private static final String id="id";

    public DbManager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry="create table tbl_transaction ( id integer primary key autoincrement, date text, particulars text, income text, expends text )";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String qry="DROP TABLE IF EXISTS tbl_transaction";
        db.execSQL(qry);
        onCreate(db);

    }

    public  String addRecord(String date, String particulars, String income, String expends ){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("date",date);
        cv.put("particulars",particulars);
        cv.put("income",income);
        cv.put("expends",expends);
        float res=db.insert("tbl_transaction",null,cv);
        if(res==-1)
            return "Failed";
        else
            return  "Successfully inserted";
    }

    public  String DeleteRecord(String date ){
        SQLiteDatabase db=this.getWritableDatabase();

       Cursor cursor = db.rawQuery("Select * from tbl_transaction where date =?",new String[]{date});

        float res=db.delete("tbl_transaction","date=?",new String[]{date});
        if(res==-1)
            return "Failed";
        else
            return  "Successfully inserted";
    }


    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from tbl_transaction order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return  cursor;
    }






}
