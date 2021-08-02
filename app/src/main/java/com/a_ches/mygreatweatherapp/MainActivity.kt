package com.a_ches.mygreatweatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.a_ches.mygreatweatherapp.repository.getRepository

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerWeather: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerWeather = findViewById(R.id.recyclerWeather)
        val adapter = WeatherAdapter.getInstance(getRepository())
        recyclerWeather.adapter = adapter

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(
                    this@MainActivity,
                    "Нажата кнопка",
                    Toast.LENGTH_SHORT
            ).show()
        }
    }
}