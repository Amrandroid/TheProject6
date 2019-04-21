package com.example.theproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class arr  {
    private String tab;
    private int id;
public  arr(){}
    public arr(String tab, int id) {
        this.tab = tab;
        this.id = id;
    }

    public String getTab() {return tab; }

    public int getId() {return id; }
    public static View NewtabView(Context context, String tabName, int tabImageResourse){
        View viewtab= View.inflate(context,R.layout.custom_tab,null);
        TextView tab =viewtab.findViewById(R.id.txt);
        ImageView img=viewtab.findViewById(R.id.img);
        tab.setText(tabName);img.setImageResource(tabImageResourse);
        return viewtab;
    }
}
