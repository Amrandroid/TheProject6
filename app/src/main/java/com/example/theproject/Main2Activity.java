package com.example.theproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.zip.Inflater;

public class Main2Activity extends AppCompatActivity {
    final String FILE="amr.my_file";

    PagerAdapter pagerAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;
    arr tabcontent1,tabcontent2,tabcontent3;
    TextView textView,logout;
    LinearLayout linearLayout;
Toolbar toolbar;
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
        toolbar=findViewById(R.id.tool_bar);
        logout=findViewById(R.id.logout);
        textView=findViewById(R.id.loggedName);
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
      String name=  getIntent().getStringExtra("name");

     LayoutInflater inflater=getLayoutInflater();
     View toolbarView=inflater.inflate(R.layout.custom_toolbar,(ViewGroup)findViewById(R.id.linear));
    TextView loggedName=(TextView)toolbarView.findViewById(R.id.txt);
   ImageView img=(ImageView)toolbarView.findViewById(R.id.img) ;
   img.setVisibility(View.VISIBLE);
loggedName.setVisibility(View.VISIBLE);
      loggedName.setText(name);
 textView.setText(name);
setSupportActionBar(toolbar);
getSupportActionBar().setDisplayShowTitleEnabled(false);

logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i =new Intent(Main2Activity.this,MainActivity.class);
        SharedPreferences sharedPreferences=getSharedPreferences(FILE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",null);
        editor.apply();

        startActivity(i);
        finish();
    }
});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
               break;
        }
        return super.onOptionsItemSelected(item);
    }

}
