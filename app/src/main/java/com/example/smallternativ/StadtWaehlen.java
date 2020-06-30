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

public class StadtWaehlen extends DialogFragment {

    EditText suchInhalt;
    Button sucheStarten;
    Button sucheabbrechen;
    AnfragenAdapter anfragenAdapter;
    StartseiteActivity startseiteActivity;
    TextView sucheEinenLadenTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stadt_waehlen_layout,null);


        sucheEinenLadenTitle = view.findViewById(R.id.stadtSuchenDialogTitle);
        sucheEinenLadenTitle.setTypeface(ResourcesCompat.getFont(getContext(),R.font.pacifico));
        sucheEinenLadenTitle.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        sucheabbrechen = view.findViewById(R.id.stadtSucheAbbrechen);
        sucheabbrechen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        sucheStarten = view.findViewById(R.id.bestaetigen);
        sucheStarten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
