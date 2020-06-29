package com.example.smallternativ;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Produkt {
   @Id
   public long id;
    public String title;
    public String beschreibung;
    public int profilbildReference;
    public String kategorie;

    public Produkt (String title, String beschreibung, int profilbildReference, String kategorie){
        this.profilbildReference = profilbildReference;
        this.title = title;
        this.beschreibung = beschreibung;
        this.kategorie = kategorie;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getProfilbildReference() {
        return profilbildReference;
    }

    public void setProfilbildReference(int profilbildReference) {
        this.profilbildReference = profilbildReference;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }
}
