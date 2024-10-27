package com.gildedrose;

class SellIn {
    private int days;

    public SellIn(int days) {
        this.days = days;
    }

    public void decrease() {
        days -= 1;
    }

    public boolean isExpired() {
        return days < 0;
    }

    public boolean isBelow(int threshold) {
        return days < threshold;
    }

    @Override
    public String toString() {
        return String.valueOf(days);
    }
}
