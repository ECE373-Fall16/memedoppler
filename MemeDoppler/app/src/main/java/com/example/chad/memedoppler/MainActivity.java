package com.example.chad.memedoppler;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.*;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String zip = UserLocation.getZip();
    String town = UserLocation.getTown();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*WSClient wsc = new WSClient();

        // get forecast by Zip Code
        wsc.getWeatherForecast(zip); // Amherst */
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
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                //imageDownload("e9",R.id.main_Meme);
                //imageDownload("c9",R.id.forecastOne);
                //imageDownload("h9",R.id.forecastTwo);
                //imageDownload("t9",R.id.forecastThree);
                //imageDownload("r9",R.id.forecastFour);
                //imageDownload("r9",R.id.forecastFive);
                //imageDownload("e9",R.id.forecastSix);
                imageDownload("e_",R.id.main_Meme);
                imageDownload("c_",R.id.forecastOne);
                imageDownload("h_",R.id.forecastTwo);
                imageDownload("t_",R.id.forecastThree);
                imageDownload("r_",R.id.forecastFour);
                imageDownload("r_",R.id.forecastFive);
                imageDownload("e_",R.id.forecastSix);
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                imageDownload("e9",R.id.main_Meme);
                imageDownload("c9",R.id.forecastOne);
                imageDownload("h9",R.id.forecastTwo);
                imageDownload("t9",R.id.forecastThree);
                imageDownload("r9",R.id.forecastFour);
                imageDownload("r9",R.id.forecastFive);
                imageDownload("e9",R.id.forecastSix);
                //imageDownload("e_",R.id.main_Meme);
                //imageDownload("c_",R.id.forecastOne);
                //imageDownload("h_",R.id.forecastTwo);
                //imageDownload("t_",R.id.forecastThree);
                //imageDownload("r_",R.id.forecastFour);
                //imageDownload("r_",R.id.forecastFive);
                //imageDownload("e_",R.id.forecastSix);
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
                imageDownload("e9",R.id.main_Meme);
                imageDownload("c9",R.id.forecastOne);
                imageDownload("h9",R.id.forecastTwo);
                imageDownload("t9",R.id.forecastThree);
                imageDownload("r9",R.id.forecastFour);
                imageDownload("r9",R.id.forecastFive);
                imageDownload("e9",R.id.forecastSix);
                //imageDownload("e_",R.id.main_Meme);
                //imageDownload("c_",R.id.forecastOne);
                //imageDownload("h_",R.id.forecastTwo);
                //imageDownload("t_",R.id.forecastThree);
                //imageDownload("r_",R.id.forecastFour);
                //imageDownload("r_",R.id.forecastFive);
                //imageDownload("e_",R.id.forecastSix);
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                //imageDownload("e9",R.id.main_Meme);
                //imageDownload("c9",R.id.forecastOne);
                //imageDownload("h9",R.id.forecastTwo);
                //imageDownload("t9",R.id.forecastThree);
                //imageDownload("r9",R.id.forecastFour);
                //imageDownload("r9",R.id.forecastFive);
                //imageDownload("e9",R.id.forecastSix);
                imageDownload("e_",R.id.main_Meme);
                imageDownload("c_",R.id.forecastOne);
                imageDownload("h_",R.id.forecastTwo);
                imageDownload("t_",R.id.forecastThree);
                imageDownload("r_",R.id.forecastFour);
                imageDownload("r_",R.id.forecastFive);
                imageDownload("e_",R.id.forecastSix);
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
                imageDownload("e9",R.id.main_Meme);
                imageDownload("c9",R.id.forecastOne);
                imageDownload("h9",R.id.forecastTwo);
                imageDownload("t9",R.id.forecastThree);
                imageDownload("r9",R.id.forecastFour);
                imageDownload("r9",R.id.forecastFive);
                imageDownload("e9",R.id.forecastSix);
                //imageDownload("e_",R.id.main_Meme);
                //imageDownload("c_",R.id.forecastOne);
                //imageDownload("h_",R.id.forecastTwo);
                //imageDownload("t_",R.id.forecastThree);
                //imageDownload("r_",R.id.forecastFour);
                //imageDownload("r_",R.id.forecastFive);
                //imageDownload("e_",R.id.forecastSix);
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                //imageDownload("e9",R.id.main_Meme);
                //imageDownload("c9",R.id.forecastOne);
                //imageDownload("h9",R.id.forecastTwo);
                //imageDownload("t9",R.id.forecastThree);
                //imageDownload("r9",R.id.forecastFour);
                //imageDownload("r9",R.id.forecastFive);
                //imageDownload("e9",R.id.forecastSix);
                imageDownload("e_",R.id.main_Meme);
                imageDownload("c_",R.id.forecastOne);
                imageDownload("h_",R.id.forecastTwo);
                imageDownload("t_",R.id.forecastThree);
                imageDownload("r_",R.id.forecastFour);
                imageDownload("r_",R.id.forecastFive);
                imageDownload("e_",R.id.forecastSix);
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
                imageDownload("e9",R.id.main_Meme);
                imageDownload("c9",R.id.forecastOne);
                imageDownload("h9",R.id.forecastTwo);
                imageDownload("t9",R.id.forecastThree);
                imageDownload("r9",R.id.forecastFour);
                imageDownload("r9",R.id.forecastFive);
                imageDownload("e9",R.id.forecastSix);
                //imageDownload("e_",R.id.main_Meme);
                //imageDownload("c_",R.id.forecastOne);
                //imageDownload("h_",R.id.forecastTwo);
                //imageDownload("t_",R.id.forecastThree);
                //imageDownload("r_",R.id.forecastFour);
                //imageDownload("r_",R.id.forecastFive);
                //imageDownload("e_",R.id.forecastSix);
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                //imageDownload("e9",R.id.main_Meme);
                //imageDownload("c9",R.id.forecastOne);
                //imageDownload("h9",R.id.forecastTwo);
                //imageDownload("t9",R.id.forecastThree);
                //imageDownload("r9",R.id.forecastFour);
                //imageDownload("r9",R.id.forecastFive);
                //imageDownload("e9",R.id.forecastSix);
                imageDownload("e_",R.id.main_Meme);
                imageDownload("c_",R.id.forecastOne);
                imageDownload("h_",R.id.forecastTwo);
                imageDownload("t_",R.id.forecastThree);
                imageDownload("r_",R.id.forecastFour);
                imageDownload("r_",R.id.forecastFive);
                imageDownload("e_",R.id.forecastSix);
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
                imageDownload("e9",R.id.main_Meme);
                imageDownload("c9",R.id.forecastOne);
                imageDownload("h9",R.id.forecastTwo);
                imageDownload("t9",R.id.forecastThree);
                imageDownload("r9",R.id.forecastFour);
                imageDownload("r9",R.id.forecastFive);
                imageDownload("e9",R.id.forecastSix);
                //imageDownload("e_",R.id.main_Meme);
                //imageDownload("c_",R.id.forecastOne);
                //imageDownload("h_",R.id.forecastTwo);
                //imageDownload("t_",R.id.forecastThree);
                //imageDownload("r_",R.id.forecastFour);
                //imageDownload("r_",R.id.forecastFive);
                //imageDownload("e_",R.id.forecastSix);
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                //imageDownload("e9",R.id.main_Meme);
                //imageDownload("c9",R.id.forecastOne);
                //imageDownload("h9",R.id.forecastTwo);
                //imageDownload("t9",R.id.forecastThree);
                //imageDownload("r9",R.id.forecastFour);
                //imageDownload("r9",R.id.forecastFive);
                //imageDownload("e9",R.id.forecastSix);
                imageDownload("e_",R.id.main_Meme);
                imageDownload("c_",R.id.forecastOne);
                imageDownload("h_",R.id.forecastTwo);
                imageDownload("t_",R.id.forecastThree);
                imageDownload("r_",R.id.forecastFour);
                imageDownload("r_",R.id.forecastFive);
                imageDownload("e_",R.id.forecastSix);
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
                imageDownload("e9",R.id.main_Meme);
                imageDownload("c9",R.id.forecastOne);
                imageDownload("h9",R.id.forecastTwo);
                imageDownload("t9",R.id.forecastThree);
                imageDownload("r9",R.id.forecastFour);
                imageDownload("r9",R.id.forecastFive);
                imageDownload("e9",R.id.forecastSix);
                //imageDownload("e_",R.id.main_Meme);
                //imageDownload("c_",R.id.forecastOne);
                //imageDownload("h_",R.id.forecastTwo);
                //imageDownload("t_",R.id.forecastThree);
                //imageDownload("r_",R.id.forecastFour);
                //imageDownload("r_",R.id.forecastFive);
                //imageDownload("e_",R.id.forecastSix);
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                //imageDownload("e9",R.id.main_Meme);
                //imageDownload("c9",R.id.forecastOne);
                //imageDownload("h9",R.id.forecastTwo);
                //imageDownload("t9",R.id.forecastThree);
                //imageDownload("r9",R.id.forecastFour);
                //imageDownload("r9",R.id.forecastFive);
                //imageDownload("e9",R.id.forecastSix);
                imageDownload("e_",R.id.main_Meme);
                imageDownload("c_",R.id.forecastOne);
                imageDownload("h_",R.id.forecastTwo);
                imageDownload("t_",R.id.forecastThree);
                imageDownload("r_",R.id.forecastFour);
                imageDownload("r_",R.id.forecastFive);
                imageDownload("e_",R.id.forecastSix);
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
                imageDownload("e9",R.id.main_Meme);
                imageDownload("c9",R.id.forecastOne);
                imageDownload("h9",R.id.forecastTwo);
                imageDownload("t9",R.id.forecastThree);
                imageDownload("r9",R.id.forecastFour);
                imageDownload("r9",R.id.forecastFive);
                imageDownload("e9",R.id.forecastSix);
                //imageDownload("e_",R.id.main_Meme);
                //imageDownload("c_",R.id.forecastOne);
                //imageDownload("h_",R.id.forecastTwo);
                //imageDownload("t_",R.id.forecastThree);
                //imageDownload("r_",R.id.forecastFour);
                //imageDownload("r_",R.id.forecastFive);
                //imageDownload("e_",R.id.forecastSix);
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                //imageDownload("e9",R.id.main_Meme);
                //imageDownload("c9",R.id.forecastOne);
                //imageDownload("h9",R.id.forecastTwo);
                //imageDownload("t9",R.id.forecastThree);
                //imageDownload("r9",R.id.forecastFour);
                //imageDownload("r9",R.id.forecastFive);
                //imageDownload("e9",R.id.forecastSix);
                imageDownload("e_",R.id.main_Meme);
                imageDownload("c_",R.id.forecastOne);
                imageDownload("h_",R.id.forecastTwo);
                imageDownload("t_",R.id.forecastThree);
                imageDownload("r_",R.id.forecastFour);
                imageDownload("r_",R.id.forecastFive);
                imageDownload("e_",R.id.forecastSix);
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
                imageDownload("e9",R.id.main_Meme);
                imageDownload("c9",R.id.forecastOne);
                imageDownload("h9",R.id.forecastTwo);
                imageDownload("t9",R.id.forecastThree);
                imageDownload("r9",R.id.forecastFour);
                imageDownload("r9",R.id.forecastFive);
                imageDownload("e9",R.id.forecastSix);
                //imageDownload("e_",R.id.main_Meme);
                //imageDownload("c_",R.id.forecastOne);
                //imageDownload("h_",R.id.forecastTwo);
                //imageDownload("t_",R.id.forecastThree);
                //imageDownload("r_",R.id.forecastFour);
                //imageDownload("r_",R.id.forecastFive);
                //imageDownload("e_",R.id.forecastSix);
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                //imageDownload("e9",R.id.main_Meme);
                //imageDownload("c9",R.id.forecastOne);
                //imageDownload("h9",R.id.forecastTwo);
                //imageDownload("t9",R.id.forecastThree);
                //imageDownload("r9",R.id.forecastFour);
                //imageDownload("r9",R.id.forecastFive);
                //imageDownload("e9",R.id.forecastSix);
                imageDownload("e_",R.id.main_Meme);
                imageDownload("c_",R.id.forecastOne);
                imageDownload("h_",R.id.forecastTwo);
                imageDownload("t_",R.id.forecastThree);
                imageDownload("r_",R.id.forecastFour);
                imageDownload("r_",R.id.forecastFive);
                imageDownload("e_",R.id.forecastSix);

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

    public void imageDownload(String imgName, int imgId){
        imgName = "http://memedoppler.com/memes/"+ imgName + ".jpg";
        MyButton myButton = (MyButton) findViewById(imgId);
        Picasso.with(getApplicationContext()).load(imgName).into(myButton);
    }
}