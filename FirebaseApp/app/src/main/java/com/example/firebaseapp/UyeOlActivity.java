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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UyeOlActivity extends AppCompatActivity {

    TextView txt_mail, txt_şifre1, txt_şifre2;

    Button buton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_ol);

        txt_mail=findViewById(R.id.editTextTextEmailAddress3);
        txt_şifre1=findViewById(R.id.editTextTextPassword2);
        txt_şifre2=findViewById(R.id.editTextTextPassword3);

        buton=findViewById(R.id.button3);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail.getText()).matches()){
                    Toast.makeText(UyeOlActivity.this, "Mail adresi geçerli değil...", Toast.LENGTH_SHORT).show();
                }else{
                    if(!txt_şifre1.getText().toString().equals(txt_şifre2.getText().toString())){
                        Toast.makeText(UyeOlActivity.this, "Şifre Uyuşmamaktadır", Toast.LENGTH_SHORT).show();
                    }else{
                        if(TextUtils.isEmpty(txt_mail.getText())||TextUtils.isEmpty(txt_şifre1.getText())||TextUtils.isEmpty(txt_şifre2.getText())){
                            Toast.makeText(UyeOlActivity.this, "Alanlar boş bırakılamaz...", Toast.LENGTH_SHORT).show();
                        }else{
                            FirebaseAuth fa=FirebaseAuth.getInstance();

                            String mail=txt_mail.getText().toString();
                            String şifre=txt_şifre1.getText().toString();

                            fa.createUserWithEmailAndPassword(mail,şifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        fa.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(UyeOlActivity.this, "Doğrulama Maili Gönderildi...", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        Toast.makeText(UyeOlActivity.this, "Kullanıcı Başarılı Bir Şekilde Oluşturuldu.", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(UyeOlActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        fa.signOut();
                                    }else{
                                        Toast.makeText(UyeOlActivity.this, "Kullanıcı oluşturulamadı...", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });


                        }
                    }
                }
            }
        });
    }
}
