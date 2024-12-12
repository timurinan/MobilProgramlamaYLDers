package com.example.personelkayit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Kontrolcu_Listele extends AppCompatActivity {

    ListView lv;
    FloatingActionButton fab;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        fab=findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        lv=findViewById(R.id.lst_goruntule);
        Veritabani_Islemleri vi=new Veritabani_Islemleri(getApplicationContext());

        ArrayList<Personel> çalışanlar= (ArrayList<Personel>) vi.listele();

        Personel_Adapter pa=new Personel_Adapter(this,çalışanlar);

        lv.setAdapter(pa);

        lv.setLongClickable(true);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),String.valueOf((int)l),Toast.LENGTH_LONG).show();

                AlertDialog.Builder ab=new AlertDialog.Builder(Kontrolcu_Listele.this);
                ab.setTitle("Seçim Yapınız");

                ab.setPositiveButton("Güncelle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent=new Intent(Kontrolcu_Listele.this,Kontrolcu_Guncelle.class);
                        intent.putExtra("personel_id",(int)l);
                        startActivity(intent);

                    }
                });

                ab.setNegativeButton("Sil", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        vi.sil((int) l);

                        for(int j=0;j<çalışanlar.size();j++){
                            if(çalışanlar.get(j).getId()==(int)l){
                                çalışanlar.remove(j);
                                break;
                            }
                        }
                        startActivity(getIntent());
                    }
                });

                ab.setNeutralButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                ab.show();
                return false;
            }


        });

        
    }
}
