package com.example.viikko_12;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddItemFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_item, container, false);

        EditText itemNameEditText = view.findViewById(R.id.item_name_edit_text);
        CheckBox importantCheckBox = view.findViewById(R.id.important_checkbox);
        FloatingActionButton addItemFab = view.findViewById(R.id.add_item_fab);
        addItemFab.setOnClickListener(v -> {
            String itemName = itemNameEditText.getText().toString();
            boolean isImportant = importantCheckBox.isChecked();
            ((MainActivity) requireActivity()).addNewItem(itemName, isImportant);
        });

        return view;
    }
}