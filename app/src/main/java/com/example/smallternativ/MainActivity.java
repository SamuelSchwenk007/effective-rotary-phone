package com.example.smallternativ;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Login Activity
public class MainActivity extends AppCompatActivity{
    Button ohneAnmeldenFortfahren;
    Button buttonBestaetigen;
    Button buttonRegistrieren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ohneAnmeldenFortfahren = findViewById(R.id.buttonOhneAnmeldenFortfahren);
        ohneAnmeldenFortfahren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),StartseiteActivity.class);
                startActivity(intent);
            }
        });
        buttonBestaetigen = findViewById(R.id.buttonBestaetigen);
        buttonBestaetigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),StartseiteActivity.class);
                startActivity(intent);
            }
        });
        buttonRegistrieren = findViewById(R.id.buttonRegistrieren);
        buttonRegistrieren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),RegistrierenActivity.class);
                startActivity(intent);
            }
        });
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
    }

}
