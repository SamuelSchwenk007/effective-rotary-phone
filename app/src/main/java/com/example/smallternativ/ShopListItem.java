package com.example.smallternativ;

import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class ShopListItem {
    @Id  public long id;
    public String title;
    public BackgroundColorSpan backgroundColorSpan;


    // @Convert(converter = Button.class, dbType = boolean.class)
    //public Button loeschen;


    public BackgroundColorSpan getBackgroundColorSpan() {
        return backgroundColorSpan;
    }

    public void setBackgroundColorSpan(BackgroundColorSpan backgroundColorSpan) {
        this.backgroundColorSpan = backgroundColorSpan;
    }

    public ShopListItem (String title, BackgroundColorSpan backgroundColorSpan){
        this.title = title;
        this.backgroundColorSpan = backgroundColorSpan;

    }
    public ShopListItem(){
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(long id){
        this.id = id;
    }
}