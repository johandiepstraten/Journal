package com.example.johan.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }


    public void MoodPicked(View view) {
        Log.d("Journal", "MoodPicked: " + String.valueOf(view.getId()));
        int egg = view.getId();
        switch(egg)  {
            case R.id.SadEgg:
                TextView sad = findViewById(R.id.Moods);
                sad.setText("Sad");
                break;
            case R.id.HappyEgg:
                TextView happy = findViewById(R.id.Moods);
                happy.setText("Happy");
                break;
            case R.id.AngryEgg:
                TextView angry = findViewById(R.id.Moods);
                angry.setText("Angry");
                break;
            case R.id.ConfusedEgg:
                TextView confused = findViewById(R.id.Moods);
                confused.setText("Confused");
                break;
        }
    }

    public void addEntry(View view) {
        Log.d("Journal", "Submit: " + String.valueOf(view.getId()));
        TextView temptitle = findViewById(R.id.Title);
        String title = temptitle.getText().toString();
        TextView tempcontent = findViewById(R.id.Content);
        String content = tempcontent.getText().toString();
        TextView tempmood = findViewById(R.id.Moods);
        String mood = tempmood.getText().toString();
        JournalEntry entry = new JournalEntry(title, content, mood);
        EntryDatabase db = EntryDatabase.getInstance(InputActivity.this);
        db.insert(entry);

        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
