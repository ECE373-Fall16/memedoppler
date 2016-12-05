package com.example.chad.memedoppler;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

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

        Button dank = (Button) findViewById(R.id.Dank);
        dank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Thanks for your feedback!", Toast.LENGTH_LONG).show();
            }
        });

        View RelativeLayout = (View)findViewById(R.id.content_main);
        RelativeLayout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                // your on click here
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                // your on onDoubleClick here
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                // your on onLongClick here
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "SwipeUp", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                Toast.makeText(getApplicationContext(), "SwipeDown", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                Intent intent = new Intent(getApplicationContext(), NotDank.class);
                startActivity(intent);
                Button notDank = (Button) findViewById(R.id.NotDank);
                notDank.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Thanks for your feedback!", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Toast.makeText(getApplicationContext(), "Thanks for your feedback!", Toast.LENGTH_LONG).show();

            }
        });
        View mainMeme = (View)findViewById(R.id.main_Meme);
        RelativeLayout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedMeme.class);
                startActivity(intent);
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                // your on onDoubleClick here
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                // your on onLongClick here
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "SwipeUp", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                Toast.makeText(getApplicationContext(), "SwipeDown", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                Intent intent = new Intent(getApplicationContext(), NotDank.class);
                startActivity(intent);
                Button notDank = (Button) findViewById(R.id.NotDank);
                notDank.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Thanks for your feedback!", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Toast.makeText(getApplicationContext(), "Thanks for your feedback!", Toast.LENGTH_LONG).show();

            }
        });

    }
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /* Called when the user clicks the Send button */

    public void LocationButton(View view) {
        Intent intent = new Intent(this, UserLocation.class);
        startActivity(intent);//*/
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
    public void NotDank(View view) {
        Intent intent = new Intent(this, NotDank.class);
        startActivity(intent);
        Button notDank = (Button) findViewById(R.id.NotDank);
        notDank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Thanks for your feedback!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
