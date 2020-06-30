package com.example.smallternativ;

import android.view.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;

public class SucheEinenLadenDialog extends DialogFragment {

    EditText suchInhalt;
    Button sucheStarten;
    Button sucheabbrechen;
    AnfragenAdapter anfragenAdapter;
    StartseiteActivity startseiteActivity;
    TextView sucheEinenLadenTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ladensuche_layout,null);


        sucheEinenLadenTitle = view.findViewById(R.id.sucheDialogTitle);
        sucheEinenLadenTitle.setTypeface(ResourcesCompat.getFont(getContext(),R.font.pacifico));
        sucheEinenLadenTitle.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        sucheabbrechen = view.findViewById(R.id.sucheAbbrechen);
        sucheabbrechen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        sucheStarten = view.findViewById(R.id.sucheStarten);
        sucheStarten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LadenProfilFragment ladenProfilFragment = new LadenProfilFragment();
                ladenProfilFragment.setStartseiteActivity(startseiteActivity);
                ladenProfilFragment.setSupportActionBar(startseiteActivity.getSupportActionBar());
                ladenProfilFragment.setMyAdapter(startseiteActivity.myAdapter);
                ladenProfilFragment.setLadenNameString(startseiteActivity.liste.get(5).title);
                ladenProfilFragment.setLadenBeschribungString(startseiteActivity.liste.get(5).beschreibung);
                ladenProfilFragment.setLadenPicReference(startseiteActivity.liste.get(5).profilbildReference);
                ladenProfilFragment.setKategorieItemString(startseiteActivity.liste.get(5).kategorie);
                ladenProfilFragment.setAdresseString(startseiteActivity.liste.get(5).adresse);
                ladenProfilFragment.setSortimentUnoReference(startseiteActivity.liste.get(5).sortimentReferenceUno);
                ladenProfilFragment.setSortimentDosReference(startseiteActivity.liste.get(5).sortimentReferenceDos);
                ladenProfilFragment.setSortimentTresReference(startseiteActivity.liste.get(5).sortimentThresReference);
                ladenProfilFragment.setSortimentQuadroReference(startseiteActivity.liste.get(5).sortimentQuadroReference);
                ladenProfilFragment.setSortimentUnoString(startseiteActivity.liste.get(5).getSortimentUnoString());
                ladenProfilFragment.setSortimentDosString(startseiteActivity.liste.get(5).getSortimentDosString());
                ladenProfilFragment.setSortimentTresString(startseiteActivity.liste.get(5).getSortimentThresString());
                ladenProfilFragment.setSortimentQuadroString(startseiteActivity.liste.get(5).getSortimentQuadroString());
                startseiteActivity.createFragment(ladenProfilFragment);

                dismiss();
            }
        });
        return view;
    }

    public AnfragenAdapter getAnfragenAdapter() {
        return anfragenAdapter;
    }

    public void setAnfragenAdapter(AnfragenAdapter anfragenAdapter) {
        this.anfragenAdapter = anfragenAdapter;
    }
    public StartseiteActivity getStartseiteActivity() {
        return startseiteActivity;
    }

    public void setStartseiteActivity(StartseiteActivity startseiteActivity) {
        this.startseiteActivity = startseiteActivity;
    }
}
