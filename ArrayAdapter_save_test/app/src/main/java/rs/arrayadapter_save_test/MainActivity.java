package rs.arrayadapter_save_test;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ClickListener
        Button btn1 = (Button)findViewById(R.id.push_button);
        DialogInterface.OnClickListener listner1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText et1 = (EditText)findViewById(R.id.pushed_textbox);
                ListView lv1 = (ListView)findViewById(R.id.pushed_list);

                ArrayAdapter array = new ArrayAdapter();
                array.add();
                et1.getText()
            }
        };
    }
}
