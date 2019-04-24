package com.example.logindemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


public class Update extends Fragment {

    private String[] conutries = {"Select Your Country", "Feni", "Chanpur", "Comilla", "Nohakhali", "Dhaka", "Jamalpur"};
    private AutoCompleteTextView Home_District;
    private EditText Roll, Name, Address, Mobile_No, Birth;
    RadioButton Male, Famale;
    CheckBox ssc, hsc, diploma, bsc;
    DataHelper dataHelper;
    Button Update, reset;
    ImageButton Calan;
    TextView t1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View V = inflater.inflate(R.layout.fragment_update, container, false);


        dataHelper = new DataHelper(getContext());

        Roll = V.findViewById(R.id.Roll_ID);
        Name = V.findViewById(R.id.NameID);
        Birth = V.findViewById(R.id.BirthID);
        Address = V.findViewById(R.id.AddressID);
        Home_District = V.findViewById(R.id.CountryID);
        Mobile_No = V.findViewById(R.id.MObileNOID);
        Male = V.findViewById(R.id.Male);
        Calan = V.findViewById(R.id.calanderId);
        Famale = V.findViewById(R.id.FamaleID);
        ssc = V.findViewById(R.id.sscID);
        hsc = V.findViewById(R.id.hscID);
        diploma = V.findViewById(R.id.DiplomaID);
        bsc = V.findViewById(R.id.bscID);
        Update = V.findViewById(R.id.UpdateID);
        t1 = V.findViewById(R.id.ShowID);
        reset = V.findViewById(R.id.ClearId);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.auto_view, R.id.TextViewID, conutries);
        Home_District.setAdapter(adapter);
        Home_District.setThreshold(1);


        Update.setOnClickListener(new View.OnClickListener() {
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


                 boolean isUpdate = dataHelper.UpdateDate(roll,name,address,District,mobile_number,gender,SSC,HSC,DIPLOMA,BSC);


                if(isUpdate == true)
                {
                    Toast.makeText(getContext(),"Data Update Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(),"Data Not Update.. ",Toast.LENGTH_SHORT).show();
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





















        return V;
    }


}
