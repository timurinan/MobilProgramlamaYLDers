package com.example.uygulama9;

import java.io.Serializable;

public class Müşteri implements Serializable {

    private String adsoyad, telefon,mail;

    public Müşteri(String adsoyad, String telefon, String mail) {
        this.adsoyad = adsoyad;
        this.telefon = telefon;
        this.mail = mail;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
