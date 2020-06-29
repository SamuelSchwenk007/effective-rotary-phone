package com.example.smallternativ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class LadenProfilFragment extends Fragment {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private MyAdapter myAdapter;
    private Button anfrageSenden;
    private Button favoritSetzen;
    private Button karte;
    private ImageView sortimentUno;
    private ImageView sortimentDos;
    private ImageView sortimentTres;
    private ImageView sortimentQuadro;
    private TextView ladenName;
    private  TextView ladenAdresse;
    private ImageView ladenBild;
    private TextView kategorieItems;
    private  TextView ladenBeschreibung;
    private String ladenNameString;
    private String ladenAdresseString;
    private String kategorieItemString;
    private String ladenBeschribungString;
    private String sortimentUnoString;
    private String sortimentDosString;
    private String sortimentTresString;
    private String sortimentQuadroString;
    private  String adresseString;
    private int ladenPicReference, sortimentUnoReference, sortimentDosReference,sortimentTresReference, sortimentQuadroReference;
    private StartseiteActivity startseiteActivity;
    private TextView sortimentOne, sortimentTwo, sortimentTree,sortimentFour;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ladenprofil_layout, container, false);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Ladenprofil");
        anfrageSenden = view.findViewById(R.id.buttonAnfrageSenden);
        favoritSetzen = view.findViewById(R.id.addFavourite);
        karte = view.findViewById(R.id.buttonKarteLadenprofil);
        ladenName = view.findViewById(R.id.textViewLadenname);
        ladenAdresse = view.findViewById(R.id.textViewAdresseProfil);
        ladenBild = view.findViewById(R.id.eintrag_bild_profil);
        kategorieItems = view.findViewById(R.id.textViewKategorie2);
        ladenBeschreibung = view.findViewById(R.id.textViewLadenbeschreibung);
        sortimentUno = view.findViewById(R.id.buttonSortimentUno);
        sortimentDos = view.findViewById(R.id.buttonSortimentDos);
        sortimentTres = view.findViewById(R.id.buttonSortimentTres);
        sortimentQuadro = view.findViewById(R.id.buttonSortimentQuadro);

        ladenName.setText(ladenNameString);
        ladenName.setTextSize(24);
        ladenBeschreibung.setText(ladenBeschribungString);
        ladenBild.setImageResource(ladenPicReference);
        kategorieItems.setText(kategorieItemString);
        ladenAdresse.setText(adresseString);
        sortimentUno.setBackgroundResource(sortimentUnoReference);
        sortimentDos.setBackgroundResource(sortimentDosReference);
        sortimentTres.setBackgroundResource(sortimentTresReference);
        sortimentQuadro.setBackgroundResource(sortimentQuadroReference);
        sortimentOne = view.findViewById(R.id.sortimentUnoText);
        sortimentTwo = view.findViewById(R.id.sortimentDosText);
        sortimentTree = view.findViewById(R.id.sortimentTresText);
        sortimentFour = view.findViewById(R.id.sortimentQuadroText);
        sortimentOne.setText(sortimentUnoString);
        sortimentTwo.setText(sortimentDosString);
        sortimentTree.setText(sortimentTresString);
        sortimentFour.setText(sortimentQuadroString);

        sortimentUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProduktListFragment produktListFragment = new ProduktListFragment();
                produktListFragment.setStartseiteActivity(startseiteActivity);
                produktListFragment.setSupportActionBar(supportActionBar);
                produktListFragment.setSortimentname(sortimentUnoString);
                produktListFragment.setLadenname(ladenNameString);
                startseiteActivity.createFragment(produktListFragment);
            }
        });
        sortimentDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProduktListFragment produktListFragment = new ProduktListFragment();
                produktListFragment.setStartseiteActivity(startseiteActivity);
                produktListFragment.setSupportActionBar(supportActionBar);
                produktListFragment.setSortimentname(sortimentDosString);
                produktListFragment.setLadenname(ladenNameString);
                startseiteActivity.createFragment(produktListFragment);
            }
        });
        sortimentTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProduktListFragment produktListFragment = new ProduktListFragment();
                produktListFragment.setStartseiteActivity(startseiteActivity);
                produktListFragment.setSupportActionBar(supportActionBar);
                produktListFragment.setSortimentname(sortimentTresString);
                produktListFragment.setLadenname(ladenNameString);
                startseiteActivity.createFragment(produktListFragment);
            }
        });
        sortimentQuadro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProduktListFragment produktListFragment = new ProduktListFragment();
                produktListFragment.setStartseiteActivity(startseiteActivity);
                produktListFragment.setSupportActionBar(supportActionBar);
                produktListFragment.setSortimentname(sortimentQuadroString);
                produktListFragment.setLadenname(ladenNameString);
                startseiteActivity.createFragment(produktListFragment);
            }
        });
        anfrageSenden = view.findViewById(R.id.buttonAnfrageSenden);
        anfrageSenden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startseiteActivity.addOnclick(view);
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
    public Button getKarte() {
        return karte;
    }

    public void setKarte(Button karte) {
        this.karte = karte;
    }

    public TextView getLadenName() {
        return ladenName;
    }

    public void setLadenName(TextView ladenName) {
        this.ladenName = ladenName;
    }

    public TextView getLadenAdresse() {
        return ladenAdresse;
    }

    public void setLadenAdresse(TextView ladenAdresse) {
        this.ladenAdresse = ladenAdresse;
    }

    public ImageView getLadenBild() {
        return ladenBild;
    }

    public void setLadenBild(ImageView ladenBild) {
        this.ladenBild = ladenBild;
    }

    public TextView getKategorieItems() {
        return kategorieItems;
    }

    public void setKategorieItems(TextView kategorieItems) {
        this.kategorieItems = kategorieItems;
    }

    public TextView getLadenBeschreibung() {
        return ladenBeschreibung;
    }

    public void setLadenBeschreibung(TextView ladenBeschreibung) {
        this.ladenBeschreibung = ladenBeschreibung;
    }

    public String getLadenAdresseString() {
        return ladenAdresseString;
    }

    public void setLadenAdresseString(String ladenAdresseString) {
        this.ladenAdresseString = ladenAdresseString;
    }

    public String getKategorieItemString() {
        return kategorieItemString;
    }

    public void setKategorieItemString(String kategorieItemString) {
        this.kategorieItemString = kategorieItemString;
    }

    public int getSortimentUnoReference() {
        return sortimentUnoReference;
    }

    public void setSortimentUnoReference(int sortimentUnoReference) {
        this.sortimentUnoReference = sortimentUnoReference;
    }

    public int getSortimentDosReference() {
        return sortimentDosReference;
    }

    public void setSortimentDosReference(int sortimentDosReference) {
        this.sortimentDosReference = sortimentDosReference;
    }

    public ImageView getSortimentUno() {
        return sortimentUno;
    }

    public void setSortimentUno(ImageView sortimentUno) {
        this.sortimentUno = sortimentUno;
    }

    public ImageView getSortimentDos() {
        return sortimentDos;
    }

    public void setSortimentDos(ImageView sortimentDos) {
        this.sortimentDos = sortimentDos;
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
    public String getSortimentTresString() {
        return sortimentTresString;
    }

    public void setSortimentTresString(String sortimentTresString) {
        this.sortimentTresString = sortimentTresString;
    }

    public String getSortimentQuadroString() {
        return sortimentQuadroString;
    }

    public void setSortimentQuadroString(String sortimentQuadroString) {
        this.sortimentQuadroString = sortimentQuadroString;
    }

    public int getSortimentTresReference() {
        return sortimentTresReference;
    }

    public void setSortimentTresReference(int sortimentTresReference) {
        this.sortimentTresReference = sortimentTresReference;
    }

    public int getSortimentQuadroReference() {
        return sortimentQuadroReference;
    }

    public void setSortimentQuadroReference(int sortimentQuadroReference) {
        this.sortimentQuadroReference = sortimentQuadroReference;
    }
    public String getAdresseString() {
        return adresseString;
    }

    public void setAdresseString(String adresseString) {
        this.adresseString = adresseString;
    }

    public StartseiteActivity getStartseiteActivity() {
        return startseiteActivity;
    }

    public void setStartseiteActivity(StartseiteActivity startseiteActivity) {
        this.startseiteActivity = startseiteActivity;
    }

}
