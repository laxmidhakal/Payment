package com.androidtutorialshub.loginregister;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidtutorialshub.loginregister.activities.DashActivity;
import com.androidtutorialshub.loginregister.activities.LoginActivity;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Logout.this,R.style.CodingDemos);
        alertDialog.setTitle("Logout");
        alertDialog.setCancelable(false);
        alertDialog.setMessage("Are you sure you want to logout?");
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent l=new Intent(Logout.this, LoginActivity.class);
                startActivity(l);


            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent d=new Intent(Logout.this, DashActivity.class);
                startActivity(d);

            }
        });
        alertDialog.show();


    }
}
