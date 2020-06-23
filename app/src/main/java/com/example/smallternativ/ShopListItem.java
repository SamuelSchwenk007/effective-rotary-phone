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
    public String produkt,ladenName,anzahl,datum,status,antwort,produktdetails;
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
    public ShopListItem (int profilbildReference,String produkt,String ladenName,String anzahl,String datum,String status,String antwort,String produktdetails){
        this.profilbildReference = profilbildReference;
        this.produkt = produkt;
        this.ladenName = ladenName;
        this.anzahl = anzahl;
        this.datum = datum;
        this.status = status;
        this.antwort = antwort;
        this.produktdetails = produktdetails;
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
    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public String getLadenName() {
        return ladenName;
    }

    public void setLadenName(String ladenName) {
        this.ladenName = ladenName;
    }

    public String getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(String anzahl) {
        this.anzahl = anzahl;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public String getProduktdetails() {
        return produktdetails;
    }

    public void setProduktdetails(String produktdetails) {
        this.produktdetails = produktdetails;
    }

}