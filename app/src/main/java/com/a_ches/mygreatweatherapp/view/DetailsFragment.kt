package com.a_ches.mygreatweatherapp.view

import android.os.Build
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import android.os.Handler
import android.os.Looper




import com.a_ches.mygreatweatherapp.R
import com.a_ches.mygreatweatherapp.databinding.DetailsFragmentBinding

import com.google.gson.Gson
import okhttp3.*
//import ru.geekbrains.androidwithkotlin.BuildConfig

import com.a_ches.mygreatweatherapp.model.data.Weather
import java.io.IOException


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.a_ches.mygreatweatherapp.BuildConfig
import com.a_ches.mygreatweatherapp.model.AppState
import com.a_ches.mygreatweatherapp.model.data.City
import com.a_ches.mygreatweatherapp.model.dto.FactDTO
import com.a_ches.mygreatweatherapp.model.dto.WeatherDTO
import com.a_ches.mygreatweatherapp.viewmodel.DetailsViewModel


private const val TEMP_INVALID = -100
private const val FEELS_LIKE_INVALID = -100
private const val PROCESS_ERROR = "Обработка ошибки"
private const val REQUEST_API_KEY = "X-Yandex-API-Key"

class DetailsFragment : Fragment() {

    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var weatherBundle: Weather

    private val viewModel: DetailsViewModel by lazy {
        ViewModelProvider(this).get(DetailsViewModel::class.java)
    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onDestroyView() {
        _binding = null

        super.onDestroyView()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherBundle = arguments?.getParcelable<Weather>(BUNDLE_EXTRA) ?: Weather()
        viewModel.detailsLiveData.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.getWeatherFromRemoteSource(weatherBundle.city.lat, weatherBundle.city.lon)
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                binding.main.show()
                binding.loadingLayout.hide()
                setWeather(appState.weatherData[0])
            }
            is AppState.Loading -> {
                binding.main.hide()
                binding.loadingLayout.show()
            }
            is AppState.Error -> {
                binding.main.show()
                binding.loadingLayout.hide()
                binding.main.showSnackBar(getString(R.string.error), getString(R.string.reload)) {
                    viewModel.getWeatherFromRemoteSource(
                            weatherBundle.city.lat,
                            weatherBundle.city.lon
                    )
                }
            }
        }
    }

    private fun setWeather(weather: Weather) {
        with(binding) {
            weatherBundle.city.let { city ->
                cityName.text = city.city
                cityCoordinates.text = String.format(
                        getString(R.string.city_coordinates),
                        city.lat.toString(),
                        city.lon.toString()
                )
                saveCity(city, weather)
            }
            weather.let {
                temperatureValue.text = it.temperature.toString()
                feelsLikeValue.text = it.feelsLike.toString()
                weatherCondition.text = it.condition
            }
        }
    }

    private fun saveCity(
            city: City,
            weather: Weather
    ) {
        viewModel.saveCityToDB(
                Weather(
                        city,
                        weather.temperature,
                        weather.feelsLike,
                        weather.condition
                )
        )
    }

    companion object {
        const val BUNDLE_EXTRA = "weather"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}