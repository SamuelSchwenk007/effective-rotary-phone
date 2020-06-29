package com.example.smallternativ;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StartseiteActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    MyAdapter myAdapter;
    AnfragenAdapter anfragenAdapter;
    ArrayList<Fragment> fragmentList = new ArrayList<>();
    LinearLayout blacklineone;
    LinearLayout blacklinetwo;
    LinearLayout blacklinetree;
    LinearLayout blacklinefour;
    LinearLayout blacklinefive;
    List<ShopListItem> liste ;
    ProduktAdapter produktAdapter;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startseite_containerlayout);
        StartseitenFragment startseitenFragment = new StartseitenFragment();
        startseitenFragment.setStartseiteActivity(this);
        startseitenFragment.setSupportActionBar(getSupportActionBar());
        removeAllFragment();
        fragmentList.add(startseitenFragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.add(R.id.fragment_container,startseitenFragment);
        fragmentTransaction.commit();
        setAppTitle(getSupportActionBar(), this,"Smallternative");
        myAdapter = MyAdapter.getInstance(getApplicationContext(),startseitenFragment.getShopListItemListener());

        // test für Suchleiste
        onSearchRequested();
        BottomNavigationView bottom_navigation =findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(menuItem -> {
            Log.d("test",""+menuItem.getItemId());
            if(menuItem.getItemId()== R.id.page_1){
                blacklineone.setVisibility(View.VISIBLE);
                blacklinetwo.setVisibility(View.INVISIBLE);
                blacklinetree.setVisibility(View.INVISIBLE);
                blacklinefour.setVisibility(View.INVISIBLE);
                blacklinefive.setVisibility(View.INVISIBLE);
                StartseitenFragment startseitenFragment1 = new StartseitenFragment();
                startseitenFragment1.setStartseiteActivity(this);
                startseitenFragment1.setSupportActionBar(getSupportActionBar());
               createFragment(startseitenFragment1);
                StartseiteActivity.setAppTitle(getSupportActionBar(), getApplicationContext(),"Smallternative");
                return true;
            }
            else if(menuItem.getItemId()==R.id.page_2){
                blacklineone.setVisibility(View.INVISIBLE);
                blacklinetwo.setVisibility(View.VISIBLE);
                blacklinetree.setVisibility(View.INVISIBLE);
                blacklinefour.setVisibility(View.INVISIBLE);
                blacklinefive.setVisibility(View.INVISIBLE);
               FavorisierteLaedenFragment favorisierteLaedenFragment = new FavorisierteLaedenFragment();
                favorisierteLaedenFragment.setSupportActionBar(getSupportActionBar());
               createFragment(favorisierteLaedenFragment);
                return true;
            }
           else if(menuItem.getItemId()==R.id.page_3){
                blacklineone.setVisibility(View.INVISIBLE);
                blacklinetwo.setVisibility(View.INVISIBLE);
                blacklinetree.setVisibility(View.VISIBLE);
                blacklinefour.setVisibility(View.INVISIBLE);
                blacklinefive.setVisibility(View.INVISIBLE);
                AnfragenFragment anfragenFragment = new AnfragenFragment();
                anfragenFragment.setSupportActionBar(getSupportActionBar());
                anfragenFragment.setStartseiteActivity(this);
                anfragenAdapter = AnfragenAdapter.getInstance(getApplicationContext(),anfragenFragment.getShopListItemListenerDos());
                createFragment(anfragenFragment);
                anfragenAdapter.clearallListelements();
                return true;
            }
          else  if(menuItem.getItemId()==R.id.page_4){
                blacklineone.setVisibility(View.INVISIBLE);
                blacklinetwo.setVisibility(View.INVISIBLE);
                blacklinetree.setVisibility(View.INVISIBLE);
                blacklinefour.setVisibility(View.VISIBLE);
                blacklinefive.setVisibility(View.INVISIBLE);
                MeinKontoFragment meinkontoFragment = new MeinKontoFragment();
                meinkontoFragment.setSupportActionBar(getSupportActionBar());
               createFragment(meinkontoFragment);
                return true;
            }
          else  if(menuItem.getItemId()==R.id.page_5){
                blacklineone.setVisibility(View.INVISIBLE);
                blacklinetwo.setVisibility(View.INVISIBLE);
                blacklinetree.setVisibility(View.INVISIBLE);
                blacklinefour.setVisibility(View.INVISIBLE);
                blacklinefive.setVisibility(View.VISIBLE);
              View view = new View(this);
              showMenuPopup(view);
                return true;
            }
            else return true;
        });
         blacklineone = findViewById(R.id.blacklineone);
        blacklinetwo = findViewById(R.id.blacklinedos);
        blacklinetree = findViewById(R.id.blacklinetres);
        blacklinefour = findViewById(R.id.blacklinequadro);
        blacklinefive = findViewById(R.id.blacklinesinco);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        width = width -200;
        int scrollayoutsize = width/5;
        System.out.println("Hier der Wert"+scrollayoutsize);

        ViewGroup.LayoutParams layoutParams = blacklineone.getLayoutParams();
       layoutParams.width = scrollayoutsize;
        blacklineone.setLayoutParams(layoutParams);

        ViewGroup.LayoutParams layoutParamsdos = blacklinetwo.getLayoutParams();
        layoutParamsdos.width = scrollayoutsize;
        blacklinetwo.setLayoutParams(layoutParamsdos);

        ViewGroup.LayoutParams layoutParamstres = blacklinetree.getLayoutParams();
        layoutParamstres.width = scrollayoutsize;
        blacklinetree.setLayoutParams(layoutParamstres);

        ViewGroup.LayoutParams layoutParamsquadro = blacklinefour.getLayoutParams();
        layoutParamsquadro.width = scrollayoutsize;
        blacklinefour.setLayoutParams(layoutParamsquadro);

        ViewGroup.LayoutParams layoutParamssinco = blacklinefive.getLayoutParams();
        layoutParamssinco.width = scrollayoutsize;
        blacklinefive.setLayoutParams(layoutParamssinco);
        blacklinetwo.setVisibility(View.INVISIBLE);
        blacklinetree.setVisibility(View.INVISIBLE);
        blacklinefour.setVisibility(View.INVISIBLE);
        blacklinefive.setVisibility(View.INVISIBLE);
    }
    public  void removeListElements(MyAdapter myAdapter){
            myAdapter.clearallListelements();
    }
    public void createFragment(Fragment fragment){
        removeListElements(myAdapter);
        removeAllFragment();
        fragmentList.add(fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(fragment.getClass()==MeinKontoFragment.class || fragment.getClass()==StartseitenFragment.class ||fragment.getClass()==AnfragenFragment.class ||fragment.getClass()==FavorisierteLaedenFragment.class ){
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);

        }
        else {
            fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        }
        fragmentTransaction.add(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }
    public void removeAllFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(!fragmentList.isEmpty()) {
            for (int i = 0; i <= fragmentList.size(); i++) {
                fragmentTransaction.remove(fragmentList.get(i));
                fragmentList.remove(i);
            }
            fragmentTransaction.commit();
        }
    }
    public static void setAppTitle(ActionBar actionBar, Context applicationContext,String appTitle){
        // Get the ActionBar
        ActionBar ab = actionBar;

        // Create a TextView programmatically.
        TextView tv = new TextView(applicationContext);

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);

        // Set text to display in TextView
        tv.setText(appTitle); // ActionBar title text

        // Set the text color of TextView to black
        tv.setTextColor(Color.BLACK);

        // Set the monospace font for TextView text
        // This will change ActionBar title text font
        tv.setTypeface(ResourcesCompat.getFont(applicationContext,R.font.pacifico));
        // set tje textsize
        tv.setTextSize(24);
        // set the Title to center
        tv.setGravity(Gravity.CENTER);
        // Set the ActionBar display option
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        // Finally, set the newly created TextView as ActionBar custom view
        ab.setCustomView(tv);
    }
    public void showMenuPopup(View v){
        PopupMenu popupMenu = new PopupMenu(this,findViewById(R.id.page_5));
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menue_popup);
        popupMenu.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.zufaelligerladen:
                int position = getRandomNumberInRange(1,5);
                LadenProfilFragment ladenProfilFragment = new LadenProfilFragment();
                ladenProfilFragment.setStartseiteActivity(this);
                ladenProfilFragment.setSupportActionBar(getSupportActionBar());
                ladenProfilFragment.setMyAdapter(myAdapter);
                ladenProfilFragment.setLadenNameString(liste.get(position).title);
                ladenProfilFragment.setLadenBeschribungString(liste.get(position).beschreibung);
                ladenProfilFragment.setLadenPicReference(liste.get(position).profilbildReference);
                ladenProfilFragment.setKategorieItemString(liste.get(position).kategorie);
                ladenProfilFragment.setAdresseString(liste.get(position).adresse);
                ladenProfilFragment.setSortimentUnoReference(liste.get(position).sortimentReferenceUno);
                ladenProfilFragment.setSortimentDosReference(liste.get(position).sortimentReferenceDos);
                ladenProfilFragment.setSortimentTresReference(liste.get(position).sortimentThresReference);
                ladenProfilFragment.setSortimentQuadroReference(liste.get(position).sortimentQuadroReference);
                ladenProfilFragment.setSortimentUnoString(liste.get(position).getSortimentUnoString());
                ladenProfilFragment.setSortimentDosString(liste.get(position).getSortimentDosString());
                ladenProfilFragment.setSortimentTresString(liste.get(position).getSortimentThresString());
                ladenProfilFragment.setSortimentQuadroString(liste.get(position).getSortimentQuadroString());
                createFragment(ladenProfilFragment);
                return true;
            case R.id.stadtwaehlen:
                //Todo
                return true;
            case R.id.einstellungen:
                EinstellungenFragment einstellungenFragment = new EinstellungenFragment();
                einstellungenFragment.setSupportActionBar(getSupportActionBar());
                createFragment(einstellungenFragment);
                return true;
            case R.id.karte:
            default:
                return false;
        }
    }
    public void swipeLeft(View v){
        StartseitenFragment startseitenFragment = (StartseitenFragment) fragmentList.get(0);
        View view = startseitenFragment.getStartseitenFragmentView();
        HorizontalScrollView horizontalScrollView = view.findViewById(R.id.news_scroll_view);
        int subvalue = horizontalScrollView.getWidth();
        horizontalScrollView.setScrollX(horizontalScrollView.getScrollX()-subvalue);
    }
    public void swipeRight(View v){
        StartseitenFragment startseitenFragment = (StartseitenFragment) fragmentList.get(0);
        View view = startseitenFragment.getStartseitenFragmentView();
        HorizontalScrollView horizontalScrollView = view.findViewById(R.id.news_scroll_view);
        int addvalue = horizontalScrollView.getWidth();
        horizontalScrollView.setScrollX(horizontalScrollView.getScrollX()+addvalue);
    }
    public void swipeLeftFav(View v){
        FavorisierteLaedenFragment favorisierteLaedenFragment = (FavorisierteLaedenFragment) fragmentList.get(0);
        View view = favorisierteLaedenFragment.getFavFragmentView();
        HorizontalScrollView horizontalScrollView = view.findViewById(R.id.news_scroll_view_fav);
        int subvalue = horizontalScrollView.getWidth();
        horizontalScrollView.setScrollX(horizontalScrollView.getScrollX()-subvalue);
    }
    public void swipeRightFav(View v){
        FavorisierteLaedenFragment favorisierteLaedenFragment = (FavorisierteLaedenFragment) fragmentList.get(0);
        View view = favorisierteLaedenFragment.getFavFragmentView();
        HorizontalScrollView horizontalScrollView = view.findViewById(R.id.news_scroll_view_fav);
        int addvalue = horizontalScrollView.getWidth();
        horizontalScrollView.setScrollX(horizontalScrollView.getScrollX()+addvalue);
    }
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public void addOnclick(View v){
        AnfrageStellenDialog anfrageStellenDialog = new AnfrageStellenDialog();
        anfrageStellenDialog.setAnfragenAdapter(anfragenAdapter);
        FragmentManager fragmentManager = getSupportFragmentManager();
        anfrageStellenDialog.show(fragmentManager,"Anfrage senden");
    }

    public LinearLayout getBlacklineone() {
        return blacklineone;
    }

    public void setBlacklineone(LinearLayout blacklineone) {
        this.blacklineone = blacklineone;
    }

    public LinearLayout getBlacklinetwo() {
        return blacklinetwo;
    }

    public void setBlacklinetwo(LinearLayout blacklinetwo) {
        this.blacklinetwo = blacklinetwo;
    }

    public LinearLayout getBlacklinetree() {
        return blacklinetree;
    }

    public void setBlacklinetree(LinearLayout blacklinetree) {
        this.blacklinetree = blacklinetree;
    }

    public LinearLayout getBlacklinefour() {
        return blacklinefour;
    }

    public void setBlacklinefour(LinearLayout blacklinefour) {
        this.blacklinefour = blacklinefour;
    }

    public LinearLayout getBlacklinefive() {
        return blacklinefive;
    }

    public void setBlacklinefive(LinearLayout blacklinefive) {
        this.blacklinefive = blacklinefive;
    }

    public AnfragenAdapter getAnfragenAdapter() {
        return anfragenAdapter;
    }

    public void setAnfragenAdapter(AnfragenAdapter anfragenAdapter) {
        this.anfragenAdapter = anfragenAdapter;
    }

    public ProduktAdapter getProduktAdapter() {
        return produktAdapter;
    }

    public void setProduktAdapter(ProduktAdapter produktAdapter) {
        this.produktAdapter = produktAdapter;
    }
}
