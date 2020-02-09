package com.guzmanx.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
//    private Button showMoney;
//    private Button showTag;


    private TextView moneyText;
    private TextView savingText;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moneyText = findViewById(R.id.money_text);
        savingText = findViewById(R.id.saving_text);
//        showMoney = findViewById(R.id.button_make_rain);
//        showTag = findViewById(R.id.button_show_tag);

//        showMoney.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("MYTAG", "onClick: Show Money");
//            }
//        });
    }

    public void showTag(View view) {
        // Create toast message, small text that pop up on screen to let user know what happening
        // pass the context, the text, the duration for showing the message on the screen
        Toast.makeText(getApplicationContext(), R.string.app_name, Toast.LENGTH_LONG)
                .show();

        // Debugging
        //Log.d("MYTAG", "onClick: Show Money");
    }

    public void makeItRain(View v) {
        // Convert android number to currency specific to android's region in the world
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(); // US ex: $1,000.00

        // Give a visual cue to user they are saving a lot of money
        // checks if moneyCounter gets big 10,000, then change text color
        moneyCounter += 1000;
        switch(moneyCounter) {
            case 10000:
                // Approach 1: Set text color with predefined colors specified in color state list
                moneyText.setTextColor(Color.WHITE);
                break;
            case 30000:
                moneyText.setTextColor(Color.GREEN);
                break;
            case 50000:
                // Approach 2: Set text color by getting our own hex color resource in colors.xml
                moneyText.setTextColor(getResources().getColor(R.color.myYellow));
                break;
        }
        // check if moneyCounter gets big, msg "Woah, you're getting richer"
        if(moneyCounter >= 50000) {
            savingText.setText("Woah, keeping saving!");
        }
        moneyText.setText(String.valueOf(numberFormat.format(moneyCounter)));

        // Once you know things are working, get rid of log debugging
        // Log.d("MIR", "makeItRain: Tapped " + moneyCounter);
    }
}
