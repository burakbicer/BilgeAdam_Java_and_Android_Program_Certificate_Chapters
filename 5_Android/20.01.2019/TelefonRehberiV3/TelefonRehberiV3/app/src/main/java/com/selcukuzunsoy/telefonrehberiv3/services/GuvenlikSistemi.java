package com.selcukuzunsoy.telefonrehberiv3.services;

import com.selcukuzunsoy.telefonrehberiv3.models.Kullanici;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuvenlikSistemi {
    private static final GuvenlikSistemi ourInstance = new GuvenlikSistemi();

    public static List<Kullanici> kullaniciListesi = new ArrayList<>();

    public static GuvenlikSistemi getInstance() {
        return ourInstance;
    }


    public static Boolean kullaniciVarmi(String kadi, String sifre) {

        for (Kullanici kul : kullaniciListesi) {
            if (kul.getKadi().equals(kadi) && kul.getSifre().equals(sifre)) return true;
        }
        return false;
    }


    private GuvenlikSistemi() {

        kullaniciListesi.add(new Kullanici("a@gmail.com", "123"));
        kullaniciListesi.add(new Kullanici("b@gmail.com", "123"));

    }
}
