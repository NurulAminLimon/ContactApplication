package com.example.phonecall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Phone extends AppCompatActivity implements View.OnClickListener {
    private static final int MAKE_CALL_PERMISSION_REQUEST_CODE = 1;
    private Button One, two, three, four, five, six, seven, eight, nine, zero, star, hass, clear;
    private ImageButton call, dialpress;
    private EditText showedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);


        One = findViewById(R.id.OneID);
        two = findViewById(R.id.twoID);
        three = findViewById(R.id.threeID);
        four = findViewById(R.id.fourID);
        five = findViewById(R.id.fiveID);
        six = findViewById(R.id.sixID);
        seven = findViewById(R.id.sevenId);
        eight = findViewById(R.id.eightId);
        nine = findViewById(R.id.nineID);
        zero = findViewById(R.id.ZeroId);
        star = findViewById(R.id.starId);
        hass = findViewById(R.id.HassId);
        clear = findViewById(R.id.clearID);
        call = findViewById(R.id.callID);
        dialpress = findViewById(R.id.dialID);
        showedit = findViewById(R.id.ShowNumberID);

        One.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        star.setOnClickListener(this);
        hass.setOnClickListener(this);
        call.setOnClickListener(this);
        clear.setOnClickListener(this);
        dialpress.setOnClickListener(this);
        showedit.setOnClickListener(this);




















    /*    dial = (Button) findViewById(R.id.dial);
        final EditText numberToDial = findViewById(R.id.number);

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        }); */


    }


    @Override
    public void onClick(View v) {
        String s = showedit.getText().toString();


        if (v.getId() == R.id.OneID) {
            showedit.setText(s + "" + 1);

        } else if (v.getId() == R.id.twoID) {
            showedit.setText(s + "" + 2);
        } else if (v.getId() == R.id.threeID) {
            showedit.setText(s + "" + 3);
        } else if (v.getId() == R.id.fourID) {
            showedit.setText(s + "" + 4);
        } else if (v.getId() == R.id.fiveID) {
            showedit.setText(s + "" + 5);
        } else if (v.getId() == R.id.sixID) {
            showedit.setText(s + "" + 6);
        } else if (v.getId() == R.id.sevenId) {
            showedit.setText(s + "" + 7);
        } else if (v.getId() == R.id.eightId) {
            showedit.setText(s + "" + 8);
        } else if (v.getId() == R.id.nineID) {
            showedit.setText(s + "" + 9);
        } else if (v.getId() == R.id.ZeroId) {
            showedit.setText(s + "" + 0);
        } else if (v.getId() == R.id.starId) {
            showedit.setText(s + ""+"*");
        } else if (v.getId() == R.id.HassId) {
            showedit.setText(s + ""+"#");
        } else if (v.getId() == R.id.clearID) {

            try
            {
                StringBuffer buffer = new StringBuffer(s);


                showedit.setText(buffer.deleteCharAt(buffer.length() - 1).toString());
            }catch (Exception d)
            {
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
            }
        }else if(v.getId() == R.id.callID)
        {
            String phoneNumber = showedit.getText().toString();

            if(phoneNumber.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Plese Enter Input Number",Toast.LENGTH_LONG).show();
            }
            else
            {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+phoneNumber));
                startActivity(intent);
            }
        }

    }
}
