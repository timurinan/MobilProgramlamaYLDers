package com.example.viewpager2uygulamasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHesap extends Fragment {

    TextView txt_hesapsahibi,txt_hesaptürü,txt_bakiye;
    Hesap hesap;

    public FragmentHesap() {

        super(R.layout.activity_hesap);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View görünüm=inflater.inflate(R.layout.activity_hesap,container,false);

        txt_bakiye=görünüm.findViewById(R.id.txt_hesapbakiye);
        txt_hesapsahibi=görünüm.findViewById(R.id.txt_hesapsahibi);
        txt_hesaptürü=görünüm.findViewById(R.id.txt_hesaptürü);

       txt_hesaptürü.setText(hesap.getHesaptürü().toString());
       txt_hesapsahibi.setText(hesap.getHesapsahibi().toString());
       txt_bakiye.setText(hesap.getBakiye()+"");

        return görünüm;
    }
    public void setHesapSahibi(Hesap hesap){
        this.hesap=hesap;
    }
}
