package com.selcukuzunsoy.telefonrehberiv3.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbYardimcisi extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "TELEFONREHBERI.db";
    public static final String TEL_TN="rehber";
    public static final String TEL_COL_ID = "id";
    public static final String TEL_COL_AD="ad";
    public static final String TEL_COL_SOYAD= "soyad";
    public static final String TEL_COL_TEL="tel";
    public static final String TEL_COL_EMAIL="email";
    public static final int ver = 1;
    private static final String TEL_TN_YEDEK = "rehber_yedek";


    public DbYardimcisi(@Nullable Context context) {
        super(context, DATABASE_NAME, null, ver);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+ TEL_TN +"("
        + TEL_COL_ID+" integer primary key,"+ TEL_COL_AD+" text,"
        + TEL_COL_SOYAD+" text,"+TEL_COL_EMAIL+" text,"+TEL_COL_TEL+" text)"
        );

        //CREATE TABLE rehber(id integer primary key, ad text, soyad text, email text, tel text);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("CREATE TABLE "+ TEL_TN_YEDEK +"("
                + TEL_COL_ID+" integer primary key,"+ TEL_COL_AD+" text,"
                + TEL_COL_SOYAD+" text,"+TEL_COL_EMAIL+" text,"+TEL_COL_TEL+" text)"
        );

        sqLiteDatabase.execSQL("INSERT INTO "+TEL_TN_YEDEK+" SELECT * FROM "+ TEL_TN);
        onCreate(sqLiteDatabase);

    }
}
