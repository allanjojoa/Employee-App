package com.allan.android.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static String total_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnLogin(View view) {
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, "internship", "upsC734~");
    }

    public void setView(View view){
        TextView total_textview=(TextView) findViewById(R.id.total_textview);
        total_textview.setText(total_result);
    }

}
