package com.example.gb_hw_libraries

class CounterModel {
    private val counter = mutableListOf(0, 0, 0)

    fun getCounter(): MutableList<Int>{
        return counter
    }

     fun getCurrent(position: Int): Int {
        return counter[position]
    }

     fun getUpdatedValue(position: Int): Int {
        return (counter[position] + 1)
    }

     fun changeValue(position: Int,value:Int){
        counter[position] = value
    }

}