package com.example.simproject1;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private ArrayList<Word> Words;
    private Context context;
    private MediaPlayer audio;
    public WordAdapter (Context cont,ArrayList<Word> Words)
    {
        this.Words=Words;
        context=cont;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View Wordview=inflater.inflate(R.layout.list_design,parent,false);
        ViewHolder viewHolder=new ViewHolder(Wordview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Word word=Words.get(position);
        holder.Arabicword.setText(word.getArabic());
        holder.Translation.setText(word.getTrans());
        if(word.hasImage())
        {
            holder.Image.setImageResource(word.getImageRes());
        }
        else{
            holder.Image.setVisibility(View.GONE);
        }
        holder.Row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audio= MediaPlayer.create(context,word.getSoundres());
                audio.start();

            }
        });
    }

    @Override
    public int getItemCount() {
        return Words.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView Arabicword;
        private TextView Translation;
        private ImageView Image;
        private RelativeLayout Row;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Arabicword =itemView.findViewById(R.id.arabictext);
            Translation =itemView.findViewById(R.id.englishtext);
            Image=itemView.findViewById(R.id.image);
            Row=itemView.findViewById(R.id.row);

        }
    }
    public void stopPlaying() {

            audio.stop();
            audio.release();

    }
}
