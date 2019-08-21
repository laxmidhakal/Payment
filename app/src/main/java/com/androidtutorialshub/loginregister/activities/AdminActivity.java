package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtutorialshub.loginregister.R;

public class AdminActivity extends AppCompatActivity {
    TextView text;
    EditText etpass;
    EditText etuser;
    Button con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        TextView text=(TextView) findViewById(R.id.text);


        etpass=(EditText) findViewById(R.id.etpass);
        etuser=(EditText) findViewById(R.id.etuser);
        Button con=(Button) findViewById(R.id.con);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();

            }
        });
    }
    public void Check(){
        if ( etuser.getText().toString().equals("admin@gmail.com") && etpass.getText().toString().equals("admin")){

            Intent a=new Intent(AdminActivity.this,AdmiActivity.class);
            startActivity(a);

        }
        else {
            Toast.makeText(this,"Please enter the correct value",Toast.LENGTH_SHORT).show();

        }
    }
}
