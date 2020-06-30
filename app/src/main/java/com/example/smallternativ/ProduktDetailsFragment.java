package com.example.smallternativ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProduktDetailsFragment extends Fragment {
    String Produktname;
    String beschreibungsText;
    String kategorienProdukt;
    int productPicReference;
    TextView produktName;
    TextView beschreibungProdukt;
    ImageView produktBild;
    TextView kategorien;
    StartseiteActivity startseiteActivity;
    String ladenname;
    String sortiment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.produkt_detail_layout,container,false);
        produktName = view.findViewById(R.id.textViewProduktname);
        produktBild = view.findViewById(R.id.eintrag_bild_produkt);
        kategorien = view.findViewById(R.id.textViewProduktKategorie);
        beschreibungProdukt = view.findViewById(R.id.textViewProduktbeschreibung);
        produktName.setText(Produktname);
        beschreibungProdukt.setText(beschreibungsText);
        produktBild.setImageResource(productPicReference);
        kategorien.setText(kategorienProdukt);
        startseiteActivity.setCameFromSortiment(false);
        startseiteActivity.setLadenname(ladenname);
        startseiteActivity.setSortimenName(sortiment);

        return view;
    }



    public String getProduktname() {
        return Produktname;
    }

    public void setProduktname(String produktname) {
        Produktname = produktname;
    }

    public String getBeschreibungsText() {
        return beschreibungsText;
    }

    public void setBeschreibungsText(String beschreibungsText) {
        this.beschreibungsText = beschreibungsText;
    }

    public String getKategorienProdukt() {
        return kategorienProdukt;
    }

    public void setKategorienProdukt(String kategorienProdukt) {
        this.kategorienProdukt = kategorienProdukt;
    }

    public int getProductPicReference() {
        return productPicReference;
    }

    public void setProductPicReference(int productPicReference) {
        this.productPicReference = productPicReference;
    }

    public StartseiteActivity getStartseiteActivity() {
        return startseiteActivity;
    }

    public void setStartseiteActivity(StartseiteActivity startseiteActivity) {
        this.startseiteActivity = startseiteActivity;
    }   public String getLadenname() {
        return ladenname;
    }

    public void setLadenname(String ladenname) {
        this.ladenname = ladenname;
    }

    public String getSortiment() {
        return sortiment;
    }

    public void setSortiment(String sortiment) {
        this.sortiment = sortiment;
    }


}
