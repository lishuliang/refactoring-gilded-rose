package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static com.gildedrose.RoseFactory.GeneratorRoseItem;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    private GildedRose gildedRose;

    @Before
    public void setUp() {
        RoseItem[] roseItems = new RoseItem[] {
                GeneratorRoseItem("+5 Dexterity Vest", 10, 20), //
                GeneratorRoseItem("Aged Brie", 2, 0), //
                GeneratorRoseItem("Elixir of the Mongoose", 5, 7), //
                GeneratorRoseItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                GeneratorRoseItem("Sulfuras, Hand of Ragnaros", -1, 80),
                GeneratorRoseItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                GeneratorRoseItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                GeneratorRoseItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                GeneratorRoseItem("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                GeneratorRoseItem("Backstage passes to a TAFKAL80ETC concert", 0, 20),
                // this conjured item does not work properly yet
                GeneratorRoseItem("Conjured Mana Cake", 3, 6) };

        gildedRose = new GildedRose(roseItems);
    }

    @Test
    public void dexterity_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("+5 Dexterity Vest", gildedRose.getRoseItems()[0].getName());
        assertEquals(gildedRose.getRoseItems()[0].getQuality(), 19);
        assertEquals(gildedRose.getRoseItems()[0].getSellIn(), 9);
    }

    @Test
    public void aged_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Aged Brie", gildedRose.getRoseItems()[1].getName());
        assertEquals(gildedRose.getRoseItems()[1].getQuality(), 1);
        assertEquals(gildedRose.getRoseItems()[1].getSellIn(), 1);
    }

    @Test
    public void elixir_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Elixir of the Mongoose", gildedRose.getRoseItems()[2].getName());
        assertEquals(gildedRose.getRoseItems()[2].getQuality(), 6);
        assertEquals(gildedRose.getRoseItems()[2].getSellIn(), 4);
    }

    @Test
    public void sulfuras_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.getRoseItems()[3].getName());
        assertEquals(gildedRose.getRoseItems()[3].getQuality(), 80);
        assertEquals(gildedRose.getRoseItems()[3].getSellIn(), 0);
    }

    @Test
    public void backstage_item_when_sellin_is_15_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getRoseItems()[5].getName());
        assertEquals(gildedRose.getRoseItems()[5].getQuality(), 21);
        assertEquals(gildedRose.getRoseItems()[5].getSellIn(), 14);
    }

    @Test
    public void backstage_item_when_sellin_is_10_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getRoseItems()[6].getName());
        assertEquals(gildedRose.getRoseItems()[6].getQuality(), 50);
        assertEquals(gildedRose.getRoseItems()[6].getSellIn(), 9);
    }

    @Test
    public void backstage_item_when_sellin_is_5_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getRoseItems()[7].getName());
        assertEquals(gildedRose.getRoseItems()[7].getQuality(), 50);
        assertEquals(gildedRose.getRoseItems()[7].getSellIn(), 4);
    }

    @Test
    public void backstage_item_when_sellin_is_1_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getRoseItems()[8].getName());
        assertEquals(gildedRose.getRoseItems()[8].getQuality(), 23);
        assertEquals(gildedRose.getRoseItems()[8].getSellIn(), 0);
    }

    @Test
    public void backstage_item_when_sellin_is_0_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getRoseItems()[9].getName());
        assertEquals(gildedRose.getRoseItems()[9].getQuality(), 0);
        assertEquals(gildedRose.getRoseItems()[9].getSellIn(), -1);
    }

    @Test
    public void conjured_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Conjured Mana Cake", gildedRose.getRoseItems()[10].getName());
        assertEquals(gildedRose.getRoseItems()[10].getQuality(), 5);
        assertEquals(gildedRose.getRoseItems()[10].getSellIn(), 2);
    }
}
