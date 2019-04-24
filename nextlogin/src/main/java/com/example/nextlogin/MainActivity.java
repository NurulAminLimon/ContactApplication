package com.example.nextlogin;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Roll, Name, Address, Search;
    private Button save, show;
    Dataconnection dataconnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataconnection = new Dataconnection(this);

        Roll = findViewById(R.id.RollID);
        Name = findViewById(R.id.NameID);
        Address = findViewById(R.id.AddressID);
        save = findViewById(R.id.SaveId);
        show = findViewById(R.id.showID);
        Search = findViewById(R.id.SearchID);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer roll = Integer.parseInt(Roll.getText().toString());
                String name = Name.getText().toString();
                String address = Address.getText().toString();


                long row = dataconnection.Datainsert(roll, name, address);

                if (row != -1) {
                    Toast.makeText(getApplicationContext(), "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Data Not Insert ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rol = Search.getText().toString();

                Cursor cursor = dataconnection.displydate(rol);

                if(cursor.getCount() == 0)
                {
                    showData("Result Shet","No date Found");
                }

                StringBuffer buffer = new StringBuffer();

                while (cursor.moveToNext()) {
                    buffer.append("Roll    :" + cursor.getString(0)+"\n");
                    buffer.append("Address :" + cursor.getString(2)+"\n\n\n");


                }

                showData("Result Sheet", buffer.toString());

            }
        });
    }

     void showData(String result_sheet, String results) {

         AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder.setTitle(result_sheet);
         builder.setMessage(results);
         builder.show();

    }
}
