package com.example.johan.journal;

import java.io.Serializable;
import java.security.Timestamp;

public class JournalEntry implements Serializable {
    private int IdNumber;
    private String title, content, mood, timestamp;

//  set values of JOurnalEntry class
    public JournalEntry(int idNumber, String title, String content, String mood, String timestamp) {
        IdNumber = idNumber;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }
//    Make sure that initiating an object without idNumber is possible
    public JournalEntry(String title, String content, String mood, String timestamp) {
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }
//    Make sure that initiating an object without idNumber and timestamp is possible
    public JournalEntry(String title, String content, String mood) {
        this.title = title;
        this.content = content;
        this.mood = mood;
    }
//    Initiate getters and setters for all values
    public int GetIdNumber()    {return IdNumber;}
    public String GetTitle()    {return title;}
    public String GetContent()  {return  content;}
    public String GetMood() {return mood;}
    public String GetTimestamp() {return timestamp;}
    public void setTitle(String title)  {this.title = title;} //settitle bestaat al?
    public void setContent(String content)  {this.content = content;} //setcontent bestaat al?
    public void setMood(String mood)    {this.mood = mood;}
}
