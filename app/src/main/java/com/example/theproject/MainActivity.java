package com.example.theproject;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button button;
EditText textViewName,textViewPassword;
CheckBox rememberMe;
    final String FILE="amr.my_file";
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewName=findViewById(R.id.usrName);
        textViewPassword=findViewById(R.id.usrpassword);
        rememberMe=findViewById(R.id.check);
        button=findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=(String)textViewName.getText().toString();
                String pass=(String) textViewPassword.getText().toString();
                if((name.equals(""))||(pass.equals(""))){
                    createDialog();
                }//if
                else {
                    Intent i= new Intent(MainActivity.this,Main2Activity.class);

                    if(rememberMe.isChecked()){
                        SharedPreferences sharedPreferences=getSharedPreferences(FILE,Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("name",name);
                        editor.apply();
                    }
                    i.putExtra("name",name);
                    startActivity(i);
                }
            }
        });

    }
    private void createDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater  inflater = getLayoutInflater();
        View layout=inflater.inflate(R.layout.custom_toast_layout,null);
        TextView title=(TextView) layout.findViewById(R.id.title);
        TextView body=(TextView) layout.findViewById(R.id.body);
        Button button=(Button)layout.findViewById(R.id.btn);
        title.setText("Login Failed");
        body.setText("Please enter username and password");
        builder.setView(layout);
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });


    }

}
