package com.gildedrose.operations

import com.gildedrose.Item
import com.gildedrose.decrementQuality
import com.gildedrose.decrementSellIn

class ItemOperation: Operation {
    override fun update(item: Item): Item {
        val newItem = Item(item.name, sellIn = item.sellIn, quality = item.quality)
        newItem.decrementQuality()

        newItem.decrementSellIn()

        if (newItem.sellIn < 0) {
            newItem.decrementQuality()
        }
        return newItem
    }

}