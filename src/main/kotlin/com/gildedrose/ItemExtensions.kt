package com.gildedrose

fun Item.decrementQuality() {
    if (quality > ItemConstants.MIN_QUALITY) {
        quality -= 1
    }
}

fun Item.incrementQuality() {
    if (quality < ItemConstants.MAX_QUALITY) {
        quality += 1
    }
}

fun Item.decrementSellIn() {
    sellIn -= 1
}