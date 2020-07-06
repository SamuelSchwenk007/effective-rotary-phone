package com.example.smallternativ;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavorisierteLaedenFragment extends Fragment implements MyAdapter.ShopListItemListener,PopupMenu.OnMenuItemClickListener  {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private RecyclerView recyclerView;
    private MyAdapter.ShopListItemListener shopListItemListener;
    private Button karte;
    private Button kategorien;
    StartseiteActivity startseiteActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.favorisierte_laeden_layout, container, false);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Favorisierte Läden");
        recyclerView = view.findViewById(R.id.recyclerView_favlaeden);
        MyAdapter myAdapter = MyAdapter.getInstance(getActivity().getApplicationContext(), shopListItemListener);
        loadShopsToList(getActivity().getApplicationContext(),myAdapter);
        karte = view.findViewById(R.id.karte_fav);
        karte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        kategorien = view.findViewById(R.id.kategorie_fav);
        kategorien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showKategoriePopup(view);
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
    public void loadShopsToList(Context context, MyAdapter myAdapter){

        ShopListItem shopListItemTwo = new ShopListItem("Asiatica","Waren aus Asien von Lebensmitteln bis zur Dekoration.",
                R.drawable.asiatica_logo_fixed,"Nahrung, Barrierefrei","Spezielles","Deko","Sushi",
                "Gewürze",R.drawable.asiatica_deko,R.drawable.asiatica_einrichtung,R.drawable.asiatica_essen,R.drawable.asiatica_gewuerze,"Fleischhauerstraße 10.");

        ShopListItem shopListItemThree = new ShopListItem("Cyroline","Hier finden Sie FairTrade geschneiderte Bekleidung.",
                R.drawable.cyroline_logo_fixed,"Kleidung, Modern","Angesagt","Retro","Sale",
                "Speziel",R.drawable.nadel_und_faden_stoffe,R.drawable.nadel_und_faden_knoepfe,R.drawable.nadel_und_faden_faeden,R.drawable.nadel_und_faden_buendchen,"Fleischhauerstraße 49.");

        ShopListItem shopListItemFive = new ShopListItem("Metalworks","Von der Ritterrüstung bis hin zum eleganten Ring. Bei uns erhalten Sie handgeschmiedete Qualitätsware.",
                R.drawable.metalworks_profil,"Custom, Handmade","Hufeisen","Ringe","Rüstungen",
                "Schwerte & Messer",R.drawable.metalworks_hufeisen,R.drawable.metalworks_ringe,R.drawable.metalworks_ruestung,R.drawable.metalworks_schwerter,"Breite Straße 40.");
        myAdapter.insertShopListItem(shopListItemTwo);
        myAdapter.insertShopListItem(shopListItemThree);
        myAdapter.insertShopListItem(shopListItemFive);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
    }
    public void showKategoriePopup(View v){
        Context wrapper = new ContextThemeWrapper(getContext(), R.style.YOURSTYLE);
        PopupMenu popupMenu = new PopupMenu(wrapper,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.kategorie_popup);
        popupMenu.show();
    }

    @Override
    public void OnShopListItemClick(int position) {

    }
    public View getFavFragmentView(){
        return  view;
    }
    public StartseiteActivity getStartseiteActivity() {
        return startseiteActivity;
    }

    public void setStartseiteActivity(StartseiteActivity startseiteActivity) {
        this.startseiteActivity = startseiteActivity;
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
    } public void createStartseiteFragmentWithDeleats(String kategorie){
        startseiteActivity.getBlacklineone().setVisibility(View.INVISIBLE);
        startseiteActivity.getBlacklinetwo().setVisibility(View.VISIBLE);
        startseiteActivity.getBlacklinetree().setVisibility(View.INVISIBLE);
        startseiteActivity.getBlacklinefour().setVisibility(View.INVISIBLE);
        StartseitenFragment startseitenFragment1 = new StartseitenFragment();
        startseitenFragment1.setKategorie(kategorie);
        startseitenFragment1.setDeleat(true);
        startseitenFragment1.setStartseiteActivity(startseiteActivity);
        startseitenFragment1.setSupportActionBar(getSupportActionBar());
        startseiteActivity.createFragment(startseitenFragment1);
        StartseiteActivity.setAppTitle(getSupportActionBar(), getContext(),"Smallternative");
    }

}
