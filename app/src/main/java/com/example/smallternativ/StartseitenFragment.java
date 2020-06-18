package com.example.smallternativ;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.startseitenlayout, container, false);
        setTodoListenerToAdapter(this);
        recyclerView = view.findViewById(R.id.recyclerView);
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
        ShopListItem shopListItemOne = new ShopListItem("Öz Sülo", "Netter Türke um die Ecke", R.drawable.oz_sulo_profilbild);

        ShopListItem shopListItemTwo = new ShopListItem("Asiatica","Netter Asiate um die Ecke",R.drawable.asiatica_profilbild);

        ShopListItem shopListItemThree = new ShopListItem("Cyroline","Nette Mode um die Ecke",R.drawable.cyroline_profilbild);

        ShopListItem shopListItemFour = new ShopListItem("Nadel und Faden","Netter Fäden um die Ecke",R.drawable.nadel_und_faden_profilbild);

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
}
