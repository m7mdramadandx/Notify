package com.ramadan.notify.domain.util

sealed class ItemOrder(val orderType: OrderType) {

    class Title(orderType: OrderType) : ItemOrder(orderType)
    class Date(orderType: OrderType) : ItemOrder(orderType)

    fun copy(orderType: OrderType): ItemOrder {
        return when (this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
        }
    }
}
