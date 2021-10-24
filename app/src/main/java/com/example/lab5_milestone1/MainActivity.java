package com.example.lab5_milestone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static String usernameKey = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            sharedPreferences.getString(usernameKey, "");
            Intent intent1 = new Intent(this, MainActivity2.class);
            startActivity(intent1);
        } else {
            setContentView(R.layout.activity_main);
        }

        Intent intent = getIntent();
        
    }

    public void clickFunction(View view){
//        EditText myTextField = (EditText)findViewById(R.id.textView);
//        String str = myTextField.getText().toString();
        TextView textView = (TextView) findViewById(R.id.textView);
        String helper = textView.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", helper).apply();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username", helper);
        startActivity(intent);
//        goToActivity2(str);
    }

//    public void goToActivity2(String s){
//        Intent intent = new Intent(this, MainActivity2.class);
//        intent.putExtra("message", s);
//        startActivity(intent);
//    }
}