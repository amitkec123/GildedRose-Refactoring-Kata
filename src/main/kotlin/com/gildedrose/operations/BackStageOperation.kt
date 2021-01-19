package com.gildedrose.operations

import com.gildedrose.Item
import com.gildedrose.decrementSellIn
import com.gildedrose.incrementQuality

class BackStageOperation : Operation {
    override fun update(item: Item): Item {
        val newItem = Item(item.name, sellIn = item.sellIn, quality = item.quality)
        newItem.incrementQuality()
        updateDynamicQuality(newItem)

        newItem.decrementSellIn()

        if (newItem.sellIn < 0) {
            newItem.quality = 0
        }
        return newItem
    }

    private fun updateDynamicQuality(item: Item) {
        if (item.sellIn < QUALITY_INCREMENT_DAY_11) {
            item.incrementQuality()
        }

        if (item.sellIn < QUALITY_INCREMENT_DAY_6) {
            item.incrementQuality()
        }

    }

    companion object {
        const val QUALITY_INCREMENT_DAY_11 = 11
        const val QUALITY_INCREMENT_DAY_6 = 6
    }
}