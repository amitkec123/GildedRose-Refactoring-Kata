package com.gildedrose.operations

import com.gildedrose.Item

interface Operation {
    fun update(item: Item): Item
}