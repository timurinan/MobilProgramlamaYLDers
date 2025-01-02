package com.example.firebaseapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<Müşteri> müşteriler;
    Context context;
    FirebaseDatabase fd=FirebaseDatabase.getInstance();
    DatabaseReference dr=fd.getReference("müşteriler");

    public MyAdapter(ArrayList<Müşteri> müşteriler, Context context) {
        this.müşteriler = müşteriler;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Müşteri müşteri=müşteriler.get(position);
        holder.txt_adsoyad.setText(müşteri.getAdsoyad());
        holder.txt_telefon.setText(müşteri.getTelefon());
        holder.txt_mail.setText(müşteri.getMail());
    }

    @Override
    public int getItemCount() {
        return müşteriler.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_adsoyad, txt_mail, txt_telefon;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_adsoyad=itemView.findViewById(R.id.txt_recycler_adsoyad);
            txt_mail=itemView.findViewById(R.id.txt_recycler_mail);
            txt_telefon=itemView.findViewById(R.id.txt_recycler_telefon);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int p=getLayoutPosition();

                    AlertDialog.Builder ab=new AlertDialog.Builder(itemView.getContext());
                    ab.setPositiveButton("Sil", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           dr.child(müşteriler.get(p).getUid()).removeValue();
                           Toast.makeText(context.getApplicationContext(), "silindi:"+müşteriler.get(p).getAdsoyad(), Toast.LENGTH_SHORT).show();
                           müşteriler.remove(p);

                        }
                    });
                    ab.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Vazgeç
                        }
                    });
                    ab.setNeutralButton("Güncelle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent guncelle_intent=new Intent(itemView.getContext(), GuncelleActivity.class);
                            guncelle_intent.putExtra("müşteri",müşteriler.get(p));
                            itemView.getContext().startActivity(guncelle_intent);
                        }
                    });
                    ab.show();
                    return false;
                }
            });
        }
    }
}
