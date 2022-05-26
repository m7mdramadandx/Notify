package com.ramadan.notify.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
