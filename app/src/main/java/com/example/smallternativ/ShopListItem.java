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
    public String kategorie;
    public String sortimentUnoString;
    public String sortimentDosString;
    public String sortimentThresString;
    public String sortimentQuadroString;
    public String adresse;
    public int sortimentReferenceUno, sortimentReferenceDos, sortimentThresReference,sortimentQuadroReference;

    public ShopListItem (String title, String beschreibung, int profilbildReference, String kategorie,
                         String sortimentUnoString, String sortimentDosString, String sortimentThresString,
                         String sortimentQuadroString, int sortimentReferenceUno, int sortimentReferenceDos,
                         int sortimentThresReference, int sortimentQuadroReference, String adresse){
        this.profilbildReference = profilbildReference;
        this.title = title;
        this.beschreibung = beschreibung;
        this.kategorie = kategorie;
        this.sortimentUnoString = sortimentUnoString;
        this.sortimentDosString = sortimentDosString;
        this.sortimentThresString = sortimentThresString;
        this.sortimentQuadroString = sortimentQuadroString;
        this.sortimentReferenceUno = sortimentReferenceUno;
        this.sortimentReferenceDos = sortimentReferenceDos;
        this.sortimentThresReference = sortimentThresReference;
        this.sortimentQuadroReference = sortimentQuadroReference;
        this.adresse = adresse;

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
    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getSortimentUnoString() {
        return sortimentUnoString;
    }

    public void setSortimentUnoString(String sortimentUnoString) {
        this.sortimentUnoString = sortimentUnoString;
    }

    public String getSortimentDosString() {
        return sortimentDosString;
    }

    public void setSortimentDosString(String sortimentDosString) {
        this.sortimentDosString = sortimentDosString;
    }

    public int getSortimentReferenceUno() {
        return sortimentReferenceUno;
    }

    public void setSortimentReferenceUno(int sortimentReferenceUno) {
        this.sortimentReferenceUno = sortimentReferenceUno;
    }

    public int getSortimentReferenceDos() {
        return sortimentReferenceDos;
    }

    public void setSortimentReferenceDos(int sortimentReferenceDos) {
        this.sortimentReferenceDos = sortimentReferenceDos;
    }
    public String getSortimentThresString() {
        return sortimentThresString;
    }

    public void setSortimentThresString(String sortimentThresString) {
        this.sortimentThresString = sortimentThresString;
    }

    public String getSortimentQuadroString() {
        return sortimentQuadroString;
    }

    public void setSortimentQuadroString(String sortimentQuadroString) {
        this.sortimentQuadroString = sortimentQuadroString;
    }

    public int getSortimentThresReference() {
        return sortimentThresReference;
    }

    public void setSortimentThresReference(int sortimentThresReference) {
        this.sortimentThresReference = sortimentThresReference;
    }

    public int getSortimentQuadroReference() {
        return sortimentQuadroReference;
    }

    public void setSortimentQuadroReference(int sortimentQuadroReference) {
        this.sortimentQuadroReference = sortimentQuadroReference;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}