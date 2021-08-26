package com.a_ches.mygreatweatherapp.app

import android.app.Application
import androidx.room.Room
import com.a_ches.mygreatweatherapp.room.HistoryDao
import com.a_ches.mygreatweatherapp.room.HistoryDataBase

import java.lang.IllegalStateException

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: App? = null
        private var db: HistoryDataBase? = null
        private const val DB_NAME = "History.db"

        fun getHistoryDao(): HistoryDao {
            if (db == null) {
                synchronized(HistoryDataBase::class.java) {
                    if (db == null) {
                        if (appInstance == null) {
                            throw IllegalStateException("Application ids null meanwhile creating database")
                        }
                        db = Room.databaseBuilder(
                                appInstance!!.applicationContext,
                                HistoryDataBase::class.java,
                                DB_NAME)
                                .allowMainThreadQueries()
                                .build()
                    }
                }
            }
            return db!!.historyDao()
        }
    }
}