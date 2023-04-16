package com.example.viikko_12;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        FragmentAdapter adapter = new FragmentAdapter(this);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("List");
                    break;
                case 1:
                    tab.setText("Add Item");
                    break;
                case 2:
                    tab.setText("Important Items");
                    break;
            }
        });
        tabLayoutMediator.attach();
    }

    public void addNewItem(String itemName, boolean isImportant) {
        ListFragment listFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag("f" + 0);
        ImportantItemsFragment importantItemsFragment = (ImportantItemsFragment) getSupportFragmentManager().findFragmentByTag("f" + 2);
        if (listFragment != null) {
            listFragment.addNewItem(itemName, isImportant);
            if (isImportant && importantItemsFragment != null) {
                importantItemsFragment.addImportantItem(new ShoppingItem(itemName, true));
            }
        } else {
            Log.d("MainActivity", "listFragment is null");
        }
    }
}