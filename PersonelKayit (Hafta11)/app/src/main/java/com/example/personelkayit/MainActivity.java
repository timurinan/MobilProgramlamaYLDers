package com.example.personelkayit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buton,buton_listele;
    TextView txtAdSoyad, txtMail,txtTelefon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buton=findViewById(R.id.butonEkle);
        buton_listele=findViewById(R.id.btnListele);
        txtAdSoyad=findViewById(R.id.txtAdSoyad);
        txtMail=findViewById(R.id.txtMail);
        txtTelefon=findViewById(R.id.txtTelefon);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adsoyad=txtAdSoyad.getText().toString();
                String mail=txtMail.getText().toString();
                String telefon=txtTelefon.getText().toString();

                Personel personel=new Personel(adsoyad,mail,telefon);

                Veritabani_Islemleri vi=new Veritabani_Islemleri(getApplicationContext());

                vi.ekle(personel);

            }
        });
        buton_listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Kontrolcu_Listele.class);
                startActivity(intent);
            }
        });


    }
}