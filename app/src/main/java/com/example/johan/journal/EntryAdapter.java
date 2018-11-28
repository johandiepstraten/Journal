package com.example.johan.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view.findViewById(R.id.Title)).setText(cursor.getString(cursor.getColumnIndex("Title")));
        ((TextView) view.findViewById(R.id.Mood)).setText(cursor.getString(cursor.getColumnIndex("Mood")));
        ((TextView) view.findViewById(R.id.Timestamp)).setText(cursor.getString(cursor.getColumnIndex("Timestamp")));
    }
}
