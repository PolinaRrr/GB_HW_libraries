package com.example.gb_hw_libraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gb_hw_libraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}