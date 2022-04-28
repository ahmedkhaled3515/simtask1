package com.example.simproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View.OnClickListener Familyintent=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Family.class);
                startActivity(intent);
            }
        };
        View.OnClickListener Colorsintent=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Colors.class);
                startActivity(intent);
            }
        };
        View.OnClickListener Phrasesintent=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Phrases.class);
                startActivity(intent);
            }
        };
        View.OnClickListener Numbersintent=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Numbers.class);
                startActivity(intent);
            }
        };
        View.OnClickListener Moreintent=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,More.class);
                startActivity(intent);
            }
        };
        RelativeLayout family=findViewById(R.id.Familycat);
        family.setOnClickListener(Familyintent);
        RelativeLayout Color=findViewById(R.id.Colorscat);
        Color.setOnClickListener(Colorsintent);
        RelativeLayout phrases=findViewById(R.id.Phrasescat);
        phrases.setOnClickListener(Phrasesintent);
        RelativeLayout Numbers=findViewById(R.id.NumbersCat);
        Numbers.setOnClickListener(Numbersintent);
        TextView More=findViewById(R.id.More);
        More.setOnClickListener(Moreintent);
        TextView welcome=findViewById(R.id.Welcome);
        SharedPreferences sp=getApplicationContext().getSharedPreferences("Myprefrences",Context.MODE_PRIVATE);
        String message=getString(R.string.welcome_text,sp.getString("Name",""));
        welcome.setText(message);


    }
}