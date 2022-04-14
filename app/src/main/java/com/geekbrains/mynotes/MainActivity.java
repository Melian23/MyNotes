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
            FragmentListNotes fragmentListNotes = FragmentListNotes.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.listNote, fragmentListNotes).commit();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                Notes defaultNote = new Notes("Тост", 2022, "Удивительно устроен человек - он огорчается, когда теряет богатство, и равнодушен к тому, что безвозвратно уходят дни его жизни!");
                FragmentDescriptionNotes fragmentDescriptionNotes = FragmentDescriptionNotes.newInstance(defaultNote);
                getSupportFragmentManager().beginTransaction().replace(R.id.descriptionNotes, fragmentDescriptionNotes).commit();
            }
        }
    }
}