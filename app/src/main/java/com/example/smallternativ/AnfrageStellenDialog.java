package com.example.smallternativ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;

public class AnfrageStellenDialog extends DialogFragment {
    TextView laden;
    TextView produkt;
    TextView produktdetails;
    TextView anzahl;
    EditText ladeneingabe;
    EditText produkteingabe;
    EditText produktdetailseingabe;
    EditText anzahleingabe;
    Button anfragestellen;
    Button anfrageabbrechen;
    AnfragenAdapter anfragenAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.anfrage_stellen_dialog_layout,null);
        TextView textView = view.findViewById(R.id.anfrageDialogTitle);
        textView.setTypeface(ResourcesCompat.getFont(getContext(),R.font.pacifico));
        anfrageabbrechen = view.findViewById(R.id.abbrechenBtton);
        anfrageabbrechen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        anfragestellen = view.findViewById(R.id.ok_anfrage_senden);
        anfragestellen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShopListItem shopListItemThree = new ShopListItem(R.drawable.metalworks_profil,"Schwert",
                        "Laden: Metalworks","Anzahl: 1","Datum: 25.06.2020","Status: unbeantwortet",
                        "Leider noch keine Antwort verfügbar","Produkt: 2 Händer Custom");

                anfragenAdapter.getAufgaben().add(shopListItemThree);
                anfragenAdapter.notifyDataSetChanged();
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
}
