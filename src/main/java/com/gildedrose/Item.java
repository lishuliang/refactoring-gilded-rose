package com.gildedrose;

public class Item {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
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

    /*public void update() {
        if (!name.equals(AGED_BRIE)
                && !name.equals(BACKSTAGE_PASSES)) {
            if (getQuality() > 0) {
                if (!name.equals(SULFURAS)) {
                    setQuality(getQuality() - 1);
                }
            }
        } else {
            if (getQuality() < 50) {
                setQuality(getQuality() + 1);

                if (name.equals(BACKSTAGE_PASSES)) {
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

        if (!name.equals(SULFURAS)) {
            setSellIn(getSellIn() - 1);
        }

        if (getSellIn() < 0) {
            if (!name.equals(AGED_BRIE)) {
                if (!name.equals(BACKSTAGE_PASSES)) {
                    if (getQuality() > 0) {
                        if (!name.equals(SULFURAS)) {
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
    }*/

    public void update() {
        switch (this.name) {
            case AGED_BRIE:
                updateAgedItem();
                break;
            case BACKSTAGE_PASSES:
                updateBackstageItem();
                break;
            case SULFURAS:
                updateSulfuras();
                break;
            default:
                updateNormalItem();
                break;
        }
    }

    public void updateNormalItem() {
        if (this.quality > 0) {
            setQuality(this.quality - 1);
        }
        if (this.sell_in < 0 && this.quality > 0) {
            setQuality(this.quality - 1);
        }
        setSellIn(this.sell_in - 1);
    }

    public void updateAgedItem() {
        if (this.quality < 50) {
            setQuality(this.quality + 1);
        }
        setSellIn(this.sell_in - 1);
    }

    public void updateBackstageItem() {
        if (this.quality < 50) {
            setQuality(this.quality + 1);
        }
        if (this.sell_in < 11 && this.quality < 50) {
            setQuality(this.quality + 1);
        }
        if (this.sell_in < 6 && this.quality < 50) {
            setQuality(this.quality + 1);
        }
        setSellIn(this.sell_in - 1);
        if (this.sell_in < 0) {
            setQuality(0);
        }
    }

    public void updateSulfuras() { //quality sell_in都不会改变

    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
