package com.gildedrose;

public class RoseFactory {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    public static RoseItem GeneratorRoseItem(String name, int sell_in, int quality) {
        switch (name) {
            case AGED_BRIE:
                return new AgedRoseItem(name, sell_in, quality);
            case BACKSTAGE:
                return new BackstageRoseItem(name, sell_in, quality);
            case SULFURAS:
                return new SulfurasRoseItem(name, sell_in, quality);
            default:
                return new NormalRoseItem(name, sell_in, quality);
        }
    }
}
