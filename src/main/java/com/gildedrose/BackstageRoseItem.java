package com.gildedrose;

public class BackstageRoseItem extends RoseItem {
    public BackstageRoseItem(String name, int sell_in, int quality) {
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
        if (this.getSellIn() < 11 && this.getQuality() < 50) {
            setQuality(this.getQuality() + 1);
        }
        if (this.getSellIn() < 6 && this.getQuality() < 50) {
            setQuality(this.getQuality() + 1);
        }
        if (this.getSellIn() < 0) {
            setQuality(0);
        }
    }

    private void updateSellIn() {
        this.setSellIn(this.getSellIn() - 1);
    }
}
