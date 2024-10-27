package com.gildedrose;

class GildedRose {
    ItemList itemList;

    public GildedRose(ItemList itemList) {
        this.itemList = itemList;
    }

    public void updateQuality() {
        for (Item item : itemList.items()) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isSpecialItem(item)) {
            new SpecialItemUpdater().updateQuality(item);
            return;
        }

        new RegularItemUpdater().updateQuality(item);
    }

    
    private boolean isSpecialItem(Item item) {
        return item.name.isEqualTo("Aged Brie") || item.name.isEqualTo("Backstage passes to a TAFKAL80ETC concert");
    }
}
