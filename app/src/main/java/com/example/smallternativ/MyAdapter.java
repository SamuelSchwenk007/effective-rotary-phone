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

public class MyAdapter extends RecyclerView.Adapter  {
    private List<ShopListItem> ladenListe;
    private static MyAdapter todoAdapterInstance;
    private Context context;
    private Box<ShopListItem> ShopListItembox;
    private ShopListItemListener todoListener;
    //get the single instance of the adapter
    public static MyAdapter getInstance(Context context, ShopListItemListener todoListener) {
        if (todoAdapterInstance == null) {
            todoAdapterInstance = new MyAdapter(context, todoListener);
        }
        return todoAdapterInstance;
    }
    // get the whole Aufgaben list
    public List<ShopListItem> getAufgaben() {
        return ladenListe;
    }
    // returns the ShopListItem at position id
    public ShopListItem getShopListItem(long id) {
        for (ShopListItem todo : ladenListe) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
    // constructor for the Adapter
    private MyAdapter(Context context, ShopListItemListener todoListener) {
        this.context = context;
        this.todoListener = todoListener;
        // new Aufgaben list
        ladenListe = new ArrayList<>();
        // load all stored ShopListItems in objectbox
        ShopListItembox = DatenBank.getInstance(context).getBox().boxFor(ShopListItem.class);
        // add all stored ShopListItems to list
        ladenListe.addAll(ShopListItembox.getAll());

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ladein_eintrag, viewGroup, false);
        return new ShopListItemViewHolder(view, todoListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ShopListItem aufgabe = ladenListe.get(i);
        ShopListItemViewHolder todoHolder = (ShopListItemViewHolder) viewHolder;
        todoHolder.setCurrentShopListItem(aufgabe);
    }

    @Override
    public int getItemCount() {
        return ladenListe.size();
    }

    public void insertShopListItem(ShopListItem shopListItem) {
        ladenListe.add(shopListItem);
    }

    public void loeschenShopListItem(ShopListItem todo, Context context, ShopListItemListener todoListener) {
        this.context = context;
        todo = getShopListItem(todo.getId());
        ShopListItembox = DatenBank.getInstance(context).getBox().boxFor(ShopListItem.class);
        ShopListItembox.remove(todo);
        ladenListe.remove(todo);
        notifyItemRemoved(((int) todo.getId()));
        notifyItemRangeChanged((int) todo.getId(), ladenListe.size());
        MyAdapter.getInstance(context,todoListener).notifyDataSetChanged();
    }
    public void clearallListelements(){
        ladenListe.clear();
        notifyDataSetChanged();
    }
    public void setContext(Context context){
        this.context = context;
    }
    public interface ShopListItemListener{
        void OnShopListItemClick(int position);
    }
    public void setShopListItemlistener(ShopListItemListener todolistener){
        this.todoListener = todolistener;
    }
    private static class ShopListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ShopListItem currentShopListItem;
        public TextView shoplistItemTitle;
        public TextView beschreibungsText;
        public ImageView profilBild;
        public Context context;
        public ShopListItemListener shopListItemListener;


        public ShopListItemViewHolder(View v, ShopListItemListener shopListItemListener) {
            super(v);
            context = v.getContext();
            profilBild = (ImageView) v.findViewById(R.id.eintrag_bild);
            shoplistItemTitle = (TextView) v.findViewById(R.id.eintrag_title);
            beschreibungsText = (TextView) v.findViewById(R.id.eintrag_beschreibung);
            this.shopListItemListener = shopListItemListener;
            v.setOnClickListener(this);
        }

        public void setCurrentShopListItem(ShopListItem shopListItem) {
            currentShopListItem = shopListItem;
            shoplistItemTitle.setText(shopListItem.getTitle());
            shoplistItemTitle.setTextSize(20);
            String subbeschreibung = "";
            if(shopListItem.getBeschreibung().length() > 60) {
                subbeschreibung = shopListItem.getBeschreibung().substring(0, 60);
                subbeschreibung = subbeschreibung + " ...";
            }
            else {
                subbeschreibung = shopListItem.getBeschreibung().substring(0, shopListItem.getBeschreibung().length());
            }
            beschreibungsText.setText(subbeschreibung);
            beschreibungsText.setTextSize(16);
            profilBild.setImageResource(shopListItem.getProfilbildReference());
        }

        @Override
        public void onClick(View view) {
            shopListItemListener.OnShopListItemClick(getAdapterPosition());
        }
        public TextView getShoplistItemTitle() {
            return shoplistItemTitle;
        }

        public void setShoplistItemTitle(TextView shoplistItemTitle) {
            this.shoplistItemTitle = shoplistItemTitle;
        }
    }
}