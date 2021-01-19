package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name != ItemConstants.AGED_BRI && item.name != ItemConstants.BACKSTAGE) {
                if (item.quality > ItemConstants.MIN_QUALITY) {
                    if (item.name != ItemConstants.SULFURAS) {
                        item.decrementQuality()
                    }
                }
            } else {
                if (item.quality < ItemConstants.MAX_QUALITY) {
                    item.incrementQuality()

                    if (item.name == ItemConstants.BACKSTAGE) {
                        if (item.sellIn < 11) {
                            if (item.quality < ItemConstants.MAX_QUALITY) {
                                item.incrementQuality()
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < ItemConstants.MAX_QUALITY) {
                                item.incrementQuality()
                            }
                        }
                    }
                }
            }

            if (item.name != ItemConstants.SULFURAS) {
                item.decrementSellIn()
            }

            if (item.sellIn < 0) {
                if (item.name != ItemConstants.AGED_BRI) {
                    if (item.name != ItemConstants.BACKSTAGE) {
                        if (item.quality > ItemConstants.MIN_QUALITY) {
                            if (item.name != ItemConstants.SULFURAS) {
                                item.decrementQuality()
                            }
                        }
                    } else {
                        item.quality = ItemConstants.MIN_QUALITY
                    }
                } else {
                    if (item.quality < ItemConstants.MAX_QUALITY) {
                        item.incrementQuality()
                    }
                }
            }
        }
    }
}

