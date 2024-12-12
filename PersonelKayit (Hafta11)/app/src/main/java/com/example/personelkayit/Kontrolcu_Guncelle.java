package com.example.personelkayit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Kontrolcu_Guncelle extends AppCompatActivity {

    TextView txtAdSoyad,txtMail,txtTelefon;
    Button btnGuncelle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);

        txtAdSoyad=findViewById(R.id.txtAdSoyad_Guncelle);
        txtTelefon=findViewById(R.id.txtTelefon_Guncelle);
        txtMail=findViewById(R.id.txtMail_Guncelle);

        btnGuncelle=findViewById(R.id.butonGuncelle);

        int id=getIntent().getExtras().getInt("personel_id");

        Veritabani_Islemleri vi=new Veritabani_Islemleri(getApplicationContext());

        Personel personel=vi.personelGetir(id);

        txtAdSoyad.setText(personel.getAdsoyad());
        txtTelefon.setText(personel.getTelefon());
        txtMail.setText(personel.getMail());

        btnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adsoyad=txtAdSoyad.getText().toString();
                String mail=txtMail.getText().toString();
                String telefon=txtTelefon.getText().toString();
                Personel personel1=new Personel(adsoyad,mail,telefon);
                personel1.setId(id);
                vi.guncelle(personel1);
                Intent intent=new Intent(Kontrolcu_Guncelle.this,Kontrolcu_Listele.class);
                startActivity(intent);
            }
        });




    }
}