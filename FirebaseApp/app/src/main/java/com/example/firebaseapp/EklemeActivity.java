package com.example.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EklemeActivity extends AppCompatActivity {

    TextView txt_adsoyad, txt_mail, txt_telefon;
    Button btn_ekle;

    FirebaseDatabase fd=FirebaseDatabase.getInstance();
    DatabaseReference dr=fd.getReference("müşteriler");
    DatabaseReference drwithkey;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekleme);

        txt_adsoyad=findViewById(R.id.txt_adsoyad);
        txt_mail=findViewById(R.id.txt_mail);
        txt_telefon=findViewById(R.id.txt_telefon);
        btn_ekle=findViewById(R.id.button4);

        btn_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(txt_mail.getText())||TextUtils.isEmpty(txt_telefon.getText())||TextUtils.isEmpty(txt_adsoyad.getText())){
                    Toast.makeText(EklemeActivity.this, "Alanlar boş bırakılamaz...", Toast.LENGTH_SHORT).show();
                }else{
                    if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail.getText()).matches()){
                        Toast.makeText(EklemeActivity.this, "Geçerli bir mail giriniz", Toast.LENGTH_SHORT).show();
                    }else{
                        if(!PhoneNumberUtils.isGlobalPhoneNumber(txt_telefon.getText().toString())){
                            Toast.makeText(EklemeActivity.this, "Geçerli bir telefon giriniz...", Toast.LENGTH_SHORT).show();
                        }else{
                            Müşteri müşteri=new Müşteri(txt_adsoyad.getText().toString(),txt_mail.getText().toString(),txt_telefon.getText().toString());
                            String key=dr.push().getKey();
                            drwithkey=fd.getReference("müşteriler/"+key);
                            müşteri.setUid(key);
                            drwithkey.setValue(müşteri);
                            Toast.makeText(EklemeActivity.this, "Müşteri başarıyla eklendi...", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(EklemeActivity.this, ListelemeActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}
