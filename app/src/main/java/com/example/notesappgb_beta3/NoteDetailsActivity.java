package com.example.notesappgb_beta3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class NoteDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        if (savedInstanceState == null) {

            Intent intent = getIntent();
            int index = intent.getIntExtra(NotesDetailFragment.ARG_INDEX, 0);
            String title = intent.getStringExtra("title");
            String description = intent.getStringExtra("description");
            String data = intent.getStringExtra("data");
            NotesDetailFragment notesDetailFragment = NotesDetailFragment.newInstance(index, title, description, data);


            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.notes_detail_container, notesDetailFragment);
            fragmentTransaction.commit();

        }
    }
}