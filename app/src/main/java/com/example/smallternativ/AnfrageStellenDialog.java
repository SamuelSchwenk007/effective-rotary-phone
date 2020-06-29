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
    StartseiteActivity startseiteActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.anfrage_stellen_dialog_layout,null);
        TextView ladentitel = view.findViewById(R.id.anfrageDialogTitle);
        ladentitel.setTypeface(ResourcesCompat.getFont(getContext(),R.font.pacifico));
        ladentitel.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        laden = view.findViewById(R.id.laden);
        produkt = view.findViewById(R.id.produkt);
        produktdetails = view.findViewById(R.id.produktdetails);
        anzahl = view.findViewById(R.id.anzahl);
        laden.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        produkt.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        produktdetails.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        anzahl.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

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
                if(anfragenAdapter == null) {
                    AnfragenFragment anfragenFragment = new AnfragenFragment();
                    anfragenFragment.setSupportActionBar(startseiteActivity.getSupportActionBar());
                    anfragenFragment.setStartseiteActivity(startseiteActivity);
                    anfragenAdapter = AnfragenAdapter.getInstance(getContext(),anfragenFragment.getShopListItemListenerDos());
                    startseiteActivity.createFragment(anfragenFragment);
                    anfragenAdapter.clearallListelements();
                }
                else{
                    ShopListItem shopListItemThree = new ShopListItem(R.drawable.metalworks_profil, "Schwert",
                            "Laden: Metalworks", "Anzahl: 1", "Datum: 25.06.2020", "Status: unbeantwortet",
                            "Leider noch keine Antwort verfügbar", "Produkt: 2 Händer Custom");

                    anfragenAdapter.getAufgaben().add(shopListItemThree);
                    anfragenAdapter.notifyDataSetChanged();
                }
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
