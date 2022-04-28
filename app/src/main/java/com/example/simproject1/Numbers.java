package com.example.simproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    private WordAdapter Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("one", "واحد",R.drawable.number_one,R.raw.one));
        words.add(new Word("two", "اثنان",R.drawable.number_two,R.raw.two));
        words.add(new Word("three", "ثلاثة",R.drawable.number_three,R.raw.three));
        words.add(new Word("four", "اربعة",R.drawable.number_four,R.raw.four));
        words.add(new Word("five", "خمسة",R.drawable.number_five,R.raw.five));
        words.add(new Word("six", "ستة",R.drawable.number_six,R.raw.six));
        words.add(new Word("seven", "سبعة",R.drawable.number_seven,R.raw.seven));
        words.add(new Word("eight", "ثمانية",R.drawable.number_eight,R.raw.eight));
        words.add(new Word("nine", "تسعة",R.drawable.number_nine,R.raw.nine));
        words.add(new Word("ten", "عشرة",R.drawable.number_ten,R.raw.ten));
        Adapter=new WordAdapter(this,words);
        RecyclerView recyclerView= findViewById(R.id.List);
        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        Adapter.stopPlaying();
//    }
}