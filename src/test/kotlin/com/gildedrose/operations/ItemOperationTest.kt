package com.gildedrose.operations

import com.gildedrose.Item
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class ItemOperationTest {
    private val operation = ItemOperation()

    @Test
    fun `Update operation gives a new item object`() {
        // GIVEN
        val item = Item("Foo", sellIn = 1, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        Assertions.assertNotEquals(newItem, item)
    }

    @Test
    fun `Quality is never negative`() {
        // GIVEN
        val item = Item("Foo", sellIn = 1, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        assertTrue(newItem.quality >= 0)
    }

    @Test
    fun `Quality is decreased as date pass`() {
        // GIVEN
        val item = Item("Foo", sellIn = 1, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        assertEquals(0, newItem.sellIn)
        assertEquals(19, newItem.quality)
    }

    @Test
    fun `Quality is degrades twice after concert`() {
        // GIVEN
        val item = Item("Foo", sellIn = 0, quality = 20)

        // WHEN
        val newItem = operation.update(item)

        // THEN
        assertEquals(-1, newItem.sellIn)
        assertEquals(18, newItem.quality)
    }
}