package com.example.logindemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class UpdateFragment extends AppCompatActivity {

    private Toolbar t1;
    private ViewPager v1;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_fragment);
        t1 = findViewById(R.id.toolbarId);
        setSupportActionBar(t1);
        v1 = findViewById(R.id.ViewpagerID);
        tab = findViewById(R.id.tablayoutID);

        Viewpageradapter viewpageradapter = new Viewpageradapter(getSupportFragmentManager());
        v1.setAdapter(viewpageradapter);
        tab.setupWithViewPager(v1);
        tab.getTabAt(0).setIcon(R.drawable.up);
        tab.getTabAt(1).setIcon(R.drawable.bas);
    }
}
