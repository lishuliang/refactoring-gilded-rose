package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private RoseItem[] roseItems;

    public GildedRose(RoseItem[] roseItems) {
        this.roseItems = roseItems;
    }

    public RoseItem[] getRoseItems() {
        return roseItems;
    }

    public void update_quality() {
        Arrays.stream(getRoseItems()).forEach(RoseItem::update);
    }
}
