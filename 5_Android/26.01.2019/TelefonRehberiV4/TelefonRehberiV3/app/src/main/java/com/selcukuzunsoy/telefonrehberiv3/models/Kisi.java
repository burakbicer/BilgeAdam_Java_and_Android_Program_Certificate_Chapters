package com.selcukuzunsoy.telefonrehberiv3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kisi {

    private Integer id;
    private String ad;
    private String soyad;
    private String email;
    private String tel;

}
