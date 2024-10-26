package com.gildedrose;

class SellIn {
    private int days;

    public SellIn(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void decrease() {
        days -= 1;
    }

    public boolean isExpired() {
        return days < 0;
    }
}
