package com.gildedrose;

public class NormalRoseItem extends RoseItem {
    public NormalRoseItem(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void update() {
        updateSellIn();
        updateQuality();
    }

    private void updateQuality() {
        if (this.getQuality() > 0) {
            setQuality(this.getQuality() - 1);
        }
        if (this.getSellIn() < 0 && this.getQuality() > 0) {
            setQuality(this.getQuality() - 1);
        }
    }

    private void updateSellIn() {
        this.setSellIn(this.getSellIn() - 1);
    }
}
