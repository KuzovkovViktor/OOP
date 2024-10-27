package com.gildedrose;

class Quality {
    private int quality;

    public Quality(int quality) {
        this.quality = Math.max(0, Math.min(quality, 50));
    }

    public void increase() {
        if (quality < 50) {
            quality += 1;
        }
    }

    public void decrease() {
        if (quality > 0) {
            quality -= 1;
        }
    }

    public void reset() {
        quality = 0;
    }

    @Override
    public String toString() {
        return String.valueOf(quality);
    }
}
