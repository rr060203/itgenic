package com.example.notes.Database;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {NoteEntity.class},version = 1)
public abstract class Database extends RoomDatabase {
   public abstract NoteDao getDao();
}
