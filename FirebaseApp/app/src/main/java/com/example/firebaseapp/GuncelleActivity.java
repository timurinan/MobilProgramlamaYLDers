package com.example.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GuncelleActivity extends AppCompatActivity {

    TextView txt_adsoyad_guncelle, txt_mail_guncelle,txt_telefon_guncelle;
     Button btn_guncelle;

     FirebaseDatabase fd=FirebaseDatabase.getInstance();
     DatabaseReference dr=fd.getReference("müşteriler");

     Müşteri güncellenecek_müşteri;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);

        güncellenecek_müşteri= (Müşteri) getIntent().getSerializableExtra("müşteri");

        txt_adsoyad_guncelle=findViewById(R.id.txt_adsoyad_guncelle);
        txt_mail_guncelle=findViewById(R.id.txt_mail_guncelle);
        txt_telefon_guncelle=findViewById(R.id.txt_telefon_guncelle);
        btn_guncelle=findViewById(R.id.btn_guncelle);

        txt_adsoyad_guncelle.setText(güncellenecek_müşteri.getAdsoyad());
        txt_mail_guncelle.setText(güncellenecek_müşteri.getMail());
        txt_telefon_guncelle.setText(güncellenecek_müşteri.getTelefon());

        btn_guncelle.setOnClickListener(v -> guncelle());
    }

    private void guncelle() {

        if(TextUtils.isEmpty(txt_adsoyad_guncelle.getText())||TextUtils.isEmpty(txt_mail_guncelle.getText())||TextUtils.isEmpty(txt_telefon_guncelle.getText())){
            Toast.makeText(this, "Alanlar boş bırakılamaz", Toast.LENGTH_SHORT).show();
        }else{
            if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail_guncelle.getText()).matches()){
                Toast.makeText(this, "Mail formatı yanlış, düzeltiniz", Toast.LENGTH_SHORT).show();
            }else{
                if(!PhoneNumberUtils.isGlobalPhoneNumber(txt_telefon_guncelle.getText().toString())){
                    Toast.makeText(this, "Telefon numarası doğru formatta değil...", Toast.LENGTH_SHORT).show();
                }else{
                    Müşteri güncel_müşteri=new Müşteri(txt_adsoyad_guncelle.getText().toString(),
                            txt_mail_guncelle.getText().toString(),txt_telefon_guncelle.getText().toString());
                    güncel_müşteri.setUid(güncellenecek_müşteri.getUid());
                    dr.child(güncellenecek_müşteri.getUid()).setValue(güncel_müşteri);
                    Toast.makeText(this, "Güncelleme İşlemi  Başarılı...", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(GuncelleActivity.this, ListelemeActivity.class);
                    startActivity(intent);
                }
            }
        }
    }
}
