package com.example.logindemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class Thrid extends AppCompatActivity {

    private Button add, search, update, delete;
    EditText feedbackName, Feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);

        add = findViewById(R.id.AddInformationId);
        search = findViewById(R.id.SearchInformationID);
        update = findViewById(R.id.UpdateInformationID);


        registerForContextMenu(add);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(Thrid.this);
                progressDialog.setMessage("Please Wait..");

                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            progressDialog.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(Thrid.this, SecondActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.third_right, R.anim.thrid_left);
                        progressDialog.dismiss();
                    }
                }.start();


            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(Thrid.this);
                progressDialog.setMessage("Please Wait..");

                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            progressDialog.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(Thrid.this, SearchActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.third_right, R.anim.thrid_left);
                        progressDialog.dismiss();
                    }
                }.start();


            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(Thrid.this);
                progressDialog.setMessage("Please Wait..");

                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            progressDialog.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(Thrid.this, UpdateFragment.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.third_right, R.anim.thrid_left);
                        progressDialog.dismiss();
                    }
                }.start();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater men = getMenuInflater();
        men.inflate(R.menu.simple_view, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater men = getMenuInflater();
        men.inflate(R.menu.context_simple, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.ExitId) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exit Application");
            builder.setMessage("Do You want exit Application ?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if (item.getItemId() == R.id.FeedbackId) {

            LayoutInflater inflater = getLayoutInflater();

            View view = inflater.inflate(R.layout.feedback_view, (ViewGroup) findViewById(R.id.ViewID));

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(view);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            feedbackName = view.findViewById(R.id.feedbackName);
            Feedback = view.findViewById(R.id.feedbackComment);
            Button send = view.findViewById(R.id.ButtonSendID);
            Button clear = view.findViewById(R.id.ButtonClearId);

            feedbackName.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    String s = feedbackName.getText().toString();

                    if (s.equalsIgnoreCase("Enter Your Name  :")) {
                        feedbackName.setText("");
                    }
                    return false;
                }
            });

            Feedback.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    String d = Feedback.getText().toString();
                    if (d.equalsIgnoreCase("Enter Feeback   :")) {
                        Feedback.setText("");
                    }


                    return false;
                }
            });

            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nam = feedbackName.getText().toString();
                    String com = Feedback.getText().toString();
                    String emails[] = {"Tonmoyhasan283957@gmail.com", "Nurulaminlimon261893@gmail.com"};
                    Intent intent = new Intent();
                    intent.setType("text/email");
                    intent.putExtra(Intent.EXTRA_EMAIL, emails);
                    intent.putExtra(Intent.EXTRA_SUBJECT, nam);
                    intent.putExtra(Intent.EXTRA_TEXT, com);
                    startActivity(Intent.createChooser(intent, "Send Your Feedback !"));


                }
            });

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    feedbackName.setText("");
                    Feedback.setText("");
                }
            });


        } else if (item.getItemId() == android.R.id.home) {


            this.finish();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.third_leftd, R.anim.third_rightd);
    }
}
