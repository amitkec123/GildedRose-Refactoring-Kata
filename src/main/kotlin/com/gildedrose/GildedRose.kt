package com.gildedrose

import com.gildedrose.operations.OperationFactory

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            val operation = OperationFactory.getOperationForItem(item.name)
            val newItem = operation.update(item)
            item.quality = newItem.quality
            item.sellIn = newItem.sellIn
        }
    }
}
