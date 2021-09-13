package com.a_ches.mygreatweatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a_ches.mygreatweatherapp.app.App.Companion.getHistoryDao
import com.a_ches.mygreatweatherapp.model.AppState
import com.a_ches.mygreatweatherapp.model.repository.LocalRepository
import com.a_ches.mygreatweatherapp.model.repository.LocalRepositoryImpl

class HistoryViewModel(
        val historyLiveData: MutableLiveData<AppState> = MutableLiveData(),
        private val historyRepository: LocalRepository = LocalRepositoryImpl(getHistoryDao())
) : ViewModel() {

    fun getAllHistory(){
        historyLiveData.value = AppState.Loading
        historyLiveData.value = AppState.Success(historyRepository.getAllHistory())
    }
}