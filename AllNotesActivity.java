package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.notes.Database.App;
import com.example.notes.Database.NoteDao;
import com.example.notes.Database.NoteEntity;

import java.util.List;

public class AllNotesActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerViewAdapter adapter;
    List<NoteEntity>noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notes);
        rv = findViewById(R.id.RecView);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume() {
        super.onResume();
    new Thread(new Runnable() {
            @Override
            public void run() {
                NoteDao dao= App.getInstance().getDatabase().getDao();
                noteList=dao.getAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter=new RecyclerViewAdapter(noteList, new RecyclerViewAdapter.OnUserClickListener() {
                            @Override
                            public void onUserClick(NoteEntity noteEntity) {
                                Intent intent=new Intent(getBaseContext(), NoteActivity.class);
                                intent.putExtra("id", noteEntity.getId());
                                startActivity(intent);
                            }
                        });
                        rv.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }
}
