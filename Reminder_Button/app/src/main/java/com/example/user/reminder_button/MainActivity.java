package com.example.user.reminder_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.KeyEvent;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        //Sound_UPDOWN_Button
        if (e.getAction() == KeyEvent.ACTION_DOWN){
            Date date = new Date();
            SimpleDateFormat hour = new SimpleDateFormat("HH");
            SimpleDateFormat minute = new SimpleDateFormat("mm");
            String hour_str = hour.format(date);
            String minute_str = minute.format(date);
            Toast.makeText(this, hour_str + ":" + minute_str, Toast.LENGTH_LONG).show();
            ListViewCompat list = (ListViewCompat)findViewById(R.id.);
        }
        return true;
    }
}
