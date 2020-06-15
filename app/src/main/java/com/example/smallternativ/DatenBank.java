package com.example.smallternativ;

import android.app.Activity;
import android.content.Context;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;


public class DatenBank {
    private static DatenBank datenBank;
    private static BoxStore boxStore;

    public static DatenBank getInstance(Context context){
        if (datenBank == null){
            datenBank = new DatenBank(context);
        }
        return datenBank;
    }

    public DatenBank(Context context){
        if (boxStore == null){
            boxStore = MyObjectBox.builder().androidContext(context).build();
        }
    }
    public BoxStore getBox(){
        return boxStore;
    }

}