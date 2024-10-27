package com.gildedrose;

class Name {
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public boolean isEqualTo(String otherName) {
        return name.equals(otherName);
    }

    @Override
    public String toString() {
        return name;
    }
}
