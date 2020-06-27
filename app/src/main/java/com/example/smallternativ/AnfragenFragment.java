package com.example.smallternativ;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AnfragenFragment extends Fragment implements AnfragenAdapter.shopListItemListenerDos {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private AnfragenAdapter.shopListItemListenerDos shopListItemListenerDos;
    RecyclerView recyclerView;
    AnfragenAdapter anfragenAdapter;
    StartseiteActivity startseiteActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.anfragen_layout, container, false);
        setTodoListenerDosToAdapter(shopListItemListenerDos);
        recyclerView = view.findViewById(R.id.recyclerView_anfragen);
        anfragenAdapter = anfragenAdapter.getInstance(getContext(),shopListItemListenerDos);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Anfragen");
        loadAnfragentoList(getContext(), anfragenAdapter);
        return view;
    }
    public void setTodoListenerDosToAdapter(AnfragenAdapter.shopListItemListenerDos shopListItemListener){
        AnfragenAdapter adapter = anfragenAdapter.getInstance(getContext(), shopListItemListener);
        adapter.setshopListItemListenerDos(this);
    }
    public ActionBar getSupportActionBar() {
        return supportActionBar;
    }

    public void setSupportActionBar(ActionBar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

    @Override
    public void OnShopListItemClick(int position) {
            if(anfragenAdapter.getAufgaben().get(position).getStatus() =="Status: angenommen"){
                AnfrageDetailsFragmentAngenommen anfrageDetailsFragmentAngenommen = new AnfrageDetailsFragmentAngenommen();
                anfrageDetailsFragmentAngenommen.setSupportActionBar(supportActionBar);
                anfrageDetailsFragmentAngenommen.setProduktString(anfragenAdapter.getAufgaben().get(position).produkt);
                anfrageDetailsFragmentAngenommen.setLadenNameString(anfragenAdapter.getAufgaben().get(position).ladenName);
                anfrageDetailsFragmentAngenommen.setAnzahlString(anfragenAdapter.getAufgaben().get(position).anzahl);
                anfrageDetailsFragmentAngenommen.setDatumString(anfragenAdapter.getAufgaben().get(position).datum);
                anfrageDetailsFragmentAngenommen.setStatusString(anfragenAdapter.getAufgaben().get(position).status);
                anfrageDetailsFragmentAngenommen.setAntwortString(anfragenAdapter.getAufgaben().get(position).antwort);
                anfrageDetailsFragmentAngenommen.setProfilPicReference(anfragenAdapter.getAufgaben().get(position).profilbildReference);
                anfrageDetailsFragmentAngenommen.setProduktDetailsString(anfragenAdapter.getAufgaben().get(position).produktdetails);
                anfrageDetailsFragmentAngenommen.setStartseiteActivity(startseiteActivity);
                creatFragment(anfrageDetailsFragmentAngenommen);
            }
            else if(anfragenAdapter.getAufgaben().get(position).getStatus() =="Status: abgelehnt") {
                AnfrageDetailsFragmentAbgelehnt anfrageDetailsFragmentAbgelehnt = new AnfrageDetailsFragmentAbgelehnt();
                anfrageDetailsFragmentAbgelehnt.setSupportActionBar(supportActionBar);
                anfrageDetailsFragmentAbgelehnt.setProduktString(anfragenAdapter.getAufgaben().get(position).produkt);
                anfrageDetailsFragmentAbgelehnt.setLadenNameString(anfragenAdapter.getAufgaben().get(position).ladenName);
                anfrageDetailsFragmentAbgelehnt.setAnzahlString(anfragenAdapter.getAufgaben().get(position).anzahl);
                anfrageDetailsFragmentAbgelehnt.setDatumString(anfragenAdapter.getAufgaben().get(position).datum);
                anfrageDetailsFragmentAbgelehnt.setStatusString(anfragenAdapter.getAufgaben().get(position).status);
                anfrageDetailsFragmentAbgelehnt.setAntwortString(anfragenAdapter.getAufgaben().get(position).antwort);
                anfrageDetailsFragmentAbgelehnt.setProfilPicReference(anfragenAdapter.getAufgaben().get(position).profilbildReference);
                anfrageDetailsFragmentAbgelehnt.setProduktDetailsString(anfragenAdapter.getAufgaben().get(position).produktdetails);
                creatFragment(anfrageDetailsFragmentAbgelehnt);
            }
            else {
                AnfrageDetailsFragmentUnbeantwortet anfrageDetailsFragmentUnbeantwortet = new AnfrageDetailsFragmentUnbeantwortet();
                anfrageDetailsFragmentUnbeantwortet.setSupportActionBar(supportActionBar);
                anfrageDetailsFragmentUnbeantwortet.setProduktString(anfragenAdapter.getAufgaben().get(position).produkt);
                anfrageDetailsFragmentUnbeantwortet.setLadenNameString(anfragenAdapter.getAufgaben().get(position).ladenName);
                anfrageDetailsFragmentUnbeantwortet.setAnzahlString(anfragenAdapter.getAufgaben().get(position).anzahl);
                anfrageDetailsFragmentUnbeantwortet.setDatumString(anfragenAdapter.getAufgaben().get(position).datum);
                anfrageDetailsFragmentUnbeantwortet.setStatusString(anfragenAdapter.getAufgaben().get(position).status);
                anfrageDetailsFragmentUnbeantwortet.setAntwortString(anfragenAdapter.getAufgaben().get(position).antwort);
                anfrageDetailsFragmentUnbeantwortet.setProfilPicReference(anfragenAdapter.getAufgaben().get(position).profilbildReference);
                anfrageDetailsFragmentUnbeantwortet.setProduktDetailsString(anfragenAdapter.getAufgaben().get(position).produktdetails);
                anfrageDetailsFragmentUnbeantwortet.setStartseiteActivity(startseiteActivity);
                anfrageDetailsFragmentUnbeantwortet.setAdapterPosition(position);
                creatFragment(anfrageDetailsFragmentUnbeantwortet);
            }
    }
    public void loadAnfragentoList(Context context, AnfragenAdapter AnfragenAdapter){
        ShopListItem shopListItemTwo = new ShopListItem(R.drawable.asiatica_logo_fixed,"Papaya",
                "Laden: Asiatica","Anzahl: 3","Datum: 12.05.2020","Status: angenommen",
                "Leckere Papayas können wir dir gerne zu Verfügung stellen","Produkt: Papaya 300 g");

        ShopListItem shopListItemThree = new ShopListItem(R.drawable.cyroline_logo_fixed,"Neopren",
                "Laden: Cyroline","Anzahl: 1","Datum: 18.05.2020","Status: abgelehnt",
                "Dieses Geschäft lohnt sich leider nicht für mich","Produkt: Neopren 40 mal 40");

        ShopListItem shopListItemFour = new ShopListItem(R.drawable.nadel_und_faden_logo_fixed,"Stopfwolle",
                "Laden: Nadel und Faden","Anzahl: 5","Datum: 20.06.2020","Status: unbearbeitet",
                "Noch keine Antwort erhalten","Produkt: Stopfwolle 2 m");

        AnfragenAdapter.insertShopListItem(shopListItemTwo);
        AnfragenAdapter.insertShopListItem(shopListItemThree);
        AnfragenAdapter.insertShopListItem(shopListItemFour);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(AnfragenAdapter);
    }
    public AnfragenAdapter.shopListItemListenerDos getShopListItemListenerDos(){
        return this;
    }
    public void creatFragment(Fragment fragment){
        anfragenAdapter.clearallListelements();
        startseiteActivity.removeAllFragment();
        startseiteActivity.fragmentList.add(fragment);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }
    public StartseiteActivity getStartseiteActivity() {
        return startseiteActivity;
    }

    public void setStartseiteActivity(StartseiteActivity startseiteActivity) {
        this.startseiteActivity = startseiteActivity;
    }

}
