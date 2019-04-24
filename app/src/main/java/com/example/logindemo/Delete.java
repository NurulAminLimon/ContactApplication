package com.example.logindemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Delete extends Fragment {

    private EditText t1;
    private Button btn;
    DataHelper dataHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_delete, container, false);

        dataHelper = new DataHelper(getContext());

        t1 = v.findViewById(R.id.DeleteId);
        btn = v.findViewById(R.id.deleteButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer ro = Integer.parseInt(t1.getText().toString());

                int ard = dataHelper.DeleteRow(ro);

                if(ard>0)
                {
                    Toast.makeText(getContext(),"Row delete Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(),"Row Not Delete..",Toast.LENGTH_SHORT).show();
                }




            }
        });


        return v;
    }


}
