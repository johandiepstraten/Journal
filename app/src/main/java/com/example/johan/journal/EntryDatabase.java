package com.example.johan.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public static EntryDatabase getInstance(Context ConText) {
        if (instance != null) {
            return instance;
        } else {
            instance = new EntryDatabase(ConText, "Entries", null, 1);
            return instance;
        }
    }
    public Cursor selectAll()  {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM entries", null);
        return cursor;
    }
    public void insert(JournalEntry Entry)    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues newvalues = new ContentValues();
        newvalues.put("Title", Entry.GetTitle());
        newvalues.put("Content", Entry.GetContent());
        newvalues.put("Mood", Entry.GetMood());

        db.insert("Entries", null, newvalues);

    }
    public void deleteEntry(long id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Entries", "idNumber" + '=' + id, null); // idNumber is misschien " _id"
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table entries( _id INTEGER PRIMARY KEY AUTOINCREMENT, Title String, Content String, Mood String, Timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)");
        ContentValues testvalues = new ContentValues();
        testvalues.put("Title", "TESTTITLE");
        testvalues.put("Content", "TESTCONTENT");
        testvalues.put("Mood", "TESTMOOD");
        db.insert("Entries", null, testvalues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "Entries");
        onCreate(db);
    }

}
