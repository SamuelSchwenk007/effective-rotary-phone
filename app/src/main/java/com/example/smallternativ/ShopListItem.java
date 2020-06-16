package com.example.smallternativ;

import android.graphics.Color;
import android.media.Image;
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
    public int profilbildReference;
    public int bannerReference;

    public ShopListItem (String title, String beschreibung, int profilbildReference,int bannerReference){
        this.profilbildReference = profilbildReference;
        this.bannerReference = bannerReference;
        this.title = title;
        this.beschreibung = beschreibung;

    }
    public int getBannerReference() {
        return bannerReference;
    }

    public void setBannerReference(int bannerReference) {
        this.bannerReference = bannerReference;
    }
    public int getProfilbildReference() {
        return profilbildReference;
    }

    public void setProfilbildReference(int profilbildReference) {
        this.profilbildReference = profilbildReference;
    }
    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
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