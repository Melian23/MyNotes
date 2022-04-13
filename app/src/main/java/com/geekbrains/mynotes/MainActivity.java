package com.geekbrains.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            FragmentListNote fragmentListNote = new FragmentListNote();
            getSupportFragmentManager().beginTransaction().replace(R.id.listNote, fragmentListNote).commit();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                FragmentDescriptionNotes fragmentDescriptionNotes = new FragmentDescriptionNotes();
                getSupportFragmentManager().beginTransaction().replace(R.id.descriptionNotes, fragmentDescriptionNotes).commit();
            }
        }
    }
}