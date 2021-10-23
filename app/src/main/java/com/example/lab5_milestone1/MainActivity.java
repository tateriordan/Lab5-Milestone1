package com.example.lab5_milestone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public static String usernameKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            sharedPreferences.getString(usernameKey, "");
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }

        Intent intent = getIntent();
        
    }

    public void clickFunction(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", "tate").apply();
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}