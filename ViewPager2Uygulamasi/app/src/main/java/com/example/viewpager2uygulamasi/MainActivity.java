package com.example.viewpager2uygulamasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp2=findViewById(R.id.viewPager2);

        Hesap hesap1=new Hesap("Timur İnan","Dolar",1000);
        Hesap hesap2=new Hesap("İbrahim Bahçekapılı","Türk Lirası",50000);
        Hesap hesap3=new Hesap("Murat Dolaş","Euro",200000);

        FragmentHesap fh1=new FragmentHesap();
        fh1.setHesapSahibi(hesap1);

        FragmentHesap fh2=new FragmentHesap();
        fh2.setHesapSahibi(hesap2);

        FragmentHesap fh3=new FragmentHesap();
        fh3.setHesapSahibi(hesap3);

        FragmentAdapter fa=new FragmentAdapter(getSupportFragmentManager(),getLifecycle());

        fa.fragmentEkle(fh1);
        fa.fragmentEkle(fh2);
        fa.fragmentEkle(fh3);

        vp2.setAdapter(fa);

    }
}