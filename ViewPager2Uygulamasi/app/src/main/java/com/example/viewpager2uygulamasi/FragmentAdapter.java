package com.example.viewpager2uygulamasi;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {

    ArrayList<FragmentHesap> hesaplar=new ArrayList<FragmentHesap>();
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    public void fragmentEkle(FragmentHesap fh){
        hesaplar.add(fh);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return hesaplar.get(position);
    }

    @Override
    public int getItemCount() {
        return hesaplar.size();
    }
}
