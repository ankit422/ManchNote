package com.manch.manchfeed.database.model;

public class Note {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_NOTE_DESCRIPTION = "note_description";
    public static final String COLUMN_NOTE_IMAGE = "note_image";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String note;
    private String note_description;
    private String note_image;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOTE + " TEXT,"
                    + COLUMN_NOTE_DESCRIPTION + " TEXT,"
                    + COLUMN_NOTE_IMAGE + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Note() {
    }

    public Note(int id, String note, String description, String image, String timestamp) {
        this.id = id;
        this.note = note;
        this.note_description = description;
        this.note_image = image;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }
    public String getNoteDescription() {
        return note_description;
    }
    public String getNoteImage() {
        return note_image;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNoteDescription(String noteDescription) {
        this.note_description = noteDescription;
    }

    public void setNoteImage(String noteImage) {
        this.note_image = noteImage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
