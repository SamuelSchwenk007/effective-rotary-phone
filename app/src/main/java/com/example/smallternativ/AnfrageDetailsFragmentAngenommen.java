package com.example.smallternativ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class AnfrageDetailsFragmentAngenommen extends Fragment {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private int profilPicReference;
    private String produktDetailsString;
    private String produktString,ladenNameString, anzahlString, datumString, statusString,antwortString;
    private TextView produkt,ladenName,anzahl,datum,status,antwort,produktdetails;
    private ImageView profilPic;
    private Button anfrageAbbrechen;
    private  StartseiteActivity startseiteActivity;
    private int position;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.anfragen_details_layout_angenommen, container, false);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Anfragendetails");
        produkt = view.findViewById(R.id.textViewProduktAngenommen);
        ladenName = view.findViewById(R.id.textViewLadenNameAnfragenAngenommen);
        anzahl = view.findViewById(R.id.textViewAnzahlAngenommen);
        datum = view.findViewById(R.id.textViewDatumAngenommen);
        status = view.findViewById(R.id.textViewStatusAngenommen);
        antwort = view.findViewById(R.id.textViewAntwortTextAngenommen);
        produktdetails = view.findViewById(R.id.textViewProduktdetailsAngenommen);

        produkt.setText(produktString);
        ladenName.setText(ladenNameString);
        anzahl.setText(anzahlString);
        datum.setText(datumString);
        status.setText(statusString);
        antwort.setText(antwortString);
        profilPic = view.findViewById(R.id.eintrag_bild_profil_anfragen_angenommen);
        profilPic.setImageResource(profilPicReference);
        produktdetails.setText(produktDetailsString);
        anfrageAbbrechen = view.findViewById(R.id.buttonAnfrageAbbrechenAngenommen);
        anfrageAbbrechen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startseiteActivity.getBlacklineone().setVisibility(View.INVISIBLE);
                startseiteActivity.getBlacklinetwo().setVisibility(View.INVISIBLE);
                startseiteActivity.getBlacklinetree().setVisibility(View.VISIBLE);
                startseiteActivity.getBlacklinefour().setVisibility(View.INVISIBLE);
                AnfragenFragment anfragenFragment = new AnfragenFragment();
                anfragenFragment.setDeleat(true);
                anfragenFragment.setPosition(position);
                anfragenFragment.setSupportActionBar(getSupportActionBar());
                anfragenFragment.setStartseiteActivity(startseiteActivity);
                AnfragenAdapter anfragenAdapter = AnfragenAdapter.getInstance(getContext(),anfragenFragment.getShopListItemListenerDos());
                startseiteActivity.createFragment(anfragenFragment);
                anfragenAdapter.clearallListelements();
            }
        });
        return view;
    }
    public ActionBar getSupportActionBar() {
        return supportActionBar;
    }

    public void setSupportActionBar(ActionBar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
    public String getProduktString() {
        return produktString;
    }

    public void setProduktString(String produktString) {
        this.produktString = produktString;
    }

    public String getLadenNameString() {
        return ladenNameString;
    }

    public void setLadenNameString(String ladenNameString) {
        this.ladenNameString = ladenNameString;
    }

    public String getAnzahlString() {
        return anzahlString;
    }

    public void setAnzahlString(String anzahlString) {
        this.anzahlString = anzahlString;
    }

    public String getDatumString() {
        return datumString;
    }

    public void setDatumString(String datumString) {
        this.datumString = datumString;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public String getAntwortString() {
        return antwortString;
    }

    public void setAntwortString(String antwortString) {
        this.antwortString = antwortString;
    }

    public int getProfilPicReference() {
        return profilPicReference;
    }

    public void setProfilPicReference(int profilPicReference) {
        this.profilPicReference = profilPicReference;
    }

    public String getProduktDetailsString() {
        return produktDetailsString;
    }

    public void setProduktDetailsString(String produktDetailsString) {
        this.produktDetailsString = produktDetailsString;
    }

    public StartseiteActivity getStartseiteActivity() {
        return startseiteActivity;
    }

    public void setStartseiteActivity(StartseiteActivity startseiteActivity) {
        this.startseiteActivity = startseiteActivity;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
