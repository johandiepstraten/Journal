package com.example.johan.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    JournalEntry JournalEntry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        JournalEntry = (JournalEntry) intent.getSerializableExtra("clicked_journal");
        ((TextView) findViewById(R.id.DetailTitle)).setText(JournalEntry.GetTitle());
        ((TextView) findViewById(R.id.DetailTime)).setText(JournalEntry.GetTimestamp());
        ((TextView) findViewById(R.id.DetailMood)).setText(JournalEntry.GetMood());
        ((TextView) findViewById(R.id.DetailContent)).setText(JournalEntry.GetContent());




    }
}
