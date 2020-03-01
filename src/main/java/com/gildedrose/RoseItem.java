package com.gildedrose;

public abstract class RoseItem {
    private String name;
    private int sell_in;
    private int quality;

    public RoseItem(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sell_in;
    }

    public void setSellIn(int sell_in) {
        this.sell_in = sell_in;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public abstract void update();
}
