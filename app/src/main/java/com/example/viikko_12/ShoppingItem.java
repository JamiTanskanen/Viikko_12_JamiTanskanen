package com.example.viikko_12;

public class ShoppingItem {

    private String name;
    private boolean isImportant;

    public ShoppingItem(String name, boolean isImportant) {
        this.name = name;
        this.isImportant = isImportant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }
}
