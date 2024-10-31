package com.example.uygulama7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class İkinciAktivite extends AppCompatActivity {


    Button buton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikinci_aktivite);
        buton=findViewById(R.id.button2);
        buton.setOnClickListener(v -> geriDön());
    }

    private void geriDön() {

        Intent birinci_aktivite_intent=new Intent(İkinciAktivite.this,MainActivity.class);
        startActivity(birinci_aktivite_intent);
    }
}
