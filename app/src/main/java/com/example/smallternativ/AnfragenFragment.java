package com.example.smallternativ;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AnfragenFragment extends Fragment implements AnfragenAdapter.shopListItemListenerDos {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private AnfragenAdapter.shopListItemListenerDos shopListItemListenerDos;
    RecyclerView recyclerView;
    AnfragenAdapter AnfragenAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.anfragen_layout, container, false);
        setTodoListenerDosToAdapter(shopListItemListenerDos);
        recyclerView = view.findViewById(R.id.recyclerView_anfragen);
        AnfragenAdapter = AnfragenAdapter.getInstance(getContext(),shopListItemListenerDos);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Anfragen");
        loadAnfragentoList(getContext(),AnfragenAdapter);
        return view;
    }
    public void setTodoListenerDosToAdapter(AnfragenAdapter.shopListItemListenerDos shopListItemListener){
        AnfragenAdapter adapter = AnfragenAdapter.getInstance(getContext(), shopListItemListener);
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
            System.out.println("Lüppt");
    }
    public void loadAnfragentoList(Context context, AnfragenAdapter AnfragenAdapter){
        ShopListItem shopListItemTwo = new ShopListItem("Anfrage An: Asiatica","Frische Papayas",
                R.drawable.asiatica_logo_fixed,"Nahrung, Barrierefrei","Gemüse","Fleisch","Asia",
                "Thai",R.drawable.stoffe,R.drawable.knoepfe,R.drawable.stoffe,R.drawable.knoepfe,"Fleischhauerstraße 10.");

        ShopListItem shopListItemThree = new ShopListItem("Anfrage An: Cyroline","Neopreen",
                R.drawable.cyroline_logo_fixed,"Kleidung, Modern","Angesagt","Retro","Sale",
                "Speziel",R.drawable.stoffe,R.drawable.knoepfe,R.drawable.stoffe,R.drawable.knoepfe,"Fleischhauerstraße 49.");
        AnfragenAdapter.insertShopListItem(shopListItemTwo);
        AnfragenAdapter.insertShopListItem(shopListItemThree);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(AnfragenAdapter);
    }
}
