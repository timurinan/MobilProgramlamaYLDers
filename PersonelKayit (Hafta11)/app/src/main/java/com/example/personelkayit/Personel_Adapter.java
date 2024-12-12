package com.example.personelkayit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Personel_Adapter extends ArrayAdapter<Personel> {
    Context context;
    ArrayList<Personel> çalışanlar=new ArrayList<Personel>();

    public Personel_Adapter(@NonNull Context context, ArrayList<Personel> çalışanlar) {
        super(context,0);
        this.context=context;
        this.çalışanlar=çalışanlar;

    }

    public int getCount(){
        return çalışanlar.size();
    }

    public Personel getItem(int i){
        return çalışanlar.get(i);
    }

    public long getItemId(int i){
        return çalışanlar.get(i).getId();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Personel personel=getItem(position);

        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.list_view,parent,false);
        }

        TextView txt_id=convertView.findViewById(R.id.textView2);
        TextView txt_adsoyad=convertView.findViewById(R.id.textView4);
        TextView txt_mail=convertView.findViewById(R.id.textView6);
        TextView txt_telefon=convertView.findViewById(R.id.textView8);

        txt_id.setText(String.valueOf(personel.getId()));
        txt_adsoyad.setText(personel.getAdsoyad());
        txt_mail.setText(personel.getMail());
        txt_telefon.setText(personel.getTelefon());

        return convertView;
    }
}
