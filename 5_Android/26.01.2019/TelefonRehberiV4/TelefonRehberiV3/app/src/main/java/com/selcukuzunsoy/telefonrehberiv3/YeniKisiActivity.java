package com.selcukuzunsoy.telefonrehberiv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.selcukuzunsoy.telefonrehberiv3.daos.KisiDAO;
import com.selcukuzunsoy.telefonrehberiv3.models.Kisi;

public class YeniKisiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_kisi);
        Log.i("YASAM", "ON_CREATE_BASLADI");

        String type = getIntent().getExtras().getString("type");
        Toast.makeText(this, "Tip:" + type, Toast.LENGTH_LONG).show();
    }

    public void kisiKaydet(View view) {

        Kisi kisi = new Kisi();

        String ad = ((EditText) findViewById(R.id.txtAd)).getText().toString();
        String soyad = ((EditText) findViewById(R.id.txtSoyad)).getText().toString();
        String tel = ((EditText) findViewById(R.id.txtTel)).getText().toString();
        String email = ((EditText) findViewById(R.id.txtEmail)).getText().toString();

        kisi.setAd(ad);
        kisi.setSoyad(soyad);
        kisi.setEmail(email);
        kisi.setTel(tel);

        if(new KisiDAO(getApplicationContext()).ekleKisi(kisi)) {
            Toast.makeText(getApplicationContext(), "Kayıt Edildi !", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Başarısız !", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("YASAM", "ON_START_BASLADI");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("YASAM", "ON_STOP_BASLADI");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("YASAM", "ON_PAUSE_BASLADI");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("YASAM", "ON_DESTROY_BASLADI");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("YASAM", "ON_RESUME_BASLADI");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("YASAM", "ON_RESTART_BASLADI");
    }
}
