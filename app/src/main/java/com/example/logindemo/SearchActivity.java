package com.example.logindemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {


    private EditText Serach;
    private Button Showdata, Dial;
    private TextView mobile, RollText, AddressText, DistrictText, GendarText;
    DataHelper dataHelper;
    LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        dataHelper = new DataHelper(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Serach = findViewById(R.id.SearchID);
        Showdata = findViewById(R.id.ShowButtonID);
        Dial = findViewById(R.id.dialId);
        mobile = findViewById(R.id.SearchshowID);
        RollText = findViewById(R.id.Roll);
        AddressText = findViewById(R.id.Address);
        DistrictText = findViewById(R.id.District);
        GendarText = findViewById(R.id.Gendar);


        Showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(Serach.getText().toString());

                Cursor cursor = dataHelper.showdata(value);

                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();

                }


                while (cursor.moveToNext()) {


                    RollText.setText("Name              : " + cursor.getString(1));
                    AddressText.setText("Adress         : " + cursor.getString(2));
                    DistrictText.setText("District      : " + cursor.getString(3));
                    mobile.setText( "Mobile_Number      :"+cursor.getString(4));
                    GendarText.setText("Gendar          : " + cursor.getString(5));
//


                }


            }
        });

        Dial.setOnClickListener(new View.OnClickListener() {
            String phoneNumber = mobile.getText().toString();

            @Override
            public void onClick(View v) {



            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
