package com.example.notes.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT*FROM NOTEENTITY")
    List<NoteEntity> getAll();
    @Delete
    void delete(NoteEntity noteEntity);
    @Insert
    void insert(NoteEntity noteEntity);
}
