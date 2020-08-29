package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btCN, btAN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btCN=findViewById(R.id.ActivityMainCN);
        btAN=findViewById(R.id.ActivityMainAN);
        btCN.setOnClickListener(this);
        btAN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ActivityMainCN:
                Intent i1=new Intent(this, CreateNoteActivity.class);
                startActivity(i1);
                break;
            case R.id.ActivityMainAN:
                Intent i2=new Intent(this, AllNotesActivity.class);
                startActivity(i2);
                break;
        }
    }
}
