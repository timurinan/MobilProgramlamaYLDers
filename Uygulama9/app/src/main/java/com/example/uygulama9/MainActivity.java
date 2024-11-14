package com.example.uygulama9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txt_adsyoad,txt_telefon,txt_mail;
    ArrayList<Müşteri> müşteriler=new ArrayList<>();

    Button buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_adsyoad=findViewById(R.id.txtAdSoyad);
        txt_mail=findViewById(R.id.txt_mail);
        txt_telefon=findViewById(R.id.txt_Telefon);

        buton=findViewById(R.id.btn_Kaydo);

        buton.setOnClickListener(v -> listeleekranınaGeç());

        int adet=getIntent().getIntExtra("adet",0);
        if(adet!=0)
         müşteriler= (ArrayList<Müşteri>) getIntent().getSerializableExtra("müşteriler");


    }

    private void listeleekranınaGeç() {
        if (TextUtils.isEmpty(txt_adsyoad.getText())||TextUtils.isEmpty(txt_mail.getText())||TextUtils.isEmpty(txt_telefon.getText())){
            Toast.makeText(this, "Alanlar boş bırakılamaz...", Toast.LENGTH_SHORT).show();
        }else{
            String adsoyad=txt_adsyoad.getText().toString();
            String mail=txt_mail.getText().toString();
            String telefon=txt_telefon.getText().toString();

            Müşteri müşteri=new Müşteri(adsoyad,telefon,mail);
            müşteriler.add(müşteri);

            Intent intent=new Intent(MainActivity.this,ListeleActivity.class);
            intent.putExtra("müşteriler",müşteriler);
            startActivity(intent);
        }
    }
}