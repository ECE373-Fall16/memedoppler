package com.example.chad.memedoppler;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String zip = UserLocation.getZip();
    String town = UserLocation.getTown();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button locationButton = (Button) findViewById(R.id.location_button);
        locationButton.setText(town);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        TextView currentWeatherText = (TextView) findViewById(R.id.current_weather_text);
        currentWeatherText.setText("Last updated: " + dateFormat.format(cal.getTime()));

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
        mainMeme.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedMeme.class);
                startActivity(intent);
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedMeme.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedMeme.class);
                startActivity(intent);
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
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
        View forecastOneView = (View)findViewById(R.id.forecastOne);
        forecastOneView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastOne.class);
                startActivity(intent);
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastOne.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastOne.class);
                startActivity(intent);
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
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
        View forecastTwoView = (View)findViewById(R.id.forecastTwo);
        forecastTwoView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastTwo.class);
                startActivity(intent);
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastTwo.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastTwo.class);
                startActivity(intent);
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
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
        View forecastThreeView = (View)findViewById(R.id.forecastThree);
        forecastThreeView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastThree.class);
                startActivity(intent);
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastThree.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastThree.class);
                startActivity(intent);
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
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
        View forecastFourView = (View)findViewById(R.id.forecastFour);
        forecastFourView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastFour.class);
                startActivity(intent);
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastFour.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastFour.class);
                startActivity(intent);
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
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
        View forecastFiveView = (View)findViewById(R.id.forecastFive);
        forecastFiveView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastFive.class);
                startActivity(intent);
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastFive.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastFive.class);
                startActivity(intent);
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
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
        View forecastSixView = (View)findViewById(R.id.forecastSix);
        forecastSixView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onClick() {
                super.onClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastSix.class);
                startActivity(intent);
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastSix.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick() {
                super.onLongClick();
                Intent intent = new Intent(getApplicationContext(), ExpandedForecastSix.class);
                startActivity(intent);
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
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
