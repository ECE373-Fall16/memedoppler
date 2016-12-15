package com.example.chad.memedoppler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ExpandedMeme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_meme);
        int imageId = getIntent().getIntExtra("imageId",0);
        Toast.makeText(getApplicationContext(), imageId, Toast.LENGTH_SHORT).show();
        MyButton myButton = (MyButton) findViewById(R.id.main_Meme);
        Picasso.with(getApplicationContext()).load(imageId).into(myButton);
    }
    public void MainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
