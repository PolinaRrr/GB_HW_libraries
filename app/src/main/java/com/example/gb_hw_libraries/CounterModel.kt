package com.example.gb_hw_libraries

class CounterModel {
    private val counter = mutableListOf(KEY_ZERO, KEY_ZERO, KEY_ZERO)

    fun getCounter(): MutableList<Int> {
        return counter
    }

    fun getCurrent(position: Int): Int {
        return counter[position]
    }

    fun getUpdatedValue(position: Int): Int {
        return (counter[position] + 1)
    }

    fun changeValue(position: Int, value: Int) {
        counter[position] = value
    }

}