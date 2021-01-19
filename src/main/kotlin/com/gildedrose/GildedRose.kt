package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            updateQuality(item)
            updateSellIn(item)
            updateQualityIfSellInIsNegative(item)
        }
    }

    private fun updateSellIn(item: Item) {
        if (item.name != ItemConstants.SULFURAS) {
            item.decrementSellIn()
        }
    }

    private fun updateQuality(item: Item) {
        when {
            item.name == ItemConstants.AGED_BRI -> {
                item.incrementQuality()
            }
            item.name == ItemConstants.BACKSTAGE -> {
                item.incrementQuality()
                updateBackStageQuality(item)
            }
            item.name != ItemConstants.SULFURAS -> {
                item.decrementQuality()
            }
        }
    }

    private fun updateQualityIfSellInIsNegative(item: Item) {
        if (item.sellIn >= 0) {
            return
        }
        when {
            item.name == ItemConstants.AGED_BRI -> {
                item.incrementQuality()
            }
            item.name == ItemConstants.BACKSTAGE -> {
                item.quality = ItemConstants.MIN_QUALITY
            }
            item.name != ItemConstants.SULFURAS -> {
                item.decrementQuality()
            }
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

