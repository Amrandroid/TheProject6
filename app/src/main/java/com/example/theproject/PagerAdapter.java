package com.example.theproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {super(fm); }
@Override
    public Fragment getItem(int position){
        switch (position){
            case 0:Fragment1 fragment1=new Fragment1(); return fragment1;
            case 1:Fragment2 fragment2=new Fragment2(); return fragment2;
            case 2:Fragment3 fragment3=new Fragment3();return fragment3;
        }
return null;
}

    @Override
    public int getCount() {
        return 3;
    }
}