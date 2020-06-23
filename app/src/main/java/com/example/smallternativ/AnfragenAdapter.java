package com.example.smallternativ;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import io.objectbox.Box;

public class AnfragenAdapter extends RecyclerView.Adapter  {
    private List<ShopListItem> ladenListe;
    private static AnfragenAdapter todoAdapterInstance;
    private Context context;
    private Box<ShopListItem> ShopListItembox;
    private shopListItemListenerDos todoListener;
    //get the single instance of the adapter
    public static AnfragenAdapter getInstance(Context context, shopListItemListenerDos todoListener) {
        if (todoAdapterInstance == null) {
            todoAdapterInstance = new AnfragenAdapter(context, todoListener);
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
    private AnfragenAdapter(Context context, shopListItemListenerDos todoListener) {
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
        View view = inflater.inflate(R.layout.laden_eintrag_anfragen, viewGroup, false);
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

    public void loeschenShopListItem(ShopListItem todo, Context context, shopListItemListenerDos todoListener) {
        this.context = context;
        todo = getShopListItem(todo.getId());
        ShopListItembox = DatenBank.getInstance(context).getBox().boxFor(ShopListItem.class);
        ShopListItembox.remove(todo);
        ladenListe.remove(todo);
        notifyItemRemoved(((int) todo.getId()));
        notifyItemRangeChanged((int) todo.getId(), ladenListe.size());
        AnfragenAdapter.getInstance(context,todoListener).notifyDataSetChanged();
    }
    public void clearallListelements(){
        ladenListe.clear();
        notifyDataSetChanged();
    }
    public void setContext(Context context){
        this.context = context;
    }
    public interface shopListItemListenerDos{
        void OnShopListItemClick(int position);
    }
    public void setshopListItemListenerDos(shopListItemListenerDos todolistener){
        this.todoListener = todolistener;
    }
    private static class ShopListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ShopListItem currentShopListItem;
        public TextView shoplistItemTitle;
        public TextView beschreibungsText;
        public ImageView profilBild;
        public CheckBox anfragenCheckbox;
        public Context context;
        public shopListItemListenerDos shopListItemListenerDos;


        public ShopListItemViewHolder(View v, shopListItemListenerDos shopListItemListenerDos) {
            super(v);
            context = v.getContext();
            profilBild = (ImageView) v.findViewById(R.id.eintrag_bild_anfragen);
            shoplistItemTitle = (TextView) v.findViewById(R.id.eintrag_title_anfragen);
            beschreibungsText = (TextView) v.findViewById(R.id.eintrag_beschreibung_anfragen);
            anfragenCheckbox = (CheckBox) v.findViewById(R.id.checkBox_anfragen);
            this.shopListItemListenerDos = shopListItemListenerDos;
            v.setOnClickListener(this);
        }

        public void setCurrentShopListItem(ShopListItem shopListItem) {
            currentShopListItem = shopListItem;
            String ladenName = shopListItem.getLadenName();
            String substring = ladenName.substring(6,ladenName.length());
            shoplistItemTitle.setText("Anfrage An: "+substring);
            shoplistItemTitle.setTextSize(20);
            beschreibungsText.setText(shopListItem.getProdukt());
            profilBild.setImageResource(shopListItem.getProfilbildReference());
        }

        @Override
        public void onClick(View view) {
            shopListItemListenerDos.OnShopListItemClick(getAdapterPosition());
        }
        public TextView getShoplistItemTitle() {
            return shoplistItemTitle;
        }

        public void setShoplistItemTitle(TextView shoplistItemTitle) {
            this.shoplistItemTitle = shoplistItemTitle;
        }
    }
}