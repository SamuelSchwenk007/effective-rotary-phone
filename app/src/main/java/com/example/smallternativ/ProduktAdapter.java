package com.example.smallternativ;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import io.objectbox.Box;

public class ProduktAdapter extends RecyclerView.Adapter  {
    private List<Produkt> ladenListe;
    private static ProduktAdapter todoAdapterInstance;
    private Context context;
    private Box<Produkt> Produktbox;
    private ProduktListener todoListener;
    //get the single instance of the adapter
    public static ProduktAdapter getInstance(Context context, ProduktListener todoListener) {
        if (todoAdapterInstance == null) {
            todoAdapterInstance = new ProduktAdapter(context, todoListener);
        }
        return todoAdapterInstance;
    }
    // get the whole Aufgaben list
    public List<Produkt> getAufgaben() {
        return ladenListe;
    }
    // returns the Produkt at position id
    public Produkt getProdukt(long id) {
        for (Produkt todo : ladenListe) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
    // constructor for the Adapter
    private ProduktAdapter(Context context, ProduktListener todoListener) {
        this.context = context;
        this.todoListener = todoListener;
        // new Aufgaben list
        ladenListe = new ArrayList<>();
        // load all stored Produkts in objectbox
        Produktbox = DatenBank.getInstance(context).getBox().boxFor(Produkt.class);
        // add all stored Produkts to list
        ladenListe.addAll(Produktbox.getAll());

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ladein_eintrag, viewGroup, false);
        return new ProduktViewHolder(view, todoListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Produkt aufgabe = ladenListe.get(i);
        ProduktViewHolder todoHolder = (ProduktViewHolder) viewHolder;
        todoHolder.setCurrentProdukt(aufgabe);
    }

    @Override
    public int getItemCount() {
        return ladenListe.size();
    }

    public void insertProdukt(Produkt Produkt) {
        ladenListe.add(Produkt);
    }

    public void loeschenProdukt(Produkt todo, Context context, ProduktListener todoListener) {
        this.context = context;
        todo = getProdukt(todo.getId());
        Produktbox = DatenBank.getInstance(context).getBox().boxFor(Produkt.class);
        Produktbox.remove(todo);
        ladenListe.remove(todo);
        notifyItemRemoved(((int) todo.getId()));
        notifyItemRangeChanged((int) todo.getId(), ladenListe.size());
        ProduktAdapter.getInstance(context,todoListener).notifyDataSetChanged();
    }
    public void clearallListelements(){
        ladenListe.clear();
        notifyDataSetChanged();
    }
    public void setContext(Context context){
        this.context = context;
    }
    public interface ProduktListener{
        void OnProduktClick(int position);
    }
    public void setProduktlistener(ProduktListener todolistener){
        this.todoListener = todolistener;
    }
    private static class ProduktViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Produkt currentProdukt;
        public TextView ProduktTitle;
        public TextView beschreibungsText;
        public ImageView profilBild;
        public Context context;
        public ProduktListener ProduktListener;


        public ProduktViewHolder(View v, ProduktListener ProduktListener) {
            super(v);
            context = v.getContext();
            profilBild = (ImageView) v.findViewById(R.id.eintrag_bild);
            ProduktTitle = (TextView) v.findViewById(R.id.eintrag_title);
            beschreibungsText = (TextView) v.findViewById(R.id.eintrag_beschreibung);
            this.ProduktListener = ProduktListener;
            v.setOnClickListener(this);
        }

        public void setCurrentProdukt(Produkt Produkt) {
            currentProdukt = Produkt;
            ProduktTitle.setText(Produkt.getTitle());
            ProduktTitle.setTextSize(20);
            String subbeschreibung = "";
            if(Produkt.getBeschreibung().length() > 60) {
                subbeschreibung = Produkt.getBeschreibung().substring(0, 60);
                subbeschreibung = subbeschreibung + " ...";
            }
            else {
                subbeschreibung = Produkt.getBeschreibung().substring(0, Produkt.getBeschreibung().length());
            }
            beschreibungsText.setText(subbeschreibung);
            beschreibungsText.setTextSize(16);
            profilBild.setImageResource(Produkt.getProfilbildReference());
        }

        @Override
        public void onClick(View view) {
            ProduktListener.OnProduktClick(getAdapterPosition());
        }
        public TextView getProduktTitle() {
            return ProduktTitle;
        }

        public void setProduktTitle(TextView ProduktTitle) {
            this.ProduktTitle = ProduktTitle;
        }
        public ProduktAdapter.ProduktListener getProduktListener() {
            return ProduktListener;
        }

        public void setProduktListener(ProduktAdapter.ProduktListener produktListener) {
            ProduktListener = produktListener;
        }

    }
}