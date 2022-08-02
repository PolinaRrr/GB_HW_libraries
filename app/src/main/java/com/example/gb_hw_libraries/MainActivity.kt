package com.example.gb_hw_libraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gb_hw_libraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val counter = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayCounterValue()
        with(binding) {
            button01.setOnClickListener {
                button01.text = increaseCounter(0).toString()
            }
            button02.setOnClickListener {
                button01.text = increaseCounter(1).toString()
            }
            button03.setOnClickListener {
                button01.text = increaseCounter(2).toString()
            }
        }

    }

    private fun increaseCounter(position: Int) {
        ++counter[position]
    }

    private fun displayCounterValue() {
        with(binding) {
            button01.text = counter[0].toString()
            button02.text = counter[1].toString()
            button03.text = counter[2].toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(KEY_COUNTERS, counter.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val array = savedInstanceState.getIntArray(KEY_COUNTERS)
        counter.let { list->
            list.clear()
            array?.toList()?.let {
                list.addAll(it)
            }
        }
    }
}