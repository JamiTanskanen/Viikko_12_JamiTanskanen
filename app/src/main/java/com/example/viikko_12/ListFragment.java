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

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ShoppingListAdapter adapter;
    private List<ShoppingItem> shoppingItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        shoppingItems = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        adapter = new ShoppingListAdapter(shoppingItems, new ShoppingListAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(ShoppingItem item, int position) {
            }

            @Override
            public void onDeleteClick(int position) {
                shoppingItems.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void addNewItem(String itemName, boolean isImportant) {
        ShoppingItem item = new ShoppingItem(itemName, isImportant);
        shoppingItems.add(item);
        adapter.notifyItemInserted(shoppingItems.size() - 1);
    }
}
