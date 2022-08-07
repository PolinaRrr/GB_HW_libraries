package com.example.gb_hw_libraries

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun setFirstText(counter: String, index: Int)

    fun setSecondText(counter: String, index: Int)

    fun setThirdText(counter: String, index: Int)
}