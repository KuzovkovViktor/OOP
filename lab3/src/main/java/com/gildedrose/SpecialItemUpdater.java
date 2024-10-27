package com.gildedrose;

class SpecialItemUpdater {
    public void updateQuality(Item item) {
        item.quality.increase();

        if (item.name.isEqualTo("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePassQuality(item);
        }

        item.sellIn.decrease();
        handleExpiredItem(item);
    }

    private void updateBackstagePassQuality(Item item) {
        if (item.sellIn.isBelow(11)) {
            item.quality.increase();
        }

        if (item.sellIn.isBelow(6)) {
            item.quality.increase();
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn.isExpired()) {
            item.quality.reset();
        }
    }
}
