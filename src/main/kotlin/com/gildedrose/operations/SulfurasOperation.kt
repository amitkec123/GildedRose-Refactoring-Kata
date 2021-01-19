package com.gildedrose.operations

import com.gildedrose.Item

class SulfurasOperation: Operation {
    override fun update(item: Item): Item {
        return Item(item.name, sellIn = item.sellIn, quality = item.quality)
    }
}