package com.example.gb_hw_libraries

import moxy.MvpPresenter

class CounterPresenter(
    private val model: CounterModel
) : MvpPresenter<MainView>() {

    fun onFirstCounterClick(index: Int) {
        model.changeValue(index, model.getUpdatedValue(index))
        viewState.setFirstText(model.getCurrent(index).toString(), index)
    }

    fun onSecondCounterClick(index: Int) {
        model.changeValue(index, model.getUpdatedValue(index))
        viewState.setSecondText(model.getCurrent(index).toString(), index)
    }

    fun onThirdCounterClick(index: Int) {
        model.changeValue(index, model.getUpdatedValue(index))
        viewState.setThirdText(model.getCurrent(index).toString(), index)
    }

    fun getCurrentCounter(): MutableList<Int> {
        return model.getCounter()
    }
}