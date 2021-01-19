package com.gildedrose.operations

import com.gildedrose.Item
import com.gildedrose.ItemConstants
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AgedBrieOperationTest {
    private val operation = AgedBrieOperation()

    @Test
    fun `Update operation gives a new item object`() {
        // GIVEN
        val item = Item(ItemConstants.AGED_BRI, sellIn = 1, quality = 0)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        assertNotEquals(newItem, item)
    }

    @Test
    fun `Quality is never negative`() {
        // GIVEN
        val item = Item(ItemConstants.AGED_BRI, sellIn = 1, quality = 0)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        assertTrue(newItem.quality >= 0)
    }

    @Test
    fun `Quality increases as older it's gets`() {
        // GIVEN
        val item = Item(ItemConstants.AGED_BRI, sellIn = 20, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        assertEquals(19, newItem.sellIn)
        assertEquals(21, newItem.quality)
    }
}