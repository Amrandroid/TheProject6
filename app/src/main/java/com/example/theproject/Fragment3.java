package com.example.theproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview=inflater.inflate(R.layout.fragment3,container,false);
        ListView list1= myview.findViewById(R.id.list3);
        ArrayList<Items> items=new ArrayList<>();
        items.add(new Items("Title1","sample1",0));
        items.add(new Items("Title2","sample2",0));
        items.add(new Items("Title3","sample3",0));
        items.add(new Items("Title4","sample4",0));
        items.add(new Items("Title5","sample5",0));
        ItemAdapter adapter=new ItemAdapter(getActivity(),items);
        list1.setAdapter(adapter);
        return myview;
    }
}

