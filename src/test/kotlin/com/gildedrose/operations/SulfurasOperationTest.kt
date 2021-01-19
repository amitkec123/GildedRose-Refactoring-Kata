package com.gildedrose.operations

import com.gildedrose.Item
import com.gildedrose.ItemConstants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class SulfurasOperationTest {
    private val operation = SulfurasOperation()

    @Test
    fun `Update operation gives a new item object`() {
        // GIVEN
        val item = Item(ItemConstants.SULFURAS, sellIn = 10, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        assertNotEquals(operation.update(item), item)
    }

    @Test
    fun `Quality always remains same`() {
        // GIVEN
        val item = Item(ItemConstants.SULFURAS, sellIn = 10, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        assertEquals(newItem.quality, item.quality)
    }

    @Test
    fun `SellIn always remains same`() {
        // GIVEN
        val item = Item(ItemConstants.SULFURAS, sellIn = 10, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        assertEquals(newItem.sellIn, item.sellIn)
    }

}