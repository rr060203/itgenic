package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notes.Database.App;
import com.example.notes.Database.NoteDao;
import com.example.notes.Database.NoteEntity;

public class CreateNoteActivity extends AppCompatActivity implements View.OnClickListener {
    Button btAddNote, btClose;
    EditText editName, editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        btAddNote=findViewById(R.id.CreateNoteActivityBtAN);
        btClose=findViewById(R.id.CreateNoteActivityBtClose);
        editName=findViewById(R.id.CreateNoteActivityEtName);
        editNote=findViewById(R.id.CreateNoteActivityEtNote);
        btAddNote.setOnClickListener(this);
        btClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.CreateNoteActivityBtAN:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        NoteDao dao= App.getInstance().getDatabase().getDao();
                        NoteEntity entity=new NoteEntity();
                        entity.setName(editName.getText().toString());
                        entity.setNote(editNote.getText().toString());
                        dao.insert(entity);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                editNote.setText("");
                                editName.setText("");
                                Toast.makeText(getBaseContext(),"Note Added", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
                break;
            case R.id.CreateNoteActivityBtClose:
                finish();
                break;
        }
    }
}
