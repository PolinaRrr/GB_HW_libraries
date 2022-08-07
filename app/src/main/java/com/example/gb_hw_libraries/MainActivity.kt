package com.example.gb_hw_libraries

import android.os.Bundle
import com.example.gb_hw_libraries.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { CounterPresenter(CounterModel()) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initPresenter()
        with(binding) {
            button01.setOnClickListener {
                presenter.onFirstCounterClick(KEY_INDEX_BTN_01)
            }
            button02.setOnClickListener {
                presenter.onSecondCounterClick(KEY_INDEX_BTN_02)
            }
            button03.setOnClickListener {
                presenter.onThirdCounterClick(KEY_INDEX_BTN_03)
            }
        }

    }


    private fun setText(counter: String, index: Int) {
        with(binding) {
            when (index) {
                KEY_INDEX_BTN_01 -> {
                    button01.text = counter
                }
                KEY_INDEX_BTN_02 -> {
                    button02.text = counter
                }
                KEY_INDEX_BTN_03 -> {
                    button03.text = counter
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(KEY_COUNTERS, presenter.getCurrentCounter().toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val array = savedInstanceState.getIntArray(KEY_COUNTERS)
        presenter.getCurrentCounter().let { list ->
            list.clear()
            array?.toList()?.let {
                list.addAll(it)
            }
        }
        for (i in 0 until presenter.getCurrentCounter().size) {
            with(binding) {
                setText(presenter.getCurrentCounter()[i].toString(), i)
            }
        }

    }

    override fun setFirstText(counter: String, index: Int) = with(binding) {
        button01.text = counter

    }

    override fun setSecondText(counter: String, index: Int) = with(binding) {
        button02.text = counter

    }

    override fun setThirdText(counter: String, index: Int) = with(binding) {
        button03.text = counter

    }
}