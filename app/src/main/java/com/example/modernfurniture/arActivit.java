package com.example.modernfurniture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class arActivit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
    }

    public void gotomain(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}