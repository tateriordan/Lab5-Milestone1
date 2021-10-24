package com.example.lab5_milestone1;

import androidx.appcompat.app.AppCompatActivity;

public class Note extends AppCompatActivity {

    private String date;
    private String username;
    private String title;
    private String content;

    public Note(String date, String username, String title, String content){
        this.date = date;
        this.username = username;
        this.title = title;
        this.content = content;

    }

    public String getDate(){ return date; }
    public String getUsername(){ return username; }
    public String getTitle1(){ return title; }
    public String getContent(){ return content; }
}
