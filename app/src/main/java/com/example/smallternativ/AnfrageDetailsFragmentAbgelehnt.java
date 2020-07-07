package com.example.smallternativ;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class AnfrageDetailsFragmentAbgelehnt extends Fragment {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private int profilPicReference;
    private String produktString;
    private String ladenNameString;
    private String anzahlString;
    private String datumString;
    private String statusString;
    private String antwortString;
    private String produktDetailsString;
    private TextView produkt,ladenName,anzahl,datum,status,antwort, produktdetails;
    private ImageView profilPic;
    private StartseiteActivity startseiteActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.anfragen_details_layout_abgelehnt, container, false);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Anfragendetails");
        produkt = view.findViewById(R.id.textViewProduktAbgelehnt);
        ladenName = view.findViewById(R.id.textViewLadenNameAnfragenAbgelehnt);
        anzahl = view.findViewById(R.id.textViewAnzahlAbgelehnt);
        datum = view.findViewById(R.id.textViewDatumAbgelehnt);
        status = view.findViewById(R.id.textViewStatusAbgelehnt);
        antwort = view.findViewById(R.id.textViewAntwortTextAbgelehnt);
        produktdetails = view.findViewById(R.id.textViewProduktdetailsAbgelehnt);
        produkt.setText(produktString);
        ladenName.setText(ladenNameString);
        anzahl.setText(anzahlString);
        datum.setText(datumString);
        status.setText(statusString);
        antwort.setText(antwortString);
        profilPic = view.findViewById(R.id.eintrag_bild_profil_anfragen_abgelehnt);
        profilPic.setImageResource(profilPicReference);
        produktdetails.setText(produktDetailsString);
        startseiteActivity.setCameFromSortiment(false);
        startseiteActivity.setToAnfragenpls(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

}
