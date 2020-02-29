package com.gildedrose;

public class Item {

    private String name;
    private int sell_in;
    private int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sell_in;
    }

    public int getQuality() {
        return quality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSellIn(int sell_in) {
        this.sell_in = sell_in;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void update() {
        if (!getName().equals("Aged Brie")
                && !getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (getQuality() > 0) {
                if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
                    setQuality(getQuality() - 1);
                }
            }
        } else {
            if (getQuality() < 50) {
                setQuality(getQuality() + 1);

                if (getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (getSellIn() < 11) {
                        if (getQuality() < 50) {
                            setQuality(getQuality() + 1);
                        }
                    }

                    if (getSellIn() < 6) {
                        if (getQuality() < 50) {
                            setQuality(getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
            setSellIn(getSellIn() - 1);
        }

        if (getSellIn() < 0) {
            if (!getName().equals("Aged Brie")) {
                if (!getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (getQuality() > 0) {
                        if (!getName().equals("Sulfuras, Hand of Ragnaros")) {
                            setQuality(getQuality() - 1);
                        }
                    }
                } else {
                    setQuality(0);
                }
            } else {
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
