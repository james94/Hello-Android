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

    private TextView moneyText;
    private TextView savingText;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Creates a layout view we can actually see called activity_main
        setContentView(R.layout.activity_main);
        moneyText = findViewById(R.id.money_text);
        savingText = findViewById(R.id.saving_text);
    }

    // Listen on Show Tag button to be clicked using layout view, create toast message
    public void showTag(View view) {
        // Create toast message, small text that pop up on screen to let user know what happening
        // pass the context, the text, the duration for showing the message on the screen
        Toast.makeText(getApplicationContext(), R.string.app_name, Toast.LENGTH_LONG)
                .show();

        // Once you know things are working, get rid of log debugging
        //Log.d("MYTAG", "onClick: Show Money");
    }

    // Listen on Make It Rain button to be clicked, increment counter, set text color, pop up msg
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

        // Log.d("MIR", "makeItRain: Tapped " + moneyCounter);
    }
}
