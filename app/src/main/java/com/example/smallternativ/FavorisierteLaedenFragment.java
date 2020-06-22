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

        ShopListItem shopListItemTwo = new ShopListItem("Asiatica","Fleischhauerstraße 10. Waren aus Asien von Lebensmitteln bis zur Dekoration.",
                R.drawable.asiatica_logo_fixed,"Nahrung, Barrierefrei","Gemüse","Fleisch","Asia",
                "Thai",R.drawable.stoffe,R.drawable.knoepfe,R.drawable.stoffe,R.drawable.knoepfe);

        ShopListItem shopListItemThree = new ShopListItem("Cyroline","Fleischhauerstraße 49. Hier finden Sie FairTrade geschneiderte Bekleidung.",
                R.drawable.cyroline_logo_fixed,"Kleidung, Modern","Angesagt","Retro","Sale",
                "Speziel",R.drawable.stoffe,R.drawable.knoepfe,R.drawable.stoffe,R.drawable.knoepfe);
        myAdapter.insertShopListItem(shopListItemTwo);
        myAdapter.insertShopListItem(shopListItemThree);



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
