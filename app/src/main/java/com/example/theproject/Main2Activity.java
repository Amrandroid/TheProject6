package com.example.theproject;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Main2Activity extends AppCompatActivity {
    PagerAdapter pagerAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;
    arr tabcontent1,tabcontent2,tabcontent3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

      tabcontent1=new arr(); tabcontent2=new arr(); tabcontent3=new arr();
    View tab1=  tabcontent1.NewtabView(this,"Vehicle",R.drawable.car);
        View tab2=  tabcontent2.NewtabView(this,"Electronics",R.drawable.tv);
        View tab3=  tabcontent3.NewtabView(this,"Fashion",R.drawable.tshirt);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


tabLayout.addTab(tabLayout.newTab().setCustomView(tab1));
        tabLayout.addTab(tabLayout.newTab().setCustomView(tab2));
        tabLayout.addTab(tabLayout.newTab().setCustomView(tab3));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
