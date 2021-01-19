package com.gildedrose

import com.gildedrose.operations.AgedBrieOperation
import com.gildedrose.operations.BackStageOperation
import com.gildedrose.operations.ItemOperation
import com.gildedrose.operations.SulfurasOperation

class GildedRose(var items: Array<Item>) {
    private val operationMap = mapOf(
        ItemConstants.AGED_BRI to AgedBrieOperation(),
        ItemConstants.BACKSTAGE to BackStageOperation(),
        ItemConstants.SULFURAS to SulfurasOperation()
    )

    private val defaultOperation = ItemOperation()

    fun updateQuality() {
        for (item in items) {
            val operation = operationMap[item.name] ?: defaultOperation
            val newItem = operation.update(item)
            item.quality = newItem.quality
            item.sellIn = newItem.sellIn
        }
    }
}
