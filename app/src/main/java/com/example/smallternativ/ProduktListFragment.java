package com.example.smallternativ;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProduktListFragment extends Fragment implements ProduktAdapter.ProduktListener {
    private androidx.appcompat.app.ActionBar supportActionBar;
    ProduktAdapter.ProduktListener produktListener;
    ProduktAdapter produktAdapter;
    RecyclerView recyclerView;
    String Sortimentname;
    String Ladenname;
    StartseiteActivity startseiteActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.produkt_list_layout,container, false);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),Sortimentname);
        setProduktListenerToAdapter(produktListener);
        recyclerView = view.findViewById(R.id.recyclerView_produkte);
        produktAdapter = ProduktAdapter.getInstance(getContext(),produktListener);
        loadAnfragentoList(getContext(), produktAdapter);
        return view;
    }

    @Override
    public void OnProduktClick(int position) {
        ProduktDetailsFragment produktDetailsFragment = new ProduktDetailsFragment();
        produktDetailsFragment.setProduktname(produktAdapter.getAufgaben().get(position).title);
        produktDetailsFragment.setBeschreibungsText(produktAdapter.getAufgaben().get(position).beschreibung);
        produktDetailsFragment.setProductPicReference(produktAdapter.getAufgaben().get(position).profilbildReference);
        produktDetailsFragment.setKategorienProdukt(produktAdapter.getAufgaben().get(position).kategorie);
        startseiteActivity.createFragment(produktDetailsFragment);
    }
    public void loadAnfragentoList(Context context, ProduktAdapter produktAdapter){
        if(Ladenname =="Asiatica") {
            Produkt produktone = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");
            Produkt produkttwo = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");
            Produkt produktthree = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");
            Produkt produktfour = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");

            produktAdapter.insertProdukt(produktone);
            produktAdapter.insertProdukt(produkttwo);
            produktAdapter.insertProdukt(produktthree);
            produktAdapter.insertProdukt(produktfour);
        }
        else if (Ladenname =="Metalworks"){
            Produkt produktone = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");
            Produkt produkttwo = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");
            Produkt produktthree = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");
            Produkt produktfour = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");

            produktAdapter.insertProdukt(produktone);
            produktAdapter.insertProdukt(produkttwo);
            produktAdapter.insertProdukt(produktthree);
            produktAdapter.insertProdukt(produktfour);

        }
        else{
            Produkt produktone = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");
            Produkt produkttwo = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");
            Produkt produktthree = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");
            Produkt produktfour = new Produkt("Dekoobjekt", "Tolle Deko", R.drawable.asiatica_logo_fixed, "Deko");

            produktAdapter.insertProdukt(produktone);
            produktAdapter.insertProdukt(produkttwo);
            produktAdapter.insertProdukt(produktthree);
            produktAdapter.insertProdukt(produktfour);
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(produktAdapter);
    }
    public void setProduktListenerToAdapter(ProduktAdapter.ProduktListener produktListener){
        ProduktAdapter adapter = produktAdapter.getInstance(getContext(), produktListener);
        adapter.setProduktlistener(this);
    }

    public ActionBar getSupportActionBar() {
        return supportActionBar;
    }

    public void setSupportActionBar(ActionBar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

    public String getSortimentname() {
        return Sortimentname;
    }

    public void setSortimentname(String sortimentname) {
        Sortimentname = sortimentname;
    }
    public String getLadenname() {
        return Ladenname;
    }

    public void setLadenname(String ladenname) {
        Ladenname = ladenname;
    }

    public StartseiteActivity getStartseiteActivity() {
        return startseiteActivity;
    }

    public void setStartseiteActivity(StartseiteActivity startseiteActivity) {
        this.startseiteActivity = startseiteActivity;
    }


}
