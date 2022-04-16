package com.geekbrains.mynotes;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentListNotes extends Fragment {

    public static final String ARG_NOTES = "notes";
    private Notes notes;

    public static FragmentListNotes newInstance() {
        FragmentListNotes fragment = new FragmentListNotes();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] notes = getResources().getStringArray(R.array.notes);

        for (int i = 0; i < notes.length; i++) {
            String noteName = notes[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(30f);
            textView.setText(noteName);
            ((LinearLayout) view).addView(textView);
            int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Notes notes = new Notes(finalI);
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        FragmentDescriptionNotes fragmentDescriptionNotes = FragmentDescriptionNotes.newInstance(notes);
                        getParentFragmentManager().beginTransaction().replace(R.id.descriptionNotes, fragmentDescriptionNotes).commit();
                    } else {
                        FragmentDescriptionNotes fragmentDescriptionNotes = FragmentDescriptionNotes.newInstance(notes);
                        getParentFragmentManager().beginTransaction().replace(R.id.listNote, fragmentDescriptionNotes).addToBackStack("").commit();
                    }
                }
            });
        }
    }
}