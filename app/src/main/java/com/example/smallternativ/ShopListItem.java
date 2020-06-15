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
    public String beschreibung;


    // @Convert(converter = Button.class, dbType = boolean.class)
    //public Button loeschen;


    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public ShopListItem (String title, String beschreibung){
        this.title = title;
        this.beschreibung = beschreibung;

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