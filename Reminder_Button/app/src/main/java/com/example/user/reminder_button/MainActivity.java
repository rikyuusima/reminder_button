package com.example.user.reminder_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

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
            Toast.makeText(this, "押した", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
