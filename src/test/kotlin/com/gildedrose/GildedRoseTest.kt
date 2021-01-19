package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GildedRoseTest {
    lateinit var gildedRose: GildedRose

    @Test
    fun `Quality and sellIn are decreased every day`() {
        givenItemDetails("foo", 20, 15)
        whenUpdateQuality()
        thenIsSameAsItem("foo", 19, 14)
    }

    @Test
    fun `Quality degrades twice as fast once sellIn date has passed`() {
        givenItemDetails("foo", 0, 20)
        whenUpdateQuality()
        thenIsSameAsItem("foo", -1, 18)
    }

    @Test
    fun `Quality is never negative`() {
        givenItemDetails("foo", 20, 0)
        whenUpdateQuality()
        thenIsSameAsItem("foo", 19, 0)
    }

    @Test
    fun `Aged Brie increases the quality the older it gets`() {
        givenItemDetails(ItemConstants.AGED_BRI, 20, 20)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.AGED_BRI, 19, 21)
    }

    @Test
    fun `Quality is never more than 50`() {
        givenItemDetails(ItemConstants.AGED_BRI, 20, 50)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.AGED_BRI, 19, 50)
    }

    @Test
    fun `Quality is never more than 50 with BackStage`() {
        givenItemDetails(ItemConstants.BACKSTAGE, 3, 49)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.BACKSTAGE, 2, 50)
    }

    @Test
    fun `Sulfuras never has to be sold or decreases in Quality`() {
        givenItemDetails(ItemConstants.SULFURAS, 20, 50)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.SULFURAS, 20, 50)
    }

    @Test
    fun `Backstage passes increases in Quality by 2 as its SellIn value is 10 days`() {
        givenItemDetails(ItemConstants.BACKSTAGE, 10, 20)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.BACKSTAGE, 9, 22)
    }

    @Test
    fun `Backstage passes increases in Quality by 2 as its SellIn value is 6 days`() {
        givenItemDetails(ItemConstants.BACKSTAGE, 6, 20)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.BACKSTAGE, 5, 22)
    }

    @Test
    fun `Backstage passes increases in Quality by 3 as its SellIn value is 5 days`() {
        givenItemDetails(ItemConstants.BACKSTAGE, 5, 20)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.BACKSTAGE, 4, 23)
    }

    @Test
    fun `Backstage passes increases in Quality by 3 as its SellIn value is 1 day`() {
        givenItemDetails(ItemConstants.BACKSTAGE, 1, 20)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.BACKSTAGE, 0, 23)
    }

    @Test
    fun `Backstage passes drops to zero after the concert`() {
        givenItemDetails(ItemConstants.BACKSTAGE, 0, 20)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.BACKSTAGE, -1, 0)
    }

    @Test
    fun `Conjured degrades in quality twice as normal`() {
        givenItemDetails(ItemConstants.CONJURED, 20, 20)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.CONJURED, 19, 18)
    }

    @Test
    fun `Conjured degrades in quality and is never negative`() {
        givenItemDetails(ItemConstants.CONJURED, 20, 1)
        whenUpdateQuality()
        thenIsSameAsItem(ItemConstants.CONJURED, 19, 0)
    }

    private fun givenItemDetails(name: String, sellIn: Int, quality: Int) {
        gildedRose = GildedRose(arrayOf(Item(name = name, sellIn = sellIn, quality = quality)))
    }

    private fun whenUpdateQuality() {
        gildedRose.updateQuality()
    }

    private fun thenIsSameAsItem(name: String, sellIn: Int, quality: Int) {
        val item = gildedRose.items[0]
        assertEquals(name, item.name)
        assertEquals(sellIn, item.sellIn)
        assertEquals(quality, item.quality)
    }
}


