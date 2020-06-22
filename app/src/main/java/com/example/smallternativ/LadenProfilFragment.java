package com.example.smallternativ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class LadenProfilFragment extends Fragment {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private int adapterPosition;
    private MyAdapter myAdapter;
    private Button anfrageSenden;
    private Button favoritSetzen;
    private Button karte;
    private TextView ladenName;
    private  TextView ladenAdresse;
    private ImageView ladenBild;
    private TextView kategorieItems;
    private  TextView ladenBeschreibung;
    private String ladenNameString;
    private String ladenAdresseString;
    private String kategorieItemString;
    private String ladenBeschribungString;
    private int ladenPicReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ladenprofil_layout, container, false);
       // StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Smallternative");
        anfrageSenden = view.findViewById(R.id.buttonAnfrageSenden);
        favoritSetzen = view.findViewById(R.id.addFavourite);
        karte = view.findViewById(R.id.buttonKarteLadenprofil);
        ladenName = view.findViewById(R.id.textViewLadenname);
        ladenAdresse = view.findViewById(R.id.textViewAdresseProfil);
        ladenBild = view.findViewById(R.id.eintrag_bild_profil);
        kategorieItems = view.findViewById(R.id.textViewKategorie2);
        ladenBeschreibung = view.findViewById(R.id.textViewLadenbeschreibung);

        ladenName.setText(ladenNameString);
        ladenBeschreibung.setText(ladenBeschribungString);
        ladenBild.setImageResource(ladenPicReference);
        return view;
    }
    public ActionBar getSupportActionBar() {
        return supportActionBar;
    }

    public void setSupportActionBar(ActionBar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
    public void setAdapterPosition(int adapterPosition){
        this.adapterPosition = adapterPosition;
    }

    public MyAdapter getMyAdapter() {
        return myAdapter;
    }

    public void setMyAdapter(MyAdapter myAdapter) {
        this.myAdapter = myAdapter;
    }
    public int getLadenPicReference() {
        return ladenPicReference;
    }

    public void setLadenPicReference(int ladenPicReference) {
        this.ladenPicReference = ladenPicReference;
    }
    public String getLadenNameString() {
        return ladenNameString;
    }

    public void setLadenNameString(String ladenNameString) {
        this.ladenNameString = ladenNameString;
    }
    public String getLadenBeschribungString() {
        return ladenBeschribungString;
    }

    public void setLadenBeschribungString(String ladenBeschribungString) {
        this.ladenBeschribungString = ladenBeschribungString;
    }
}
