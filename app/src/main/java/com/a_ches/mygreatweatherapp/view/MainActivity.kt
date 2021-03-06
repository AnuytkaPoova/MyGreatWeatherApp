package com.a_ches.mygreatweatherapp.view

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import android.view.Menu
import android.view.MenuItem
import androidx.viewbinding.BuildConfig
import com.a_ches.mygreatweatherapp.R
import com.a_ches.mygreatweatherapp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.chip1.text = BuildConfig.
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(binding.container.id, MainFragment.newInstance())
                    .commitNow()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_history -> {
                supportFragmentManager.apply {
                    beginTransaction()
                            .add(R.id.container, HistoryFragment.newInstance())
                            .addToBackStack("")
                            .commitAllowingStateLoss()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}