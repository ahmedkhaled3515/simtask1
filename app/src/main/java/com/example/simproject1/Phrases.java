package com.example.simproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
    private WordAdapter Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("See you later", "إلى اللقاء ",R.raw.goodbye));
        words.add(new Word("Sorry for being late", " معذرة عن التأخير",R.raw.sorrylate));
        words.add(new Word("Where are we meeting?", "أين سنلتقي؟",R.raw.wheretomeet));
        words.add(new Word("I'll be right back", " سوف أعود فورا",R.raw.willberightback));
        words.add(new Word("How's it going?", "كيف الحال؟",R.raw.howareu));
        words.add(new Word("Thank you very much", " شكرا جزيلا",R.raw.thanks));
        words.add(new Word("I'm back", "لقد عدت",R.raw.iamback));
        words.add(new Word("Do you speak English?", "هل تتكلم الانجليزية؟",R.raw.douspeakeng));
        Adapter=new WordAdapter(this,words);
        RecyclerView recyclerView= findViewById(R.id.List);
        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
//    protected void onStop() {
//        super.onStop();
//        Adapter.stopPlaying();
//    }
}