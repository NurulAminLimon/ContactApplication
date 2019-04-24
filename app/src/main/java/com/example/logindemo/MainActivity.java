package com.example.logindemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Optional;

public class MainActivity extends AppCompatActivity  {



    private Button loginButton;
    private EditText User, password;
    private CheckBox RememberPassword;
    private LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.logIN);
        User = findViewById(R.id.UserID);
        password = findViewById(R.id.PasswordID);
        RememberPassword = findViewById(R.id.RememberPassword);
        l1 = findViewById(R.id.linearId);

        Animation am = AnimationUtils.loadAnimation(this,R.anim.fade);
        l1.startAnimation(am);








        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =  User.getText().toString();
                String pass = password.getText().toString();

                if(user.equalsIgnoreCase("limon") && pass.equalsIgnoreCase("369949"))
                {
                    final ProgressDialog pro = new ProgressDialog(MainActivity.this);
                    pro.setMessage("Please wait...");
                    pro.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    pro.show();
                    new Thread()
                    {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            pro.dismiss();
                            Intent intent = new Intent(MainActivity.this,Thrid.class);
                            startActivity(intent);
                        }
                    }.start();
                }


                else if (user.equalsIgnoreCase("") && pass.equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter User Name & Password",Toast.LENGTH_SHORT).show();
                }
                else if(user.equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter User Name . ",Toast.LENGTH_SHORT).show();
                }
                else if(pass.equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Password . ",Toast.LENGTH_SHORT).show();
                }

                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Wrong User & Password");
                    builder.setMessage("Please Try again");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
            }
        });







    }





}
