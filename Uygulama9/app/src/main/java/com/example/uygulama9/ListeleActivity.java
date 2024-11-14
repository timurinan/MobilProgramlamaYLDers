package com.example.uygulama9;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListeleActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView r_view;

    ArrayList<Müşteri> müşteriler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        fab=findViewById(R.id.btn_fab);

        r_view=findViewById(R.id.recycler_view);

        müşteriler= (ArrayList<Müşteri>) getIntent().getSerializableExtra("müşteriler");

        CustomAdapter ca=new CustomAdapter(getLayoutInflater(),müşteriler);
        r_view.setAdapter(ca);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        r_view.setLayoutManager(llm);

    fab.setOnClickListener(v -> mainActivityeGeç());

    }

    private void mainActivityeGeç() {

        Intent intent=new Intent(ListeleActivity.this,MainActivity.class);
        intent.putExtra("adet",müşteriler.size());
        intent.putExtra("müşteriler",müşteriler);
        startActivity(intent);
    }
}
