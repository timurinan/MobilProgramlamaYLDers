package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView txt_şifremi_unuttum, txt_üye_ol,txt_mail,txt_şifre;
    Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_şifremi_unuttum=findViewById(R.id.textView2);
        txt_üye_ol=findViewById(R.id.textView);
        txt_mail=findViewById(R.id.editTextTextEmailAddress);
        txt_şifre=findViewById(R.id.editTextTextPassword);

        txt_şifremi_unuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SifremiUnuttumActivity.class);
                startActivity(intent);
            }
        });

        txt_üye_ol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,UyeOlActivity.class);
                startActivity(intent);
            }
        });
        buton=findViewById(R.id.button);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail.getText()).matches()){
                    Toast.makeText(MainActivity.this, "Mail adresi geçerli değil...", Toast.LENGTH_SHORT).show();
                }else{
                    if(TextUtils.isEmpty(txt_mail.getText())||TextUtils.isEmpty(txt_şifre.getText())){
                        Toast.makeText(MainActivity.this, "Mail veya şifre boş bırakılamaz.", Toast.LENGTH_SHORT).show();
                    }else{
                        FirebaseAuth fa=FirebaseAuth.getInstance();

                        String mail=txt_mail.getText().toString();
                        String şifre=txt_şifre.getText().toString();
                        fa.signInWithEmailAndPassword(mail,şifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent=new Intent(MainActivity.this,ListelemeActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(MainActivity.this, "Mail veya şifre yanlış...", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}