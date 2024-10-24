package com.example.uygulama5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buton;
    TextView txtSelam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buton=findViewById(R.id.btnMerhaba);
        txtSelam=findViewById(R.id.txtMerhaba);
        buton.setOnClickListener(v -> yenimetot());

    }
    public void yenimetot(){
        txtSelam.setText("Merhaba Android Ben Geldim...");
    }
}