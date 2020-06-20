package com.example.smallternativ;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.example.smallternativ.LadenProfilFragment;
import com.example.smallternativ.MyAdapter;
import com.example.smallternativ.R;
import com.example.smallternativ.ShopListItem;
import com.example.smallternativ.StartseiteActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StartseitenFragment extends Fragment implements MyAdapter.ShopListItemListener {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    private MyAdapter.ShopListItemListener shopListItemListener;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    HorizontalScrollView horizontalScrollView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.startseitenlayout, container, false);
        setTodoListenerToAdapter(this);
        recyclerView = view.findViewById(R.id.recyclerView);
       // horizontalScrollView = view.findViewById(R.id.news_scroll_view);
        myAdapter = MyAdapter.getInstance(getContext(),shopListItemListener);
        loadShopsToList(getActivity().getApplicationContext(), myAdapter);
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
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LadenProfilFragment ladenProfilFragment = new LadenProfilFragment();
        fragmentTransaction.add(R.id.fragment_container,ladenProfilFragment);
        fragmentTransaction.commit();
    }
    public void loadShopsToList(Context context, MyAdapter myAdapter){
        ShopListItem shopListItemOne = new ShopListItem("Öz Sülo", "Dr.-Julius-Leber-Straße 3-7. Täglich frisches Obst und Gemüse.", R.drawable.oez_suelo_logo_fixed);

        ShopListItem shopListItemTwo = new ShopListItem("Asiatica","Fleischhauerstraße 10. Waren aus Asien von Lebensmitteln bis zur Dekoration.",R.drawable.asiatica_logo_fixed);

        ShopListItem shopListItemThree = new ShopListItem("Cyroline","Fleischhauerstraße 49. Hier finden Sie FairTrade geschneiderte Bekleidung.",R.drawable.cyroline_logo_fixed);

        ShopListItem shopListItemFour = new ShopListItem("Nadel und Faden","Hüxstraße 59. Hier finden Sie unterschiedliche Stoffe und vieles mehr.",R.drawable.nadel_und_faden_logo_fixed);

        myAdapter.insertShopListItem(shopListItemOne);
        myAdapter.insertShopListItem(shopListItemTwo);
        myAdapter.insertShopListItem(shopListItemThree);
        myAdapter.insertShopListItem(shopListItemFour);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
    }

    public MyAdapter.ShopListItemListener getShopListItemListener(){
        return this;
    }
    public View getStartseitenFragmentView(){
        return view;
    }
}
