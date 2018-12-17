package com.example.johan.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EntryAdapter thisadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Initiate Database
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
//        Initiate adapter and clicklisteners
        thisadapter = new EntryAdapter(this, db.selectAll());
        ListView listView = findViewById(R.id.ListView);
        listView.setAdapter(thisadapter);
        listView.setOnItemClickListener(new OnItemClickListener());
        listView.setOnItemLongClickListener(new OnItemLongClickListener());
    }
//    create new journal

    public void AddJournal(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }
//    Keep database updated
    private void updateData(EntryDatabase db)    {
        thisadapter.swapCursor(db.selectAll());
    }
//    If clicked on item, get all values of class and pass it to DetailActivity
    private class OnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor clickedJournal = (Cursor) parent.getItemAtPosition(position);

            String Title = clickedJournal.getString(clickedJournal.getColumnIndex("Title"));
            String Mood = clickedJournal.getString(clickedJournal.getColumnIndex("Mood"));
            String Timestamp = clickedJournal.getString(clickedJournal.getColumnIndex("Timestamp"));
            String Content = clickedJournal.getString(clickedJournal.getColumnIndex("Content"));
            JournalEntry thisentry = new JournalEntry(Title, Content, Mood, Timestamp);

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("clicked_journal", thisentry);
            startActivity(intent);
        }
    }
//    If long clicked on item in adapter, delete item from database.
    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
            Cursor longclickedJournal = (Cursor) parent.getItemAtPosition(position);
            long JournalId = longclickedJournal.getInt(longclickedJournal.getColumnIndex("_id"));
            db.deleteEntry(JournalId);
            updateData(db);
            return false;
        }

    }
}
