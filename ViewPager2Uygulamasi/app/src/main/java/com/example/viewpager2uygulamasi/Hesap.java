package com.example.viewpager2uygulamasi;

public class Hesap {

    private String hesapsahibi, hesaptürü;
    private double bakiye;

    public Hesap(String hesapsahibi, String hesaptürü, double bakiye) {
        this.hesapsahibi = hesapsahibi;
        this.hesaptürü = hesaptürü;
        this.bakiye = bakiye;
    }

    public String getHesapsahibi() {
        return hesapsahibi;
    }

    public void setHesapsahibi(String hesapsahibi) {
        this.hesapsahibi = hesapsahibi;
    }

    public String getHesaptürü() {
        return hesaptürü;
    }

    public void setHesaptürü(String hesaptürü) {
        this.hesaptürü = hesaptürü;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }
}
