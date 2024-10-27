package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class ItemList {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> items() {
        return items;
    }
}
