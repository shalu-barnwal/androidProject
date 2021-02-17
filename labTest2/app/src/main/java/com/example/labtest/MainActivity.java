package com.example.labtest;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView TxtVehiclesCount,TxtAmountCollected;

    int vehiclesCount = 0;
    int amountCollected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Btn2Wheeler = findViewById(R.id.Btn2Wheeler);
        Button Btn4Wheeler = findViewById(R.id.Btn4Wheeler);
        Button BtnRFID = findViewById(R.id.BtnRFID);
        Button BtnTruckBus = findViewById(R.id.BtnTruckBus);
        Button BtnVipPass = findViewById(R.id.BtnVipPass);

       TxtVehiclesCount = findViewById(R.id.txtVehiclesCount);
       TxtAmountCollected = findViewById(R.id.txtAmountCollected);

        Btn2Wheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehiclesCount++;
                amountCollected += 100;
                display();
            }
        });

        Btn4Wheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehiclesCount++;
                amountCollected += 200;
                display();
            }
        });

        BtnTruckBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehiclesCount++;
                amountCollected += 400;
                display();
            }
        });

        BtnRFID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehiclesCount++;
                amountCollected += 50;
                display();
            }
        });

        BtnVipPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehiclesCount++;
                amountCollected += 0;
                display();
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void display() {
        TxtVehiclesCount.setText(Integer.toString(vehiclesCount));
        TxtAmountCollected.setText(Integer.toString(amountCollected));
    }


}


