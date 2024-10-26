package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isSpecialItem(item)) {
            updateSpecialItemQuality(item);
            decreaseSellIn(item);
            handleExpiredItem(item);
            return;
        }
        updateRegularItemQuality(item);
        decreaseSellIn(item);
        handleExpiredItem(item);
    }

    private boolean isSpecialItem(Item item) {
        return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItemQuality(Item item) {
        if (item.quality >= 50) {
            return;
        }

        item.quality += 1;

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePassQuality(item);
        }
    }

    private void updateBackstagePassQuality(Item item) {
        if (item.sellIn < 11 && item.quality < 50) {
            item.quality += 1;
        }

        if (item.sellIn < 6 && item.quality < 50) {
            item.quality += 1;
        }
    }

    private void updateRegularItemQuality(Item item) {
        if (item.quality <= 0 || item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        item.quality -= 1;
    }

    private void decreaseSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        item.sellIn -= 1;
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn >= 0) {
            return;
        }

        if (item.name.equals("Aged Brie")) {
            increaseQualityIfNotMax(item);
            return;
        }

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
            return;
        }

        decreaseQualityIfPositive(item);
    }

    private void increaseQualityIfNotMax(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void decreaseQualityIfPositive(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}
