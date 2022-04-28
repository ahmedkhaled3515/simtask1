package com.example.simproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    private WordAdapter Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("red", "احمر",R.drawable.color_red,R.raw.red));
        words.add(new Word("green", "اخضر",R.drawable.color_green,R.raw.green));
        words.add(new Word("brown", "بني",R.drawable.color_brown,R.raw.brown));
        words.add(new Word("gray", "رمادي",R.drawable.color_gray,R.raw.gray));
        words.add(new Word("black", "اسود",R.drawable.color_black,R.raw.black));
        words.add(new Word("white", "ابيض",R.drawable.color_white,R.raw.white));
        words.add(new Word("dusty yellow", "اصفر غامق",R.drawable.color_dusty_yellow,R.raw.dustyyellow));
        words.add(new Word("mustard yellow", " اصفر",R.drawable.color_mustard_yellow,R.raw.yellow));
        RecyclerView WordsList = (RecyclerView) findViewById(R.id.List);
        Adapter = new WordAdapter(this, words);
        WordsList.setAdapter(Adapter);
        WordsList.setLayoutManager(new LinearLayoutManager(this));
    }
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Adapter.stopPlaying();
//    }
}