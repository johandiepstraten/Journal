package com.example.johan.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        EntryAdapter adapter = new EntryAdapter(this, db.selectAll());
        ListView listView = findViewById(R.id.ListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener());
        listView.setOnItemLongClickListener(new OnItemLongClickListener());
    }
//    create new journal
    public void New_Journal(View view) {
        startActivity(new Intent(MainActivity.this, InputActivity.class));
    }

    public void AddJournal(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }
    private void updateData()    {
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        EntryAdapter adapter = new EntryAdapter(this, db.selectAll());
    }
    private class OnItemClickListener implements AdapterView.OnItemClickListener  {
        @Override
        public void OnItemClick(AdapterView<?> parent, View view, int position, long id)    {
            JournalEntry clickedJournal = (JournalEntry) parent.getItemAtPosition(position);
            Log.d("Journal", "checkClicked: " + String.valueOf(clickedJournal.GetTitle()));

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("clicked_journal", clickedJournal);
            startActivity(intent);
        }
    }
    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener  {
        @Override
        public void OnItemLongClick(AdapterView<?> parent, View view, int position, long id)    {
            JournalEntry LongclickedJournal = (JournalEntry) parent.getItemAtPosition(position);
            Log.d("Journal", "checkLongClicked: " + String.valueOf(LongclickedJournal.GetTitle()));
            long JournalId = LongclickedJournal.GetIdNumber();
            deleteEntry(JournalId);
        }

    }
}
