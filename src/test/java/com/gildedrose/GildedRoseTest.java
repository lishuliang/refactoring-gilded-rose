package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    private GildedRose gildedRose;

    @Before
    public void setUp() throws Exception {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        gildedRose = new GildedRose(items);
    }

    @Test
    public void dexterity_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("+5 Dexterity Vest", gildedRose.getItems()[0].getName());
        assertEquals(gildedRose.getItems()[0].getQuality(), 19);
        assertEquals(gildedRose.getItems()[0].getSellIn(), 9);
    }

    @Test
    public void aged_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Aged Brie", gildedRose.getItems()[1].getName());
        assertEquals(gildedRose.getItems()[1].getQuality(), 1);
        assertEquals(gildedRose.getItems()[1].getSellIn(), 1);
    }

    @Test
    public void elixir_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Elixir of the Mongoose", gildedRose.getItems()[2].getName());
        assertEquals(gildedRose.getItems()[2].getQuality(), 6);
        assertEquals(gildedRose.getItems()[2].getSellIn(), 4);
    }

    @Test
    public void sulfuras_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.getItems()[3].getName());
        assertEquals(gildedRose.getItems()[3].getQuality(), 80);
        assertEquals(gildedRose.getItems()[3].getSellIn(), 0);
    }

    @Test
    public void backstage_item_when_sellin_is_15_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getItems()[5].getName());
        assertEquals(gildedRose.getItems()[5].getQuality(), 21);
        assertEquals(gildedRose.getItems()[5].getSellIn(), 14);
    }

    @Test
    public void backstage_item_when_sellin_is_10_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getItems()[6].getName());
        assertEquals(gildedRose.getItems()[6].getQuality(), 50);
        assertEquals(gildedRose.getItems()[6].getSellIn(), 9);
    }

    @Test
    public void backstage_item_when_sellin_is_5_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getItems()[7].getName());
        assertEquals(gildedRose.getItems()[7].getQuality(), 50);
        assertEquals(gildedRose.getItems()[7].getSellIn(), 4);
    }

    @Test
    public void backstage_item_when_sellin_is_1_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getItems()[8].getName());
        assertEquals(gildedRose.getItems()[8].getQuality(), 23);
        assertEquals(gildedRose.getItems()[8].getSellIn(), 0);
    }

    @Test
    public void backstage_item_when_sellin_is_0_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.getItems()[9].getName());
        assertEquals(gildedRose.getItems()[9].getQuality(), 0);
        assertEquals(gildedRose.getItems()[9].getSellIn(), -1);
    }

    @Test
    public void conjured_item_after_1_day() {
        gildedRose.update_quality();
        assertEquals("Conjured Mana Cake", gildedRose.getItems()[10].getName());
        assertEquals(gildedRose.getItems()[10].getQuality(), 5);
        assertEquals(gildedRose.getItems()[10].getSellIn(), 2);
    }
}
