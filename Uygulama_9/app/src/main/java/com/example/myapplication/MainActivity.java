package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button buton1,buton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buton1=findViewById(R.id.button);
        buton2=findViewById(R.id.button2);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();

                ft.replace(R.id.frame_layout,new Fragment1());
                ft.commit();


            }
        });
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();

                ft.replace(R.id.frame_layout,new Fragment2());
                ft.commit();
            }
        });
    }
}