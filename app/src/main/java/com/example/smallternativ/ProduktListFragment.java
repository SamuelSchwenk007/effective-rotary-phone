package com.example.smallternativ;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
        startseiteActivity.setProduktAdapter(produktAdapter);
        loadAnfragentoList(getContext(), produktAdapter);
        startseiteActivity.setLadenname(Ladenname);
        startseiteActivity.setCameFromSortiment(true);
        startseiteActivity.setToAnfragenpls(false);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }

    @Override
    public void OnProduktClick(int position) {
        ProduktDetailsFragment produktDetailsFragment = new ProduktDetailsFragment();
        produktDetailsFragment.setProduktname(produktAdapter.getAufgaben().get(position).title);
        produktDetailsFragment.setBeschreibungsText(produktAdapter.getAufgaben().get(position).beschreibung);
        produktDetailsFragment.setProductPicReference(produktAdapter.getAufgaben().get(position).profilbildReference);
        produktDetailsFragment.setKategorienProdukt(produktAdapter.getAufgaben().get(position).kategorie);
        produktDetailsFragment.setStartseiteActivity(startseiteActivity);
        startseiteActivity.setSortimenName(Sortimentname);
        startseiteActivity.setLadenname(Ladenname);
        produktDetailsFragment.setLadenname(Ladenname);
        produktDetailsFragment.setSortiment(Sortimentname);
        startseiteActivity.createFragment(produktDetailsFragment);
    }

    public void loadAnfragentoList(Context context, ProduktAdapter produktAdapter){
        if(!produktAdapter.getAufgaben().isEmpty()) {
            produktAdapter.getAufgaben().clear();
        }
            if (Ladenname == "Asiatica") {
                Produkt produktone;
                Produkt produkttwo;
                if (Sortimentname == "Spezielles") {
                    produktone = new Produkt("Fächer", "Breitbandfächer mit Adaptivschraube und ausfahrbaren Kontrollstutzen zwecks einer optimallen Airflow anpassung.", R.drawable.faecher, "Spezielles");
                    produkttwo = new Produkt("Teeset", "Seltenes ming Teeset.", R.drawable.teeset, "Deko, Spezielles");
                } else if (Sortimentname == "Deko") {
                    produktone = new Produkt("Winke-Katze", "Originale Winkekatze.", R.drawable.winkekatze, "Deko");
                    produkttwo = new Produkt("Buddha-Statue", "Traditionelle Buddha Statue.", R.drawable.bhudda, "Deko");

                } else if (Sortimentname == "Sushi") {
                    produktone = new Produkt("Reisrollen", "Köstliche handgemachte Reisrollen.", R.drawable.reisrollen, "Nahrung");
                    produkttwo = new Produkt("Sushi", "Exquisites Shushi vom Fachmann.", R.drawable.sushi, "Nahrung");

                } else {
                    produktone = new Produkt("Spezialpfeffer", "Spezieller Pfeffer aus Asien", R.drawable.spezialpfeffer, "Nahrung, Gewürze");
                    produkttwo = new Produkt("Ingwer", "Spezialingwer aus der Provinz Kant", R.drawable.ingwer, "Nahrung, Gewürze");

                }
                produktAdapter.insertProdukt(produktone);
                produktAdapter.insertProdukt(produkttwo);
            } else if (Ladenname == "Metalworks") {
                Produkt produktone;
                Produkt produkttwo;
                if (Sortimentname == "Schwerter & Messer") {
                    produktone = new Produkt("Templer-Schwert", "Templerschwert 18 Jahundert Nachbau, aus gehärtetem Damaststahl.", R.drawable.templer_schwert, "Waffen, Handgemacht");
                    produkttwo = new Produkt("Einhand-Schwert", "Bei 1600 Grad geschmiedetes Einhand-Schwert für den Hobbybedarf.", R.drawable.einhand_schwert, "Waffen, Handgemacht");
                } else if (Sortimentname == "Hufeisen") {
                    produktone = new Produkt("Eisen-Hufeisen", "Schnittiges Hufeisen aus Eisen. Garantiert nur das Beste für Ihr Tier.", R.drawable.eisen_hufeisen, "Tierbedarf");
                    produkttwo = new Produkt("Stahl-Hufeisen", "Schnittiges Hufeisen aus Stahl. Garantiert nur das Beste für Ihr Tier.", R.drawable.stahl_hufeisen, "Tierbedarf");

                } else if (Sortimentname == "Ringe") {
                    produktone = new Produkt("Handgemachte Eheringe", "Exclusive Gold Eheringe. Handgemacht mit viel Liebe.", R.drawable.eheringe, "Schmuck");
                    produkttwo = new Produkt("Amethysten-Ring", "Luxuriöser Amethysten-Ring mit feinsten Amethysten aus Kolumbien.", R.drawable.violetter_ring, "Schmuck, Luxus");

                } else {
                    produktone = new Produkt("Plattenhandschuhe", "Robuste handgemachte Plattenhandschuhe aus Stahl. Wind und Wasserabweisend.", R.drawable.plattenhandschuhe, "Rüstung");
                    produkttwo = new Produkt("Plattenhelm", "Robuster Plattenhelm aus einer speziellen Stahllegierung für eine besondere Beständigkeit.", R.drawable.plattenhelm, "Rüstung");

                }
                produktAdapter.insertProdukt(produktone);
                produktAdapter.insertProdukt(produkttwo);
            } else {
                Produkt produktone = new Produkt("Handgemachte Eheringe", "Exclusive Gold Eheringe. Handgemacht mit viel Liebe.", R.drawable.eheringe, "Schmuck");
                Produkt produkttwo = new Produkt("Amethysten-Ring", "Luxuriöser Amethysten-Ring mit feinsten Amethysten aus Kolumbien.", R.drawable.violetter_ring, "Schmuck, Luxus");
                Produkt produktthree = new Produkt("Spezialpfeffer", "Spezieller Pfeffer aus Asien", R.drawable.spezialpfeffer, "Nahrung, Gewürze");
                Produkt produktfour = new Produkt("Ingwer", "Spezialingwer aus der Provinz Kant", R.drawable.ingwer, "Nahrung, Gewürze");

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
