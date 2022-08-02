package com.example.gb_hw_libraries


class CounterPresenter(
    private val view: MainView,
    private val model: CounterModel
) {

    fun onCounterClick(index: Int) {
        model.changeValue(index, model.getUpdatedValue(index))
        view.setText(model.getCurrent(index).toString(), index)
    }

    fun getCurrentCounter(): MutableList<Int> {
        return model.getCounter()
    }
}