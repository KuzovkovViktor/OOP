package com.gildedrose;

class RegularItemUpdater {
    public void updateQuality(Item item) {
        if (!item.name.isEqualTo("Sulfuras, Hand of Ragnaros")) {
            item.quality.decrease();
        }

        item.sellIn.decrease();
        handleExpiredItem(item);
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn.isExpired()) {
            item.quality.decrease();
        }
    }
}
