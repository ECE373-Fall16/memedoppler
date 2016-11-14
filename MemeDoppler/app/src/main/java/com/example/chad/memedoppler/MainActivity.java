package com.example.chad.memedoppler;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    // public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toast.makeText(MainActivity.this, "Welcome back!", Toast.LENGTH_SHORT).show();
        Calendar c = Calendar.getInstance();
        int date = c.get(Calendar.DATE);
        // final TextView currentWeatherText = (TextView)findViewById(R.id.current_weather_text);
        // currentWeatherText.setText(date);
    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /* Called when the user clicks the Send button */
    public void largeImage(View view) {
        Intent intent = new Intent(this, ExpandedMeme.class);
        startActivity(intent);
    }
    public void ExpandedForecastOne(View view) {
        Intent intent = new Intent(this, ExpandedForecastOne.class);
        startActivity(intent);
    }
    public void ExpandedForecastTwo(View view) {
        Intent intent = new Intent(this, ExpandedForecastTwo.class);
        startActivity(intent);
    }
    public void ExpandedForecastThree(View view) {
        Intent intent = new Intent(this, ExpandedForecastThree.class);
        startActivity(intent);
    }
    public void ExpandedForecastFour(View view) {
        Intent intent = new Intent(this, ExpandedForecastFour.class);
        startActivity(intent);
    }
    public void ExpandedForecastFive(View view) {
        Intent intent = new Intent(this, ExpandedForecastFive.class);
        startActivity(intent);
    }
    public void ExpandedForecastSix(View view) {
        Intent intent = new Intent(this, ExpandedForecastSix.class);
        startActivity(intent);
    }
}
