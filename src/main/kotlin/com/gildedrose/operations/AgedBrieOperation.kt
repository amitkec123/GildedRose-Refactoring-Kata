package com.gildedrose.operations

import com.gildedrose.Item
import com.gildedrose.decrementSellIn
import com.gildedrose.incrementQuality

class AgedBrieOperation: Operation {
    override fun update(item: Item): Item {
        val newItem = Item(item.name, sellIn = item.sellIn, quality = item.quality)
        newItem.incrementQuality()
        newItem.decrementSellIn()
        if (newItem.sellIn < 0) {
            newItem.incrementQuality()
        }
        return newItem
    }
}