package com.example.smallternativ;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.PopupMenu;

import com.example.smallternativ.LadenProfilFragment;
import com.example.smallternativ.MyAdapter;
import com.example.smallternativ.R;
import com.example.smallternativ.ShopListItem;
import com.example.smallternativ.StartseiteActivity;

import java.util.ArrayList;

import javax.crypto.KeyAgreement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StartseitenFragment extends Fragment implements MyAdapter.ShopListItemListener, PopupMenu.OnMenuItemClickListener {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private MyAdapter.ShopListItemListener shopListItemListener;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    Button kategorien;
    StartseiteActivity startseiteActivity;
    boolean deleat= false;
    String kategorie;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.startseitenlayout, container, false);
        setTodoListenerToAdapter(this);
        recyclerView = view.findViewById(R.id.recyclerView);
        kategorien = view.findViewById(R.id.kategorie);
        myAdapter = MyAdapter.getInstance(getContext(),shopListItemListener);
        loadShopsToList(getActivity().getApplicationContext(), myAdapter);
        if(deleat){
            deleatSomeShops(kategorie);
        }
        deleat = false;
        if(startseiteActivity.liste == null) {
            startseiteActivity.liste = new ArrayList<>();
            for(int i= 0;i<myAdapter.getAufgaben().size();i ++ ){
                startseiteActivity.liste.add(myAdapter.getAufgaben().get(i));
            }
        }

        return view;
    }
    public void setTodoListenerToAdapter(MyAdapter.ShopListItemListener shopListItemListener){
        MyAdapter adapter = MyAdapter.getInstance(getContext(), shopListItemListener);
        adapter.setShopListItemlistener(this);
    }

    public ActionBar getSupportActionBar() {
        return supportActionBar;
    }

    public void setSupportActionBar(ActionBar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
    @Override
    public void OnShopListItemClick(int position) {
        myAdapter = MyAdapter.getInstance(getContext(),shopListItemListener);
        LadenProfilFragment ladenProfilFragment = new LadenProfilFragment();
        ladenProfilFragment.setSupportActionBar(supportActionBar);
        ladenProfilFragment.setMyAdapter(myAdapter);
        ladenProfilFragment.setLadenNameString(myAdapter.getAufgaben().get(position).title);
        ladenProfilFragment.setLadenBeschribungString(myAdapter.getAufgaben().get(position).beschreibung);
        ladenProfilFragment.setLadenPicReference(myAdapter.getAufgaben().get(position).profilbildReference);
        ladenProfilFragment.setKategorieItemString(myAdapter.getAufgaben().get(position).kategorie);
        ladenProfilFragment.setAdresseString(myAdapter.getAufgaben().get(position).adresse);
        ladenProfilFragment.setSortimentUnoReference(myAdapter.getAufgaben().get(position).sortimentReferenceUno);
        ladenProfilFragment.setSortimentDosReference(myAdapter.getAufgaben().get(position).sortimentReferenceDos);
        ladenProfilFragment.setSortimentTresReference(myAdapter.getAufgaben().get(position).sortimentThresReference);
        ladenProfilFragment.setSortimentQuadroReference(myAdapter.getAufgaben().get(position).sortimentQuadroReference);
        ladenProfilFragment.setSortimentUnoString(myAdapter.getAufgaben().get(position).getSortimentUnoString());
        ladenProfilFragment.setSortimentDosString(myAdapter.getAufgaben().get(position).getSortimentDosString());
        ladenProfilFragment.setSortimentTresString(myAdapter.getAufgaben().get(position).getSortimentThresString());
        ladenProfilFragment.setSortimentQuadroString(myAdapter.getAufgaben().get(position).getSortimentQuadroString());
        startseiteActivity.createFragment(ladenProfilFragment);
    }
    public void loadShopsToList(Context context, MyAdapter myAdapter){
        ShopListItem shopListItemOne = new ShopListItem("Öz Sülo", "Täglich frisches Obst und Gemüse.",
                R.drawable.oez_suelo_logo_fixed,"Nahrung, Frisch","Obst","Gemüse",
                "Gewürze","Neues",R.drawable.oez_suelo_fruechte,R.drawable.oez_suelo_gemuese,R.drawable.oez_suelo_gewuerze,
                R.drawable.oez_suelo_obst,"Dr.-Julius-Leber-Straße 3-7.");

        ShopListItem shopListItemTwo = new ShopListItem("Asiatica","Waren aus Asien von Lebensmitteln bis zur Dekoration.",
                R.drawable.asiatica_logo_fixed,"Nahrung, Barrierefrei","Spezialitäten","Deko","Sushi",
                "Gewürze",R.drawable.asiatica_deko,R.drawable.asiatica_einrichtung,R.drawable.asiatica_essen,R.drawable.asiatica_gewuerze,"Fleischhauerstraße 10.");

        ShopListItem shopListItemThree = new ShopListItem("Cyroline","Hier finden Sie FairTrade geschneiderte Bekleidung.",
                R.drawable.cyroline_logo_fixed,"Kleidung, Modern","Angesagt","Retro","Basics",
                "Sale",R.drawable.cyroline_jacken,R.drawable.cyroline_kleider,R.drawable.cyroline_pullover,R.drawable.cyroline_shirts,"Fleischhauerstraße 49.");

        ShopListItem shopListItemFour = new ShopListItem("Nadel und Faden","Hier finden Sie unterschiedliche Stoffe.",
                R.drawable.nadel_und_faden_logo_fixed,"Basteln, Handmade","Stoffe","Knöpfe","Fäden",
                "Füllungen",R.drawable.nadel_und_faden_stoffe,R.drawable.nadel_und_faden_knoepfe,R.drawable.nadel_und_faden_faeden,R.drawable.nadel_und_faden_buendchen,"Hüxstraße 59.");

        ShopListItem shopListItemFive = new ShopListItem("Metalworks","Von der Ritterrüstung bis hin zum eleganten Ring. Bei uns erhalten Sie handgeschmiedete Qualitätsware.",
                R.drawable.metalworks_profil,"Custom, Handmade","Hufeisen","Ringe","Rüstungen",
                "Schwerte & Messer",R.drawable.metalworks_hufeisen,R.drawable.metalworks_ringe,R.drawable.metalworks_ruestung,R.drawable.metalworks_schwerter,"Breite Straße 40.");

        ShopListItem shopListItemSix = new ShopListItem("Asia-Ambiente","Richten Sie ihr Haus in einem exotischen asiatischen Stil ein. Bei unseren Qualitätsmöbeln finden Sie bestimmt etwas nach ihrem Geschmack.",
                R.drawable.asia_ambiente_profil,"Deko, Extravagant","Deko","Gartenmöbel","Kotatsus",
                "Schränke",R.drawable.asia_ambiente_deko,R.drawable.asia_ambiente_gartenmoebel,R.drawable.asia_ambiente_kotatsus,R.drawable.asia_ambiente_schraenke,"Breite Straße 40.");
        myAdapter.insertShopListItem(shopListItemOne);
        myAdapter.insertShopListItem(shopListItemTwo);
        myAdapter.insertShopListItem(shopListItemThree);
        myAdapter.insertShopListItem(shopListItemFour);
        myAdapter.insertShopListItem(shopListItemFive);
        myAdapter.insertShopListItem(shopListItemSix);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
    }
    public void deleatSomeShops(String kategorie){
        myAdapter = MyAdapter.getInstance(getContext(),getShopListItemListener());
        ShopListItem poszero = myAdapter.getAufgaben().get(0);
        ShopListItem posone = myAdapter.getAufgaben().get(1);
        ShopListItem postwo = myAdapter.getAufgaben().get(2);
        ShopListItem postree = myAdapter.getAufgaben().get(3);
        ShopListItem posfour = myAdapter.getAufgaben().get(4);
        ShopListItem posfive = myAdapter.getAufgaben().get(5);

        if(kategorie == "Lebensmittel") {
            myAdapter.getAufgaben().remove(postwo);
            myAdapter.getAufgaben().remove(postree);
            myAdapter.getAufgaben().remove(posfour);
            myAdapter.getAufgaben().remove(posfive);
        }
        else if (kategorie == "Kleidung"){
            myAdapter.getAufgaben().remove(poszero);
            myAdapter.getAufgaben().remove(posone);
            myAdapter.getAufgaben().remove(postree);
            myAdapter.getAufgaben().remove(posfour);
            myAdapter.getAufgaben().remove(posfive);

        }
        else if (kategorie == "Dekoration"){
            myAdapter.getAufgaben().remove(poszero);
            myAdapter.getAufgaben().remove(postwo);
            myAdapter.getAufgaben().remove(postree);
            myAdapter.getAufgaben().remove(posfour);

        }
        else if (kategorie == "Barrierefrei"){
            myAdapter.getAufgaben().remove(poszero);
            myAdapter.getAufgaben().remove(posone);
        }
        else if (kategorie == "MaxEntfernung"){
            myAdapter.getAufgaben().remove(posone);
            myAdapter.getAufgaben().remove(posfour);
        }
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.lebensmittel:
                createStartseiteFragmentWithDeleats("Lebensmittel");

                return true;
            case R.id.kleidung:
                createStartseiteFragmentWithDeleats("Kleidung");
                return true;
            case R.id.dekoration:
                createStartseiteFragmentWithDeleats("Dekoration");
                return true;
            case R.id.nur_barrierefrei:
                createStartseiteFragmentWithDeleats("Barrierefrei");
                return true;
            case R.id.max_Entfernung:
                createStartseiteFragmentWithDeleats("MaxEntfernung");
                return true;
            default:
                return false;
        }
    }
    public void createStartseiteFragmentWithDeleats(String kategorie){
        startseiteActivity.getBlacklineone().setVisibility(View.VISIBLE);
        startseiteActivity.getBlacklinetwo().setVisibility(View.INVISIBLE);
        startseiteActivity.getBlacklinetree().setVisibility(View.INVISIBLE);
        startseiteActivity.getBlacklinefour().setVisibility(View.INVISIBLE);
        startseiteActivity.getBlacklinefive().setVisibility(View.INVISIBLE);
        StartseitenFragment startseitenFragment1 = new StartseitenFragment();
        startseitenFragment1.setKategorie(kategorie);
        startseitenFragment1.setDeleat(true);
        startseitenFragment1.setStartseiteActivity(startseiteActivity);
        startseitenFragment1.setSupportActionBar(getSupportActionBar());
        startseiteActivity.createFragment(startseitenFragment1);
        StartseiteActivity.setAppTitle(getSupportActionBar(), getContext(),"Smallternative");
    }

    public MyAdapter.ShopListItemListener getShopListItemListener(){
        return this;
    }
    public View getStartseitenFragmentView(){
        return view;
    }
    public StartseiteActivity getStartseiteActivity() {
        return startseiteActivity;
    }

    public void setStartseiteActivity(StartseiteActivity startseiteActivity) {
        this.startseiteActivity = startseiteActivity;
    }
    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }
    public boolean isDeleat() {
        return deleat;
    }

    public void setDeleat(boolean deleat) {
        this.deleat = deleat;
    }
}
