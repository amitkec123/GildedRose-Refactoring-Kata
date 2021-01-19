package com.gildedrose.operations

import com.gildedrose.Item
import com.gildedrose.ItemConstants
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConjuredOperationTest {
    private val operation = ConjuredOperation()

    @Test
    fun `Update operation gives a new item object`() {
        // GIVEN
        val item = Item(ItemConstants.CONJURED, sellIn = 1, quality = 0)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertNotEquals(newItem, item)
    }

    @Test
    fun `Quality is never negative`() {
        // GIVEN
        val item = Item(ItemConstants.CONJURED, sellIn = 1, quality = 0)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertTrue(newItem.quality >= 0)
    }


    @Test
    fun `Quality is degrades twice`() {
        // GIVEN
        val item = Item(ItemConstants.CONJURED, sellIn = 2, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertEquals(1, newItem.sellIn)
        Assertions.assertEquals(18, newItem.quality)
    }
}