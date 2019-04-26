package com.example.theproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView=findViewById(R.id.intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final String FILE="amr.my_file";
                SharedPreferences sharedPreferences=getSharedPreferences(FILE,Context.MODE_PRIVATE);
                String name=sharedPreferences.getString("name",null);
                textView.setText(name);//this is to see the outcome on the screen

                if((name!=null)) {
                    Intent i = new Intent(Splash.this, Main2Activity.class);
                    i.putExtra("name",name);
                    startActivity(i);

                   finish();
                }
                else     {
                    Intent n = new Intent(Splash.this, MainActivity.class);
                    startActivity(n);
                    finish();
                }


            }
        },3000);
    }
}
