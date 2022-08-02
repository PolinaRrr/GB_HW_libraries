package com.example.gb_hw_libraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gb_hw_libraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),MainView {
    lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CounterPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPresenter()
        with(binding) {
            button01.setOnClickListener {
                presenter.onCounterClick(0)
            }
            button02.setOnClickListener {
               presenter.onCounterClick(1)
            }
            button03.setOnClickListener {
                presenter.onCounterClick(2)
            }
        }

    }
    private fun initPresenter() {
        presenter = CounterPresenter(this,model = CounterModel())
    }


    override fun setText(counter: String,index:Int) {
        with(binding){
            when(index){
                0->{button01.text = counter}
                1->{button02.text = counter}
                2->{button03.text = counter}
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
        presenter.getCurrentCounter().let { list->
            list.clear()
            array?.toList()?.let {
                list.addAll(it)
            }
        }
        for (i in 0 until presenter.getCurrentCounter().size){
            with(binding){
                setText(presenter.getCurrentCounter()[i].toString(),i)
            }
        }
    }
}