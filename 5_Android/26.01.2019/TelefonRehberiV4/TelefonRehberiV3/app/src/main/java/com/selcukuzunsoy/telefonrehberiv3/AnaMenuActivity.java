package com.selcukuzunsoy.telefonrehberiv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnaMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_menu);
    }


    public void yeniKisiEkrani(View view){

        Intent intent = new Intent(this, YeniKisiActivity.class);
        intent.putExtra("type","yeni");
        startActivity(intent);



    }

}
