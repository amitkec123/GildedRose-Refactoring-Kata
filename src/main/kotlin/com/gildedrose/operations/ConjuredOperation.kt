package com.gildedrose.operations

import com.gildedrose.Item
import com.gildedrose.decrementQuality
import com.gildedrose.decrementSellIn

class ConjuredOperation: Operation {
    override fun update(item: Item): Item {
        val newItem = Item(item.name, sellIn = item.sellIn, quality = item.quality)
        newItem.decrementQuality()
        newItem.decrementQuality()

        newItem.decrementSellIn()

        return newItem
    }
}