package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView2);
    }
    public void toast(View v) {
        Toast t = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        t.show();
    }

    public void counter(View v) {
        count++;
        tv.setText(String.valueOf(count));
    }
}