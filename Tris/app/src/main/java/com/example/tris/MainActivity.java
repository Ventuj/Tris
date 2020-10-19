package com.example.tris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.button3);
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                open();
            }
        });
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }
    void open(){
        Intent intent = new Intent(this, Gioco.class);
        startActivity(intent);
    }
}