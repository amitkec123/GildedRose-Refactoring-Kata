package com.gildedrose.operations

import com.gildedrose.ItemConstants

object OperationFactory {
    private val operationMap = mapOf(
        ItemConstants.AGED_BRI to AgedBrieOperation(),
        ItemConstants.BACKSTAGE to BackStageOperation(),
        ItemConstants.SULFURAS to SulfurasOperation(),
        ItemConstants.CONJURED to ConjuredOperation()
    )

    private val defaultOperation = ItemOperation()

    fun getOperationForItem(name: String): Operation {
        return operationMap[name] ?: defaultOperation
    }
}