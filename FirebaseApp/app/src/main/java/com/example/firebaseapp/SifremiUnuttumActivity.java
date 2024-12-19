package com.example.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class SifremiUnuttumActivity extends AppCompatActivity {

    TextView txt_mail;
    Button buton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifremi_unuttum);
        txt_mail=findViewById(R.id.editTextTextEmailAddress2);
        buton=findViewById(R.id.button2);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail.getText()).matches()){
                    Toast.makeText(SifremiUnuttumActivity.this, "E-mail geçerli değil...", Toast.LENGTH_SHORT).show();
                }else {
                    if(TextUtils.isEmpty(txt_mail.getText())){
                        Toast.makeText(SifremiUnuttumActivity.this, "Mail alanı boş bırakılamaz", Toast.LENGTH_SHORT).show();
                    }else{
                        String mail=txt_mail.getText().toString();

                        FirebaseAuth fa=FirebaseAuth.getInstance();

                        fa.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(SifremiUnuttumActivity.this, "Şifre reset maili gönderildi", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(SifremiUnuttumActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    fa.signOut();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}
