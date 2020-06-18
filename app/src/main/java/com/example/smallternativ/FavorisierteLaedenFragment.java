package com.example.smallternativ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class FavorisierteLaedenFragment extends Fragment {
    private View view;
    private androidx.appcompat.app.ActionBar supportActionBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.favorisierte_laeden_layout, container, false);
        StartseiteActivity.setAppTitle(supportActionBar, getContext(),"Favorisierte Läden");
        return view;
    }
    public ActionBar getSupportActionBar() {
        return supportActionBar;
    }

    public void setSupportActionBar(ActionBar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

}
