package com.a_ches.mygreatweatherapp.view

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.a_ches.mygreatweatherapp.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(binding.container.id, MainFragment.newInstance())
                    .commitNow()
        }
    }
}