package com.example.notes.Database;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    static App instance;
    Database database;

    public static App getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return database;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        database= Room.databaseBuilder(this, Database.class, "NoteDatabase").build();
    }
}
