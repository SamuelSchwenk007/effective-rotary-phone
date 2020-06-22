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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.startseitenlayout, container, false);
        setTodoListenerToAdapter(this);
        recyclerView = view.findViewById(R.id.recyclerView);
        kategorien = view.findViewById(R.id.kategorie);
        myAdapter = MyAdapter.getInstance(getContext(),shopListItemListener);
        loadShopsToList(getActivity().getApplicationContext(), myAdapter);
        kategorien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View newview = new View(getContext());
                showMenuPopup(newview);
            }
        });
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
        ladenProfilFragment.setSupportActionBar(getSupportActionBar());
        ladenProfilFragment.setMyAdapter(myAdapter);
        ladenProfilFragment.setLadenNameString(myAdapter.getAufgaben().get(position).title);
        ladenProfilFragment.setLadenBeschribungString(myAdapter.getAufgaben().get(position).beschreibung);
        ladenProfilFragment.setLadenPicReference(myAdapter.getAufgaben().get(position).profilbildReference);
        ladenProfilFragment.setKategorieItemString(myAdapter.getAufgaben().get(position).kategorie);
       // ladenProfilFragment.setLadenAdresse(myAdapter.getAufgaben().get(position).adresse);
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
        ShopListItem shopListItemOne = new ShopListItem("Öz Sülo", "Dr.-Julius-Leber-Straße 3-7. Täglich frisches Obst und Gemüse.",
                R.drawable.oez_suelo_logo_fixed,"Nahrung, Frisch","Gemüse","Spezialitäten",
                "Angebote","Neues",R.drawable.stoffe,R.drawable.knoepfe,R.drawable.stoffe,R.drawable.knoepfe);

        ShopListItem shopListItemTwo = new ShopListItem("Asiatica","Fleischhauerstraße 10. Waren aus Asien von Lebensmitteln bis zur Dekoration.",
                R.drawable.asiatica_logo_fixed,"Nahrung, Barrierefrei","Gemüse","Fleisch","Asia",
                "Thai",R.drawable.stoffe,R.drawable.knoepfe,R.drawable.stoffe,R.drawable.knoepfe);

        ShopListItem shopListItemThree = new ShopListItem("Cyroline","Fleischhauerstraße 49. Hier finden Sie FairTrade geschneiderte Bekleidung.",
                R.drawable.cyroline_logo_fixed,"Kleidung, Modern","Angesagt","Retro","Sale",
                "Speziel",R.drawable.stoffe,R.drawable.knoepfe,R.drawable.stoffe,R.drawable.knoepfe);

        ShopListItem shopListItemFour = new ShopListItem("Nadel und Faden","Hüxstraße 59. Hier finden Sie unterschiedliche Stoffe und vieles mehr.",
                R.drawable.nadel_und_faden_logo_fixed,"Basteln, Handmade","Stoffe","Knöpfe","Fäden",
                "Füllungen",R.drawable.stoffe,R.drawable.knoepfe,R.drawable.stoffe,R.drawable.knoepfe);

        myAdapter.insertShopListItem(shopListItemOne);
        myAdapter.insertShopListItem(shopListItemTwo);
        myAdapter.insertShopListItem(shopListItemThree);
        myAdapter.insertShopListItem(shopListItemFour);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
    }
    public void showMenuPopup(View v){
        PopupMenu popupMenu = new PopupMenu(getContext(),v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.kategorie_popup);
        popupMenu.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.lebensmittel:
                //Todo
                return true;
            case R.id.kleidung:
                //Todo
                return true;
            case R.id.dekoration:
                //Todo
                return true;
            case R.id.nur_barrierefrei:
                //Todo
                return true;
            case R.id.max_Entfernung:
                //Todo
                return true;
            case R.id.bestaetigen:
                //Todo
                return true;
            default:
                return false;
        }
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
}
