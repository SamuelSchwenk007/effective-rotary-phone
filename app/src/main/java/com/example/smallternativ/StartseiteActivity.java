package com.example.smallternativ;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

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


public class StartseiteActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    MyAdapter myAdapter;
    ArrayList<Fragment> fragmentList = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startseite_containerlayout);
        StartseitenFragment startseitenFragment = new StartseitenFragment();
        startseitenFragment.setStartseiteActivity(this);
        removeAllFragment();
        fragmentList.add(startseitenFragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,startseitenFragment);
        fragmentTransaction.commit();
        setAppTitle(getSupportActionBar(), this,"Smalternative");
        myAdapter = MyAdapter.getInstance(getApplicationContext(),startseitenFragment.getShopListItemListener());

        BottomNavigationView bottom_navigation =findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(menuItem -> {
            Log.d("test",""+menuItem.getItemId());
            if(menuItem.getItemId()== R.id.page_1){
                StartseitenFragment startseitenFragment1 = new StartseitenFragment();
                startseitenFragment1.setStartseiteActivity(this);
               createFragment(startseitenFragment1);
                StartseiteActivity.setAppTitle(getSupportActionBar(), getApplicationContext(),"Smallternative");
                return true;
            }
            else if(menuItem.getItemId()==R.id.page_2){
               FavorisierteLaedenFragment favorisierteLaedenFragment = new FavorisierteLaedenFragment();
                favorisierteLaedenFragment.setSupportActionBar(getSupportActionBar());
               createFragment(favorisierteLaedenFragment);
                return true;
            }
           else if(menuItem.getItemId()==R.id.page_3){
                AnfragenFragment anfragenFragment = new AnfragenFragment();
                anfragenFragment.setSupportActionBar(getSupportActionBar());
                createFragment(anfragenFragment);
                return true;
            }
          else  if(menuItem.getItemId()==R.id.page_4){
                MeinKontoFragment meinkontoFragment = new MeinKontoFragment();
                meinkontoFragment.setSupportActionBar(getSupportActionBar());
               createFragment(meinkontoFragment);
                return true;
            }
          else  if(menuItem.getItemId()==R.id.page_5){
              View view = new View(getApplicationContext());
              showMenuPopup(view);
                return true;
            }
            else return true;
        });

    }
    public  void removeListElements(Context context, MyAdapter myAdapter){
            myAdapter.clearallListelements();
    }
    public void createFragment(Fragment fragment){
        removeListElements(getApplicationContext(),myAdapter);
        removeAllFragment();
        fragmentList.add(fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
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
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menue_popup);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.zufaelligerladen:
                //Todo
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
        horizontalScrollView.setScrollX(horizontalScrollView.getScrollX()-view.getWidth());
    }
    public void swipeRight(View v){
        StartseitenFragment startseitenFragment = (StartseitenFragment) fragmentList.get(0);
        View view = startseitenFragment.getStartseitenFragmentView();
        HorizontalScrollView horizontalScrollView = view.findViewById(R.id.news_scroll_view);
        horizontalScrollView.setScrollX(horizontalScrollView.getScrollX()+view.getWidth());
    }
    public void swipeLeftFav(View v){
        FavorisierteLaedenFragment favorisierteLaedenFragment = (FavorisierteLaedenFragment) fragmentList.get(0);
        View view = favorisierteLaedenFragment.getFavFragmentView();
        HorizontalScrollView horizontalScrollView = view.findViewById(R.id.news_scroll_view_fav);
        horizontalScrollView.setScrollX(horizontalScrollView.getScrollX()-view.getWidth());
    }
    public void swipeRightFav(View v){
        FavorisierteLaedenFragment favorisierteLaedenFragment = (FavorisierteLaedenFragment) fragmentList.get(0);
        View view = favorisierteLaedenFragment.getFavFragmentView();
        HorizontalScrollView horizontalScrollView = view.findViewById(R.id.news_scroll_view_fav);
        horizontalScrollView.setScrollX(horizontalScrollView.getScrollX()+view.getWidth());
    }
}
