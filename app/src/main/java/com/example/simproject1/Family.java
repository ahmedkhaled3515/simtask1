package com.example.simproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.UserDictionary;

import java.util.ArrayList;

public class Family extends AppCompatActivity {
    private WordAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("father", "أب", R.drawable.family_father, R.raw.father));
        words.add(new Word("mother", "أم", R.drawable.family_mother, R.raw.mother));
        words.add(new Word("son", "أبن", R.drawable.family_son, R.raw.son));
        words.add(new Word("daughter", "ابنة", R.drawable.family_daughter, R.raw.daughter));
        words.add(new Word(" brother", "الاخ ", R.drawable.family_older_brother, R.raw.brother));
        words.add(new Word("sister", "الاخت", R.drawable.family_younger_brother, R.raw.sister));
        words.add(new Word(" nephew", "ابن الاخ", R.drawable.family_older_sister, R.raw.nephew));
        words.add(new Word("niece", "ابنة الاخ", R.drawable.family_younger_sister, R.raw.niece));
        words.add(new Word("grandmother", "الجدة", R.drawable.family_grandmother, R.raw.grandmother));
        words.add(new Word("grandfather", "الجد", R.drawable.family_grandfather, R.raw.grandfather));
        RecyclerView WordsList = (RecyclerView) findViewById(R.id.List);
        Adapter = new WordAdapter(this, words);
        WordsList.setAdapter(Adapter);
        WordsList.setLayoutManager(new LinearLayoutManager(this));

    }
//    protected void onStop() {
//        super.onStop();
//        Adapter.stopPlaying();
//    }
}