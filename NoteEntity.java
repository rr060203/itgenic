package com.example.notes.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NoteEntity {

    @ColumnInfo(name="id")
    @PrimaryKey(autoGenerate = true)
    long id;
    @ColumnInfo(name="name")
    String name;
    @ColumnInfo(name="note")
    String note;

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }
}
