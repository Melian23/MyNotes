package com.geekbrains.mynotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDescriptionNotes extends Fragment {

    public static final String ARG_NOTES = "notes";
    private Notes notes;

    public static FragmentDescriptionNotes newInstance(Notes notes) {
        FragmentDescriptionNotes fragment = new FragmentDescriptionNotes();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTES, notes);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String[] description = getResources().getStringArray(R.array.description);

        for (int i = 0; i < description.length; i++) {
            String descriptionNote = description[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(20f);
            textView.setText(descriptionNote);
            ((LinearLayout) view).addView(textView);
        }
 /*       notes = getArguments().getParcelable(ARG_NOTES);

        TextView etName = view.findViewById(R.id.textName);
        etName.setText(notes.getName());

        TextView etData =  view.findViewById(R.id.textData);
        etData.setText(notes.getData());

        EditText etDescription = view.findViewById(R.id.textDescription);
        etDescription.setText(notes.getDescription());
*/
    }
}