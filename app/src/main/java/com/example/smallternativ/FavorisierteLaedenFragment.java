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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavorisierteLaedenFragment extends Fragment implements MyAdapter.ShopListItemListener {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private RecyclerView recyclerView;
    private MyAdapter.ShopListItemListener shopListItemListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.favorisierte_laeden_layout, container, false);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Favorisierte Läden");
        recyclerView = view.findViewById(R.id.recyclerView_favlaeden);
        MyAdapter myAdapter = MyAdapter.getInstance(getActivity().getApplicationContext(), shopListItemListener);
        loadShopsToList(getActivity().getApplicationContext(),myAdapter);
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

    @Override
    public void OnShopListItemClick(int position) {

    }
    public View getFavFragmentView(){
        return  view;
    }
}
