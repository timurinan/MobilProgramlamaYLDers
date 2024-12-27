package com.example.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListelemeActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView rv;
    ArrayList<Müşteri> müşteriler=new ArrayList<>();
    FirebaseDatabase fd=FirebaseDatabase.getInstance();
    DatabaseReference dr=fd.getReference("müşteriler");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeleme);
        rv=findViewById(R.id.recycler_view);

        müşteriler.clear();

        MyAdapter adapter=new MyAdapter(müşteriler,getApplicationContext());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        rv.setLongClickable(true);

        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                müşteriler.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Müşteri müşteri=dataSnapshot.getValue(Müşteri.class);
                    müşteriler.add(müşteri);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        fab=findViewById(R.id.btn_ekle);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListelemeActivity.this, EklemeActivity.class);
                startActivity(intent);
            }
        });
    }
}
