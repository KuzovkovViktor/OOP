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
        } else {
            updateRegularItemQuality(item);
        }

        item.sellIn.decrease();
        handleExpiredItem(item);
    }

    private boolean isSpecialItem(Item item) {
        return item.name.isEqualTo("Aged Brie") || item.name.isEqualTo("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItemQuality(Item item) {
        item.quality.increase();

        if (item.name.isEqualTo("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePassQuality(item);
        }
    }

    private void updateBackstagePassQuality(Item item) {
        if (item.sellIn.getDays() < 11) {
            item.quality.increase();
        }

        if (item.sellIn.getDays() < 6) {
            item.quality.increase();
        }
    }

    private void updateRegularItemQuality(Item item) {
        if (!item.name.isEqualTo("Sulfuras, Hand of Ragnaros")) {
            item.quality.decrease();
        }
    }

    private void handleExpiredItem(Item item) {
        if (!item.sellIn.isExpired()) {
            return;
        }

        if (item.name.isEqualTo("Aged Brie")) {
            item.quality.increase();
            return;
        }

        if (item.name.isEqualTo("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality.reset();
            return;
        }

        item.quality.decrease();
    }
}
