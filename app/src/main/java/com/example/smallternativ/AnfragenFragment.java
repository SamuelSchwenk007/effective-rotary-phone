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

public class AnfragenFragment extends Fragment implements MyAdapter.ShopListItemListener {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private MyAdapter.ShopListItemListener shopListItemListener;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.anfragen_layout, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_anfragen);
        myAdapter = MyAdapter.getInstance(getContext(),shopListItemListener);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Anfragen");
        loadAnfragentoList(getContext(),myAdapter);
        return view;
    }
    public ActionBar getSupportActionBar() {
        return supportActionBar;
    }

    public void setSupportActionBar(ActionBar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

    @Override
    public void OnShopListItemClick(int position) {

    }
    public void loadAnfragentoList(Context context, MyAdapter myAdapter){

        ShopListItem shopListItemTwo = new ShopListItem("Anfrage An: Asiatica","Frische Papayas",R.drawable.asiatica_logo_fixed);

        ShopListItem shopListItemThree = new ShopListItem("Anfrage An: Cyroline","Neopreen",R.drawable.cyroline_logo_fixed);

        myAdapter.insertShopListItem(shopListItemTwo);
        myAdapter.insertShopListItem(shopListItemThree);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
    }
}
