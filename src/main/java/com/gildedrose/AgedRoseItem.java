package com.gildedrose;

public class AgedRoseItem extends RoseItem {
    public AgedRoseItem(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void update() {
        updateSellIn();
        updateQuality();
    }

    private void updateQuality() {
        if (this.getQuality() < 50) {
            setQuality(this.getQuality() + 1);
        }
    }

    private void updateSellIn() {
        this.setSellIn(this.getSellIn() - 1);
    }
}
