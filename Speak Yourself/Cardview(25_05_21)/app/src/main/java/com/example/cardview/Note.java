package com.example.cardview;


import java.util.ArrayList;
import java.util.Date;

public class Note
{
    public static ArrayList<Note> noteArrayList = new ArrayList<>();
    public static String NOTE_EDIT_EXTRA =  "noteEdit";

    private int id;
    private String str;
    private String result;
    private String fillercount;
    private String rateofspeech;
    private Date deleted;

    public Note(int id, String str, String result, String fillercount, String rateofspeech, Date deleted)
    {
        this.id = id;
        this.str = str;
        this.result = result;
        this.fillercount = fillercount;
        this.rateofspeech = rateofspeech;
        this.deleted = this.deleted;
    }

    public Note(int id, String str, String result,String fillercount,String rateofspeech)
    {
        this.id = id;
        this.str = str;
        this.result = result;
        this.fillercount = fillercount;
        this.rateofspeech = rateofspeech;
        deleted = null;
    }

    public static Note getNoteForID(int passedNoteID)
    {
        for (Note note : noteArrayList)
        {
            if(note.getId() == passedNoteID)
                return note;
        }

        return null;
    }

    public static ArrayList<Note> nonDeletedNotes()
    {
        ArrayList<Note> nonDeleted = new ArrayList<>();
        for(Note note : noteArrayList)
        {
            if(note.getDeleted() == null)
                nonDeleted.add(note);
        }

        return nonDeleted;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStr()
    {
        return str;
    }

    public void setStr(String title)
    {
        this.str = str;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String description)
    {
        this.result = result;
    }

    public String getFillercount()
    {
        return fillercount;
    }

    public void setFillercount(String fillercount)
    {
        this.fillercount = fillercount;
    }

    public String getRateofspeech()
    {
        return rateofspeech;
    }

    public void setRateofspeech(String rateofspeech)
    {
        this.rateofspeech = rateofspeech;
    }

    public Date getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Date deleted)
    {
        this.deleted = deleted;
    }
}
