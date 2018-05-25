package com.example.c5218535.myfirstapp;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;


import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button myButton = (Button) findViewById(R.id.button11);


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

//                ContentResolver cr = getContentResolver();
//                Cursor cursor = cr.query(Uri.parse("content://sms"),new String[]{"address","date","body","type"},null,null,null);
//                while(cursor.moveToNext()){
//                    String address = cursor.getString(0);
//                    long date = cursor.getLong(1);
//                    String body = cursor.getString(2);
//                    String type = cursor.getString(3);
//                   NotificationCompat.MessagingStyle.Message sms = new NotificationCompat.MessagingStyle.Message(body,date,address);
//
//                    Log.e("TAG=====",body);
//                }
                ContentValues values = new ContentValues();
                EditText msgbody = (EditText)findViewById(R.id.msgbody);
                EditText sdr = (EditText)findViewById(R.id.sdr);
                String txt = msgbody.getText().toString();
                String sdrStr=sdr.getText().toString();
                if(txt.length()>5&&sdrStr.length()<10) {
                    values.put("address", sdrStr);
                    values.put("body", txt);
                    getContentResolver().insert(Uri.parse("content://sms/inbox"), values);
                }

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
