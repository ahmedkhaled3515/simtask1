package com.example.simproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class More extends AppCompatActivity {
    SharedPreferences data;
    String channelid="MyNotification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        EditText name=findViewById(R.id.nameView);
        EditText feed=findViewById(R.id.FeedbackView);
        data=getSharedPreferences("Myprefrences", Context.MODE_PRIVATE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(channelid,channelid,NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        View.OnClickListener onclick=new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] sendto = {"ak8822677@gmail.com"};
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/");
                email.putExtra(Intent.EXTRA_EMAIL, sendto);
                email.putExtra(Intent.EXTRA_SUBJECT, "My Feedback");
                email.putExtra(Intent.EXTRA_TEXT, feed.getText().toString());
                if(name.getText().toString().isEmpty() && feed.getText().toString().isEmpty())
                {
                    feed.setHint(getString(R.string.feedback_error));
                    feed.setHintTextColor((int) R.color.category_numbers);
                    name.setHint(getString((R.string.name_error)));
                    name.setHintTextColor((int) R.color.category_numbers);
                }
                else if (name.getText().toString().isEmpty())
                {
                    name.setHint(getString((R.string.name_error)));
                    name.setHintTextColor((int) R.color.category_numbers);
                } else if (feed.getText().toString().isEmpty()) {
                    feed.setHint(getString(R.string.feedback_error));
                    feed.setHintTextColor((int) R.color.category_numbers);
                }
                else
                {
                    if (email.resolveActivity(getPackageManager()) != null) {
                        startActivity(email);
                    }
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(More.this, channelid);
                    builder.setSmallIcon(R.drawable.color_dusty_yellow);
                    builder.setContentTitle("Your feedback");
                    builder.setContentText("Hi " + name.getText().toString() + ",\nThanks for your feedback:");
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(feed.getText().toString()));
                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(More.this);
                    managerCompat.notify(5, builder.build());

                }
                SharedPreferences.Editor editor = data.edit();
                editor.putString("Name", name.getText().toString());
                editor.commit();
            }
        };
        Button Submit=findViewById(R.id.Submitbutton);
        Submit.setOnClickListener(onclick);
    }
}