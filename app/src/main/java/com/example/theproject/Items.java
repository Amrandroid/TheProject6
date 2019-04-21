package com.example.theproject;

public class Items {
    private String name;
    private String info;
    private int picID;

    public Items(String name, String info, int picID) {
        this.name = name;
        this.info = info;
        this.picID = picID;
    }

    public String getName() {return name;}
    public String getInfo() {return info;}
    public int getPicID() {return picID;}
    public static Items CreateNew(String name, String info, int ID){
        return new Items(name,info,ID);
    }
}
