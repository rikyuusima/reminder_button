package com.example.user.reminder_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //Property
    ArrayAdapter list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayAdapterの初期化
        this.list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        //ArrayAdapterにファイル内容を追加
        if(readFile()){
            //ListViewの読み込み
            ListView listview = (ListView)findViewById(R.id.time_list);
            listview.setAdapter(list);
        }

        //ButtonとClickListener
        Button clear_button = (Button)findViewById(R.id.clear_button);
        View.OnClickListener click1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
            }
        };
        clear_button.setOnClickListener(click1);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        //Volume_UPDOWN_Button_Pushed
        if (e.getAction() == KeyEvent.ACTION_DOWN){
            Date date = new Date();
            //現在時刻(時)の取得
            SimpleDateFormat hour = new SimpleDateFormat("HH");
            String hour_str = hour.format(date);
            //現在時刻(分)の取得
            SimpleDateFormat minute = new SimpleDateFormat("mm");
            String minute_str = minute.format(date);

            //ListViewの読み込み
            ListView listview = (ListView)findViewById(R.id.time_list);

            //ListViewに追加
            list.add("Pushed " + hour_str + ":" + minute_str);
            listview.setAdapter(list);
        }
        return true;
    }

    private boolean readFile(){
        try {
            final String filepath = "SaveData.dat";
            FileInputStream fis = openFileInput(filepath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.list = (ArrayAdapter<String>)ois.readObject();
            ois.close();
            fis.close();

            return true;
        }
        catch (FileNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        catch (StreamCorruptedException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
    }

    private boolean writeFile(){
        return true;
    }
}
