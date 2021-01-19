package com.gildedrose.operations

import com.gildedrose.Item
import com.gildedrose.ItemConstants
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BackStageOperationTest {
    private val operation = BackStageOperation()

    @Test
    fun `Update operation gives a new item object`() {
        // GIVEN
        val item = Item(ItemConstants.BACKSTAGE, sellIn = 1, quality = 0)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertNotEquals(newItem, item)
    }

    @Test
    fun `Quality is never negative`() {
        // GIVEN
        val item = Item(ItemConstants.BACKSTAGE, sellIn = 1, quality = 0)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertTrue(newItem.quality >= 0)
    }

    @Test
    fun `Quality increases as older it's gets`() {
        // GIVEN
        val item = Item(ItemConstants.BACKSTAGE, sellIn = 20, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertEquals(19, newItem.sellIn)
        Assertions.assertEquals(21, newItem.quality)
    }

    @Test
    fun `Quality increases as two times if day is below 11`() {
        // GIVEN
        val item = Item(ItemConstants.BACKSTAGE, sellIn = 10, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertEquals(9, newItem.sellIn)
        Assertions.assertEquals(22, newItem.quality)
    }

    @Test
    fun `Quality increases as three times if day is below 6`() {
        // GIVEN
        val item = Item(ItemConstants.BACKSTAGE, sellIn = 5, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertEquals(4, newItem.sellIn)
        Assertions.assertEquals(23, newItem.quality)
    }

    @Test
    fun `Quality drops to 0 after concert`() {
        // GIVEN
        val item = Item(ItemConstants.BACKSTAGE, sellIn = -1, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertEquals(-2, newItem.sellIn)
        Assertions.assertEquals(0, newItem.quality)
    }
}