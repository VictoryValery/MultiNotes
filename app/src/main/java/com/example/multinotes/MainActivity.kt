package com.example.multinotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multinotes.databinding.ActivityMainContainerBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}