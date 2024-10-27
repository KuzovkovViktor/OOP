package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemList itemList = new ItemList();
        itemList.add(new Item("+5 Dexterity Vest", 10, 20));
        itemList.add(new Item("Aged Brie", 2, 0));
        itemList.add(new Item("Elixir of the Mongoose", 5, 7));
        itemList.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        itemList.add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
        itemList.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        itemList.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        itemList.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        itemList.add(new Item("Conjured Mana Cake", 3, 6));

        GildedRose app = new GildedRose(itemList);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : itemList.getItems()) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }
}
