package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == ItemConstants.AGED_BRI) {
                item.incrementQuality()
            } else if (item.name == ItemConstants.BACKSTAGE) {
                item.incrementQuality()
                updateBackStageQuality(item)
            } else if (item.name != ItemConstants.SULFURAS) {
                item.decrementQuality()
            }

            if (item.name != ItemConstants.SULFURAS) {
                item.decrementSellIn()
            }

            if (item.sellIn < 0) {
                updateQualityIfSellInIsNegative(item)
            }
        }
    }

    private fun updateQualityIfSellInIsNegative(item: Item) {
        if (item.name == ItemConstants.AGED_BRI) {
            if (item.quality < ItemConstants.MAX_QUALITY) {
                item.incrementQuality()
            }
        } else if (item.name == ItemConstants.BACKSTAGE) {
            item.quality = ItemConstants.MIN_QUALITY
        } else if (item.name != ItemConstants.SULFURAS) {
            item.decrementQuality()
        }
    }

    private fun updateBackStageQuality(item: Item) {
        if (item.sellIn < 11) {
            item.incrementQuality()
        }

        if (item.sellIn < 6) {
            item.incrementQuality()
        }
    }
}

