package com.example.lab5_milestone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity3 extends AppCompatActivity {

    int noteid = -1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView = findViewById(R.id.textView4);
        Intent intent = getIntent();
        String str = intent.getStringExtra("noteid");
        if (str != null) {
            Integer i = Integer.parseInt(str);
            noteid = i;
        }

        if (noteid != -1){
            Note note = MainActivity2.notes.get(noteid);
            String noteContent = note.getContent();
            textView.setText(noteContent);
        }
    }

    public void saveMethod(View view){
        textView = findViewById(R.id.textView4);
        String content = textView.toString();
//        Note note = MainActivity2.notes.get(noteid);
//        Note noteContent = note.getContent();
        Context context = getApplicationContext();
        SQLiteDatabase sqLiteDatabase = context.openOrCreateDatabase("notes", Context.MODE_PRIVATE, null);

        DBHelper db = new DBHelper(sqLiteDatabase);

        SharedPreferences sharedPreferences= getSharedPreferences("com.example.lab5_milestone1", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");


        String title;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());

        if (noteid == -1){
            title = "NOTE_" + (MainActivity2.notes.size() + 1);
            db.saveNotes(username, title, content, date);

        } else {
            title = "NOTE_" + (noteid + 1);
            db.updateNote(title, date, content, username);
        }
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}