package com.example.smallternativ;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class StartseiteActivity extends AppCompatActivity implements MyAdapter.ShopListItemListener {
    private MyAdapter.ShopListItemListener shopListItemListener;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startseitenlayout);
        recyclerView = findViewById(R.id.recyclerView);
        setTodoListenerToAdapter(this);
        myAdapter = MyAdapter.getInstance(this,shopListItemListener);
        // Get the ActionBar
        ActionBar ab = getSupportActionBar();

        // Create a TextView programmatically.
        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);

        // Set text to display in TextView
        tv.setText(ab.getTitle()); // ActionBar title text

        // Set the text color of TextView to black
        tv.setTextColor(Color.BLACK);

        // Set the monospace font for TextView text
        // This will change ActionBar title text font
        tv.setTypeface(ResourcesCompat.getFont(this,R.font.pacifico));
        // set tje textsize
        tv.setTextSize(24);
        // set the Title to center
        tv.setGravity(Gravity.CENTER);
        // Set the ActionBar display option
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        // Finally, set the newly created TextView as ActionBar custom view
        ab.setCustomView(tv);
        loadShopsToList(this, myAdapter);
        BottomNavigationView bottom_navigation =findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(menuItem -> {
            Log.d("test",""+menuItem.getItemId());
            if(menuItem.getItemId()==2131361991){
                Intent intent = new Intent(this.getApplicationContext(),StartseiteActivity.class);
                startActivity(intent);
                return true;
            }
            else if(menuItem.getItemId()==2131361992){
                Intent intent = new Intent(this.getApplicationContext(),FavorisierteLaedenActivity.class);
                startActivity(intent);
                return true;
            }
           else if(menuItem.getItemId()==2131361993){
                Intent intent = new Intent(this.getApplicationContext(),AnfragenActivity.class);
                startActivity(intent);
                return true;
            }
          else  if(menuItem.getItemId()==2131361994){
                Intent intent = new Intent(this.getApplicationContext(),MeinkontoActivity.class);
                startActivity(intent);
                return true;
            }
          else  if(menuItem.getItemId()==2131361995){
                Intent intent = new Intent(this.getApplicationContext(),MenueFragment.class);
                startActivity(intent);
                return true;
            }
            else return true;
        });

    }
    public void setTodoListenerToAdapter(MyAdapter.ShopListItemListener shopListItemListener){
        MyAdapter adapter = MyAdapter.getInstance(this, shopListItemListener);
        adapter.setShopListItemlistener(this);
    }

    @Override
    public void OnShopListItemClick(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LadenProfilFragment ladenProfilFragment = new LadenProfilFragment();
        fragmentTransaction.add(R.id.container_startseite,ladenProfilFragment);
        fragmentTransaction.commit();
    }
    public void loadShopsToList(Context context, MyAdapter myAdapter){
        ShopListItem shopListItemOne = new ShopListItem("Öz Sülo", "Netter Türke um die Ecke", R.drawable.oz_sulo_profilbild,R.drawable.oz_sulo_banner);

        ShopListItem shopListItemTwo = new ShopListItem("Asiatica","Netter Asiate um die Ecke",R.drawable.asiatica_profilbild,R.drawable.asiatica_banner);

        ShopListItem shopListItemThree = new ShopListItem("Cyroline","Nette Mode um die Ecke",R.drawable.cyroline_profilbild,R.drawable.cyroline_banner);

        ShopListItem shopListItemFour = new ShopListItem("Nadel und Faden","Netter Fäden um die Ecke",R.drawable.nadel_und_faden_profilbild,R.drawable.nadel_und_faden_banner);


        myAdapter.insertShopListItem(shopListItemOne);
        myAdapter.insertShopListItem(shopListItemTwo);
        myAdapter.insertShopListItem(shopListItemThree);
        myAdapter.insertShopListItem(shopListItemFour);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
    }
}
