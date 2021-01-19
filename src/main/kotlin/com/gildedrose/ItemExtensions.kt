package com.gildedrose

fun Item.decrementQuality() {
    quality -= 1
}

fun Item.incrementQuality() {
    quality += 1
}

fun Item.decrementSellIn() {
    sellIn -= 1
}