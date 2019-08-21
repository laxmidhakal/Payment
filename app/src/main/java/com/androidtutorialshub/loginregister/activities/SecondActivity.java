package com.androidtutorialshub.loginregister.activities;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtutorialshub.loginregister.MyHelper;
import com.androidtutorialshub.loginregister.R;

import static com.androidtutorialshub.loginregister.activities.App.CHANNEL_1_ID;

public class SecondActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;

    Button okk;
    Button exit;
    Button tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button tran=(Button) findViewById(R.id.tran);

        notificationManager=NotificationManagerCompat.from(this);



        Button exit=(Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dh=new Intent(SecondActivity.this,DashActivity.class);
                startActivity(dh);
            }
        });
        Button okk=(Button) findViewById(R.id.okk);
        okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(SecondActivity.this,R.style.CodingDemos);
                alertDialog.setTitle("CONFIRM");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Are you sure you want to make Payment?");
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Rs.1550 amount has been deducted from your account", Toast.LENGTH_SHORT).show();


                    }
                });
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent d=new Intent(SecondActivity.this,DashActivity.class);
                        startActivity(d);

                    }
                });
                alertDialog.show();





            }
        });
       /* MyHelper helper=new MyHelper(this);
        SQLiteDatabase database=helper.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT NAME,PRICE,DESCRIPTION,VAT,TOTAL,TXN FROM TRANSACT",new String[]{});
        if(cursor !=null){
            cursor.moveToFirst();

        }
        final StringBuilder builder=new StringBuilder();
        do{
            String name=cursor.getString(0);
            double price=cursor.getDouble(1);
            String description=cursor.getString(2);
            Double vat=cursor.getDouble(3);
            Integer total=cursor.getInt(4);
            Integer txn=cursor.getInt(5);



            builder.append(" TXN NUMBER -"+txn+"\n \n"+"SENDER -" + name + "\n \n"+
                    "RECIEVER -" +description+"\n \n"+"AMOUNT - Rs."+price+"\n \n"+"VAT AMOUNT - Rs."+vat+"\n \n"+"TOTAL AMOUNT - Rs."+total);


        }
        while (cursor.moveToNext());
        final Button details=(Button) findViewById(R.id.details);
        final TextView txn1=(TextView) findViewById(R.id.txn1);
        details.setText(builder.toString());*/
    }
    public void sendOnChannel1(View v){

        Intent axtivityIntent=new Intent(this,ReciveActivity.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,
                0,axtivityIntent,0);
        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("NOTIFICATION")
                .setContentText("Check your account ")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .build();
        notificationManager.notify(1,notification);

    }
}
