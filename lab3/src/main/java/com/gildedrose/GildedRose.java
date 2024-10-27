package com.gildedrose;

class GildedRose {
    private ItemList itemList;

    public GildedRose(ItemList itemList) {
        this.itemList = itemList;
    }

    public void updateQuality() {
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        String itemName = item.name.getName();
        SellIn itemSellIn = item.sellIn;
        Quality itemQuality = item.quality;

        if (isSpecialItem(itemName)) {
            updateSpecialItemQuality(itemName, itemQuality, itemSellIn);
        } else {
            updateRegularItemQuality(itemName, itemQuality);
        }

        itemSellIn.decrease();
        handleExpiredItem(itemName, itemQuality, itemSellIn);
    }

    private boolean isSpecialItem(String itemName) {
        return itemName.equals("Aged Brie") || itemName.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItemQuality(String itemName, Quality itemQuality, SellIn itemSellIn) {
        itemQuality.increase();

        if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePassQuality(itemSellIn, itemQuality);
        }
    }

    private void updateBackstagePassQuality(SellIn itemSellIn, Quality itemQuality) {
        int sellInDays = itemSellIn.getDays();

        if (sellInDays < 11) {
            itemQuality.increase();
        }

        if (sellInDays < 6) {
            itemQuality.increase();
        }
    }

    private void updateRegularItemQuality(String itemName, Quality itemQuality) {
        if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
            itemQuality.decrease();
        }
    }

    private void handleExpiredItem(String itemName, Quality itemQuality, SellIn itemSellIn) {
        if (!itemSellIn.isExpired()) {
            return;
        }

        if (itemName.equals("Aged Brie")) {
            itemQuality.increase();
            return;
        }

        if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            itemQuality.reset();
            return;
        }

        itemQuality.decrease();
    }
}
