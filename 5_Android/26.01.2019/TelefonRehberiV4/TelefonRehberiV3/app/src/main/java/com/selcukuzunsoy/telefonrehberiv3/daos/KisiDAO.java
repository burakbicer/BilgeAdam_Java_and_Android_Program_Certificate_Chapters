package com.selcukuzunsoy.telefonrehberiv3.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.util.Log;

import com.selcukuzunsoy.telefonrehberiv3.db.DbYardimcisi;
import com.selcukuzunsoy.telefonrehberiv3.models.Kisi;

import java.util.ArrayList;
import java.util.List;

public class KisiDAO extends DbYardimcisi {
    public KisiDAO(@Nullable Context context) {
        super(context);
    }

    public Boolean ekleKisi(Kisi kisi) {

        SQLiteDatabase manager = this.getWritableDatabase();
        try {

            ContentValues kayitEdilecekKisi = new ContentValues();
            kayitEdilecekKisi.put(TEL_COL_AD, kisi.getAd());
            kayitEdilecekKisi.put(TEL_COL_SOYAD, kisi.getSoyad());
            kayitEdilecekKisi.put(TEL_COL_EMAIL, kisi.getEmail());
            kayitEdilecekKisi.put(TEL_COL_TEL, kisi.getTel());
            manager.insert(TEL_TN, null, kayitEdilecekKisi);
            return true;
        } catch (Exception e) {
            Log.e("TELEFONREHBERI", e.getMessage());
            return false;
        } finally {
            if (manager.isOpen()) manager.close();
        }

    }

    public Kisi kisiGetir(Integer kid) {

        SQLiteDatabase manager = this.getReadableDatabase();
        try {

            String sql = "SELECT * FROM " + TEL_TN + " WHERE " + TEL_COL_ID + " = " + kid;

            Cursor res = manager.rawQuery(sql, null);
            res.moveToFirst();
            if (!res.isAfterLast()) {
                Integer id = res.getInt(res.getColumnIndex(TEL_COL_ID));
                String ad = res.getString(res.getColumnIndex(TEL_COL_AD));
                String soyad = res.getString(res.getColumnIndex(TEL_COL_SOYAD));
                String email = res.getString(res.getColumnIndex(TEL_COL_EMAIL));
                String tel = res.getString(res.getColumnIndex(TEL_COL_TEL));

                return new Kisi(id, ad, soyad, email, tel);
            }

        } catch (Exception e) {
            Log.e("TELEFONREHBERI", e.getMessage());
            return null;
        } finally {
            if (manager.isOpen()) manager.close();
        }
        return null;

    }

    public Boolean kisiSil(Integer id) {

        SQLiteDatabase manager = this.getWritableDatabase();
        try {
            manager.delete(TEL_TN, "id=? ", new String[]{Integer.toString(id)});
            return true;
        } catch (Exception e) {
            Log.e("TELEFONREHBERI", e.getMessage());
            return false;
        } finally {
            if (manager.isOpen()) manager.close();
        }
    }

    public Boolean kisiGuncelle(Kisi kisi) {

        SQLiteDatabase manager = this.getWritableDatabase();
        try {

            ContentValues kayitEdilecekKisi = new ContentValues();
            kayitEdilecekKisi.put(TEL_COL_AD, kisi.getAd());
            kayitEdilecekKisi.put(TEL_COL_SOYAD, kisi.getSoyad());
            kayitEdilecekKisi.put(TEL_COL_EMAIL, kisi.getEmail());
            kayitEdilecekKisi.put(TEL_COL_TEL, kisi.getTel());
            manager.update(TEL_TN, kayitEdilecekKisi, "id=? ", new String[]{Integer.toString(kisi.getId())});
            return true;
        } catch (Exception e) {
            Log.e("TELEFONREHBERI", e.getMessage());
            return false;
        } finally {
            if (manager.isOpen()) manager.close();
        }


    }

    public Integer kayitSayisi() {
        SQLiteDatabase manager = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(manager, TEL_TN);
        return numRows;
    }

    public List<Kisi> tumKisileriGetir() {

        List<Kisi> kisiler = new ArrayList<>();
        SQLiteDatabase manager = this.getReadableDatabase();
        try {

            String sql = "SELECT * FROM " + TEL_TN;

            Cursor res = manager.rawQuery(sql, null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                Integer id = res.getInt(res.getColumnIndex(TEL_COL_ID));
                String ad = res.getString(res.getColumnIndex(TEL_COL_AD));
                String soyad = res.getString(res.getColumnIndex(TEL_COL_SOYAD));
                String email = res.getString(res.getColumnIndex(TEL_COL_EMAIL));
                String tel = res.getString(res.getColumnIndex(TEL_COL_TEL));

                kisiler.add(new Kisi(id, ad, soyad, email, tel));
                res.moveToNext();
            }
            return kisiler;
        } catch (Exception e) {
            Log.e("TELEFONREHBERI", e.getMessage());
            return null;
        } finally {
            if (manager.isOpen()) manager.close();
        }
    }


}


