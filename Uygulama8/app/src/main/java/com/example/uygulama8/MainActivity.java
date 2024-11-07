package com.example.uygulama8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_adsoyad,txt_mail,txt_telefon;
    Button btn_kayıt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_adsoyad=findViewById(R.id.txt_adsoyad);
        txt_mail=findViewById(R.id.txt_mail);
        txt_telefon=findViewById(R.id.txt_telefon);

        btn_kayıt=findViewById(R.id.btn_kaydol);

        btn_kayıt.setOnClickListener(v -> kaydet());


    }

    private void kaydet() {

        if(TextUtils.isEmpty(txt_adsoyad.getText().toString())||TextUtils.isEmpty(txt_telefon.getText().toString())||TextUtils.isEmpty(txt_mail.getText().toString())){
            Toast.makeText(this, "Mail, telefon ve adsoyad alanları boş bırakılamaz...", Toast.LENGTH_SHORT).show();
        }else{
            if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail.getText()).matches()){
                Toast.makeText(this, "Geçerli bir mail adresi giriniz.", Toast.LENGTH_SHORT).show();
            }else if(!PhoneNumberUtils.isGlobalPhoneNumber(txt_telefon.getText().toString())){
                Toast.makeText(this, "Geçerli bir telefon numarası giriniz", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent=new Intent(MainActivity.this, KayıtActivity.class);
                startActivity(intent);
            }
        }
    }
}