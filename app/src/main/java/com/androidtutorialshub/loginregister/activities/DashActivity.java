package com.androidtutorialshub.loginregister.activities;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtutorialshub.loginregister.About;
import com.androidtutorialshub.loginregister.Logout;
import com.androidtutorialshub.loginregister.MyHelper;
import com.androidtutorialshub.loginregister.R;

import java.util.ArrayList;
import java.util.List;

import static com.androidtutorialshub.loginregister.activities.App.CHANNEL_1_ID;

public class DashActivity extends AppCompatActivity  {
    private NotificationManagerCompat notificationManager;
    TextView txndetails;
    TextView txn;

    Button re;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        notificationManager= NotificationManagerCompat.from(this);

       /* Button re=(Button) findViewById(R.id.re);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(DashActivity.this,ReciveActivity.class);
                startActivity(b);
            }
        });*/
        TextView txndetails=(TextView) findViewById(R.id.txndetails);
        TextView txn=(TextView) findViewById(R.id.txn);
       /* Spinner colouredSpinner=(Spinner)findViewById(R.id.coloredSpinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,
                R.array.Spinner_Items,
                R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        colouredSpinner.setAdapter(adapter);
        colouredSpinner.setOnItemSelectedListener(DashActivity.this);*/
        Button ok=(Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l=new Intent(DashActivity.this,ThirdActivity.class);
                startActivity(l);

            }
        });
        MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT NAME,DESCRIPTION,TXN FROM TRANSACT",new String[]{});
        if(cursor !=null){
            cursor.moveToFirst();

        }
        final StringBuilder builder=new StringBuilder();
        do{
            String name=cursor.getString(0);
            String description=cursor.getString(1);
            Integer total=cursor.getInt(2);
            //double price=cursor.getDouble(1);
            //Integer total=cursor.getInt(1);
           // String description=cursor.getString(2);


            builder.append("SENDER -" + name + "\n \n"+"RECIEVER -"+description+"\n \n"+"TOTAL -"+total);


        }
        while (cursor.moveToNext());
        final Button button=(Button) findViewById(R.id.detail);
        final TextView de=(TextView) findViewById(R.id.de);
        button.setText(builder.toString());

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent i1=new Intent(this, About.class);
                this.startActivity(i1);
                return true;
            case R.id.logout:
                Intent i2=new Intent(this, Logout.class);
                this.startActivity(i2);
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }

    }

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getItemAtPosition(position).equals("Select PAN/VAT number")){

        }
        else {
            //String text=parent.getItemAtPosition(position).toString();
            //Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
            MyHelper helper=new MyHelper(this);
            SQLiteDatabase database=helper.getReadableDatabase();
            Cursor cursor=database.rawQuery("SELECT NAME,TOTAL,DESCRIPTION FROM TRANSACT",new String[]{});
            if(cursor !=null){
                cursor.moveToFirst();

            }
            final StringBuilder builder=new StringBuilder();
            do{
                String name=cursor.getString(0);
                //double price=cursor.getDouble(1);
                Integer total=cursor.getInt(1);
                String description=cursor.getString(2);


                builder.append("SENDER -" + name + "\n \n"+"RECIEVER -" +description+"\n \n"+"TOTAL AMOUNT - Rs"+total+"\n");


            }
            while (cursor.moveToNext());
            final Button button=(Button) findViewById(R.id.detail);
            final TextView de=(TextView) findViewById(R.id.de);
            button.setText(builder.toString());

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/

}
