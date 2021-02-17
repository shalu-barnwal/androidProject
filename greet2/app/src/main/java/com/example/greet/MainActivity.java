package com.example.greet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView greet;
    TextView name;
    TextView reg;

    Button clk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greet = (TextView)findViewById(R.id.tv);
        name = (TextView)findViewById(R.id.tv1);
        reg = (TextView)findViewById(R.id.tv2);
        clk = (Button)findViewById(R.id.btn);

        clk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greet.setVisibility(View.VISIBLE);
                name.setVisibility(View.VISIBLE);
                reg.setVisibility(View.VISIBLE);
                //clk.setVisibility(View.INVISIBLE);
            }
        });
    }
}