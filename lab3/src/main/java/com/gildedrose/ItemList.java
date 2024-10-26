package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class ItemList {
    private List<Item> items;

    public ItemList() {
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public List<Item> getItems() {
        return items;
    }
}
