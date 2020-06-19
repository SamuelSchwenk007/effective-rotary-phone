package com.example.smallternativ;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class StartseiteActivity extends AppCompatActivity {
    MyAdapter myAdapter;
    ArrayList<Fragment> fragmentList = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startseite_containerlayout);
        StartseitenFragment startseitenFragment = new StartseitenFragment();
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
            if(menuItem.getItemId()==2131361993){
                StartseitenFragment startseitenFragment1 = new StartseitenFragment();
               createFragment(startseitenFragment1);
                StartseiteActivity.setAppTitle(getSupportActionBar(), getApplicationContext(),"Smallternative");
                return true;
            }
            else if(menuItem.getItemId()==2131361994){
               FavorisierteLaedenFragment favorisierteLaedenFragment = new FavorisierteLaedenFragment();
                favorisierteLaedenFragment.setSupportActionBar(getSupportActionBar());
               createFragment(favorisierteLaedenFragment);
                return true;
            }
           else if(menuItem.getItemId()==2131361995){
                AnfragenFragment anfragenFragment = new AnfragenFragment();
                anfragenFragment.setSupportActionBar(getSupportActionBar());
                createFragment(anfragenFragment);
                return true;
            }
          else  if(menuItem.getItemId()==2131361996){

                MeinkontoFragment meinkontoFragment = new MeinkontoFragment();
                meinkontoFragment.setSupportActionBar(getSupportActionBar());
               createFragment(meinkontoFragment);
                return true;
            }
          else  if(menuItem.getItemId()==2131361997){

                MenueFragment menueFragment = new MenueFragment();
                createFragment(menueFragment);
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
            for (int i = 0; i < fragmentList.size(); i++) {
                fragmentTransaction.remove(fragmentList.get(i));
            }
        }
        fragmentTransaction.commit();
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
}
