package com.example.johan.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter (Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }
//  Set values that we want to show in the adapter for each Journal
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view.findViewById(R.id.Title)).setText(cursor.getString(cursor.getColumnIndex("Title")));
        ((TextView) view.findViewById(R.id.Mood)).setText(cursor.getString(cursor.getColumnIndex("Mood")));
        ((TextView) view.findViewById(R.id.Timestamp)).setText(cursor.getString(cursor.getColumnIndex("Timestamp")));
        String mood = cursor.getString(cursor.getColumnIndex("Mood"));
        ImageView moodimage = view.findViewById(R.id.Moodimage);
        switch (mood)   {
            case "Angry":
                moodimage.setImageResource(R.drawable.angry_egg);
                break;
            case "Happy":
                moodimage.setImageResource(R.drawable.happy_egg);
                break;
            case "Confused":
                moodimage.setImageResource(R.drawable.tired_egg);
                break;
            case "Sad":
                moodimage.setImageResource(R.drawable.sad_egg);
                break;

        }
    }
}
