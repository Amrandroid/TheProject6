package com.example.theproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Items> {
    public ItemAdapter(Context context, ArrayList<Items> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_list_layout,parent,false);
        TextView title=convertView.findViewById(R.id.title);
        TextView info=convertView.findViewById(R.id.info);
        Items items=(Items)getItem(position);
        title.setText(items.getName());
        info.setText(items.getInfo());
        return convertView;

    }
}
