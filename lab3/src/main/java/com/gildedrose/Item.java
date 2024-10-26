package com.gildedrose;

class Item {
    Name name;
    SellIn sellIn;
    Quality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = new Name(name);
        this.sellIn = new SellIn(sellIn);
        this.quality = new Quality(quality);
    }

    @Override
    public String toString() {
        return name.getName() + ", " + sellIn.getDays() + ", " + quality.getQuality();
    }
}
