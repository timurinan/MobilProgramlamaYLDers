package com.example.uygulama9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    LayoutInflater inflater;
    ArrayList<Müşteri> müşteriler;

    public CustomAdapter(LayoutInflater inflater, ArrayList<Müşteri> müşteriler) {
        this.inflater = inflater;
        this.müşteriler = müşteriler;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.recycler_view_item,parent,false);
        MyViewHolder mvh=new MyViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Müşteri seçilenmüşteri=müşteriler.get(position);
        holder.setData(seçilenmüşteri);
    }

    @Override
    public int getItemCount() {
        return müşteriler.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_soyad,txt_mail,txt_telefon;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_soyad=itemView.findViewById(R.id.txt_item_adsoyad);
            txt_mail=itemView.findViewById(R.id.txt_item_mail);
            txt_telefon=itemView.findViewById(R.id.txt_item_telefon);
        }

        public void setData(Müşteri müşteri){
            txt_soyad.setText(müşteri.getAdsoyad());
            txt_mail.setText(müşteri.getMail());
            txt_telefon.setText(müşteri.getTelefon());
        }
    }


}
