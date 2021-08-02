package com.a_ches.mygreatweatherapp.repository

import com.a_ches.mygreatweatherapp.data.Weather


open class Repository : IRepository {
    //: IRepository - имплементация


    private val weathers: List<Weather>
    init {
        val weather = Weather(temperature = 20, town = "City")

        val weather2 = weather.copy()

        val (a, b) = weather2

        val weather3 = Weather(a, b)

        weathers = listOf(
                Weather("Москва", 25),
                Weather("Санкт-Петербург", 20),
                Weather("Самара", 23),
                Weather("Новосибирск", 15),
                weather,
                weather2,
                weather3
        )
    }

    override fun getWeathers(): List<Weather> {
        return weathers
    }
    //fun  size() = weathers.size
    //или
    //fun  size(): Int{ return weathers.size}
 }
 interface IRepository {
    fun getWeathers(): List<Weather> // интерфейс эьл контракт (лучшее обьяснение)
    //функция getWeathers будет возврашать список List<Weather
}

object RepositorySingle : IRepository{
    // или
    //object RepositorySingle : Repository()

    private val weathers: List<Weather> = listOf(
            Weather("Москва", 25),
            Weather("Санкт-Петербург", 20),
            Weather("Самара", 23),
            Weather("Новосибирск", 15),
            Weather(),
            Weather("Магадан")


    )


    override fun getWeathers(): List<Weather> {
        return weathers
    }

}
inline fun getRepository(): IRepository{
    return Repository()
}




