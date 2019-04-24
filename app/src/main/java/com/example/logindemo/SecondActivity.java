package com.example.logindemo;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    private String[] conutries = {"Select Your Country", "Feni", "Chanpur", "Comilla", "Nohakhali", "Dhaka", "Jamalpur"};
    private AutoCompleteTextView Home_District;
    private EditText Roll, Name, Address, Mobile_No, Birth;
    RadioButton Male, Famale;
    CheckBox ssc, hsc, diploma, bsc;
    DataHelper dataHelper;
    Button save, reset;
    ImageButton Calan;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.setTitle("Add Information :");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);


        dataHelper = new DataHelper(this);

        Roll = findViewById(R.id.Roll_ID);
        Name = findViewById(R.id.NameID);
        Birth = findViewById(R.id.BirthID);
        Address = findViewById(R.id.AddressID);
        Home_District = findViewById(R.id.CountryID);
        Mobile_No = findViewById(R.id.MObileNOID);
        Male = findViewById(R.id.Male);
        Calan = findViewById(R.id.calanderId);
        Famale = findViewById(R.id.FamaleID);
        ssc = findViewById(R.id.sscID);
        hsc = findViewById(R.id.hscID);
        diploma = findViewById(R.id.DiplomaID);
        bsc = findViewById(R.id.bscID);
        save = findViewById(R.id.SaveID);
        t1 = findViewById(R.id.ShowID);
        reset = findViewById(R.id.ClearId);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.auto_view, R.id.TextViewID, conutries);
        Home_District.setAdapter(adapter);
        Home_District.setThreshold(1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SSC = "Null", HSC = "Null", DIPLOMA = "Null", BSC = "Null";
                Integer roll = Integer.parseInt(Roll.getText().toString());
                String name = Name.getText().toString();
                String address = Address.getText().toString();
                String District = Home_District.getText().toString();
                String mobile_number = Mobile_No.getText().toString();
                String gender;


                if (Male.isChecked()) {
                    gender = Male.getText().toString();
                } else if (Famale.isChecked()) {
                    gender = Famale.getText().toString();
                } else {
                    gender = "null";
                }


                if (ssc.isChecked()) {
                    SSC = ssc.getText().toString();
                }
                if (hsc.isChecked()) {
                    HSC = hsc.getText().toString();
                }
                if (diploma.isChecked()) {
                    DIPLOMA = diploma.getText().toString();
                }
                if (bsc.isChecked()) {
                    BSC = bsc.getText().toString();
                }


               // t1.setText("Roll :" + name + "\n" + " Address :" + address + "\n" + "Home District " + District + "\n" + "Mobile Number" + mobile_number + "\n" + "Gendar :" + gender + "\n" + "Ssc :" + SSC + "\n" + "Hsc :" + HSC + "\n" + "Dipolma :" + DIPLOMA + "\n" + "BSC :" + BSC);

                long row = dataHelper.insertData(roll, name, address, District, mobile_number, gender, SSC, HSC, DIPLOMA, BSC);

                if (row != -1) {
                    Toast.makeText(getApplicationContext(), "Data Insert successfully...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Data Not Insert ", Toast.LENGTH_SHORT).show();
                }


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Roll.setText("");
                Name.setText("");
                Address.setText("");
                Home_District.setText("");
                Mobile_No.setText("");
                Male.setChecked(false);
                Famale.setChecked(false);
                ssc.setChecked(false);
                hsc.setChecked(false);
                diploma.setChecked(false);
                bsc.setChecked(false);

            }
        });

        Calan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePicker datePicker = new DatePicker(getApplicationContext());

                int Currentyear = datePicker.getYear();
                int Currentmonth =datePicker.getMonth();
                int Currentday = datePicker.getDayOfMonth();


                DatePickerDialog datePickerDialog = new DatePickerDialog(SecondActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Birth.setText(dayOfMonth+"/"+(month+1)+"/"+year);



                    }
                }, Currentyear, Currentmonth, Currentday);

                datePickerDialog.show();


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
