package com.example.ex2json203;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {

    public static String DBNAME = "stgs.db";
    public static String TBNAME = "STAGIAIRE";
    public static String COL1 = "NOM";
    public static String COL2 = "FILIERE";
    public static String COL3 = "AGE";

    public MyDatabase(Context c){
        super(c,DBNAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TBNAME + "("+COL1+" text primary key,"+COL2+" text,"+COL3+" integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE " + TBNAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public static long insert_stagiaire(SQLiteDatabase sqLiteDatabase,Stagiaire s){
        ContentValues ct = new ContentValues();
        ct.put(COL1,s.getNom());
        ct.put(COL2,s.getFiliere());
        ct.put(COL3,s.getAge());
        return  sqLiteDatabase.insert(TBNAME,null,ct);
    }

}
