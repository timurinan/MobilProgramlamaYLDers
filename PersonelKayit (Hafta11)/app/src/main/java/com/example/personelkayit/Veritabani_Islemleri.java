package com.example.personelkayit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Veritabani_Islemleri extends SQLiteOpenHelper {

    private static final String veritabani_ismi="Personel_Bilgileri";
    private static final String tablo_ismi="tablo_personel";
    private static final String sutun_id="id";
    private static final String sutun_ad_soyad="ad_soyad";
    private static final String sutun_mail="mail";
    private static final String sutun_telefon="telefon";

    public Veritabani_Islemleri(@Nullable Context context) {
        super(context, veritabani_ismi, null, 1);
       // this.onCreate(getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String crate_sorgusu="CREATE TABLE "+tablo_ismi+
                " ("+sutun_id+" INTEGER PRIMARY KEY,"+sutun_ad_soyad+" TEXT,"+ sutun_mail+" TEXT,"+sutun_telefon+" TEXT"+")";
        sqLiteDatabase.execSQL(crate_sorgusu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void ekle(Personel personel){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();//insert edilecek değerler bunun içine yerleştiriliyor.
        values.put(sutun_ad_soyad,personel.getAdsoyad());
        values.put(sutun_mail,personel.getMail());
        values.put(sutun_telefon,personel.getTelefon());
        db.insert(tablo_ismi,null,values);
        db.close();

    }

    public void sil(int id){
        SQLiteDatabase db=getWritableDatabase();
        String delete_sorgusu=" delete from "+tablo_ismi+ " where id="+id;
        db.execSQL(delete_sorgusu);
        db.close();
    }

    public Personel personelGetir(int id){
        SQLiteDatabase db=getWritableDatabase();
        String sorgu= "select * from "+tablo_ismi+ " where id="+id;
        Cursor cursor=db.rawQuery(sorgu,null);
        cursor.moveToFirst();
        String adsoyad=cursor.getString(1);
        String mail=cursor.getString(2);
        String telefon=cursor.getString(3);
        Personel personel=new Personel(adsoyad,mail,telefon);
        personel.setId(id);
        return personel;
    }
    public void guncelle(Personel personel){

        SQLiteDatabase db=getWritableDatabase();
        String update_sorgusu= "update "+tablo_ismi+" set "+sutun_ad_soyad+"='"+personel.getAdsoyad()+
                "',"+sutun_mail+"='"+personel.getMail()+"',"+sutun_telefon+"='"+personel.getTelefon()+"'"+ "where id="+personel.getId();
        db.execSQL(update_sorgusu);
        db.close();
    }

    public List<Personel> listele(){

        SQLiteDatabase db=getWritableDatabase();
        String select_sorgusu="select * from "+tablo_ismi;
        Cursor cursor=db.rawQuery(select_sorgusu,null);
        ArrayList<Personel> personel_listesi=new ArrayList<Personel>();

        if(cursor.moveToFirst()){
            do{
                int id=cursor.getInt(0);
                String adsoyad=cursor.getString(1);
                String mail=cursor.getString(2);
                String telefon=cursor.getString(3);
                Personel personel=new Personel(adsoyad,mail,telefon);
                personel.setId(id);
                personel_listesi.add(personel);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return personel_listesi;
    }
}
