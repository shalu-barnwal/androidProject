package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int defaultColor;
    ConstraintLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = findViewById(R.id.layout);
        defaultColor = ContextCompat.getColor(MainActivity.this, R.color.design_default_color_primary);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dot_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.send :
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                send();
                return true;
            case R.id.color :
                Toast.makeText(this, "Color", Toast.LENGTH_SHORT).show();
                changeColor();
                return true;
            case R.id.share :
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                share();
                return true;
            case R.id.exit :
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
                exit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    void share() {
        String txt = mMainMessage.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(MainActivity.this)
                .setType(mimeType)
                .setChooserTitle(txt)
                .setText(txt)
                .startChooser();
    }
    void setColor() {

        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColor = color;
                mLayout.setBackgroundColor(defaultColor);
            }
        });
        ambilWarnaDialog.show();

    }

    void whatsappSend() {
        String message = mMainMessage.getText().toString();
        String number = mPhoneNumber.getText().toString();

        if (number.matches("") || (number.length() != 10) ) {
            Toast.makeText(MainActivity.this, "Please enter valid number", Toast.LENGTH_SHORT).show();
            return;
        }
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ "+91"+ number + "&text=" + message));
            startActivity(intent);
    }



    //Closes the App: Closing current activity
    void exit() {
        finish();
    }

}