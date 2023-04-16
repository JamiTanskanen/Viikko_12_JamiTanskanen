package com.example.viikko_12;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ImportantItemsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ShoppingListAdapter adapter;
    private List<ShoppingItem> importantItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_important_items, container, false);

        importantItems = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        adapter = new ShoppingListAdapter(importantItems, new ShoppingListAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(ShoppingItem item, int position) {
            }

            @Override
            public void onDeleteClick(int position) {
                importantItems.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void addImportantItem(ShoppingItem item) {
        importantItems.add(item);
        adapter.notifyItemInserted(importantItems.size() - 1);
    }
}