package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidtutorialshub.loginregister.MyHelper;
import com.androidtutorialshub.loginregister.R;

public class PendActivity extends AppCompatActivity {
    Button one;
    Button pa;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pend);
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(PendActivity.this,ThirdActivity.class);
                startActivity(a);
            }
        });
        final Button one=(Button) findViewById(R.id.one);
        Button pa=(Button) findViewById(R.id.pa);

        pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(PendActivity.this,ThirdActivity.class);
                startActivity(a);
            }
        });

        MyHelper helper=new MyHelper(this);
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
            Integer vat=cursor.getInt(3);
            Integer total=cursor.getInt(4);
            Integer txn=cursor.getInt(5);



            builder.append(" TXN NUMBER -"+txn+"\n \n"+"SENDER -" + name + "\n \n"+
                    "RECIEVER -" +description+"\n \n"+"TOTAL AMOUNT -"+total+"\n \n"+"AMOUNT -"+price+"\n \n"+"VAT AMOUNT -"+vat+"\n \n");


        }
        while (cursor.moveToNext());
        final Button details=(Button) findViewById(R.id.details);
        one.setText(builder.toString());
    }
}
