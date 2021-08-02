package com.a_ches.mygreatweatherapp.data

data class Weather(val town: String = "My Town", val temperature: Int = 10) {

    constructor(town: String, temperature: Int, preassure: Int) : this(town, temperature) {
        this.preassure = preassure
    }

    constructor(humidity: Int) : this() {

    }

    var preassure: Int = 0
        get() {
            registrator("get")
            return field
        }
        set(value) {
            registrator("before set")
            field = value
            registrator("after set", "set")
        }

    fun registrator(vararg strings: String): Unit {
        var a = if (strings[0] == "get") {
            "get"
        } else {
            "set"
        }

        if (strings[0] == "get"){
            a = "get"
        }

        val i = 10

        when(i){
            1 -> {
                TODO("1")
            }
            2 -> {
                TODO("2")
            }
            else ->{
                TODO("else")
            }
        }

        when{
            i < 10 -> {
                TODO("<10")
            }
            i == 10 -> {
                TODO("==10")
            }
            i > 10 -> {
                TODO(">10")
            }
        }

        var weather = Weather()
        when(weather){
            is Weather -> {
                TODO("weather")
            }
            else -> {
                TODO("esle")
            }
        }

        var b = when(i){
            5 -> "пять"
            6 -> "шесть"
            else -> "это другое"
        }

        for(i in 0..9){

        }

        for(i in 0 until 10){

        }

        for((index, myVar) in strings.withIndex()){

        }

        for (i in strings.indices){

        }

        for (s in strings) {

        }
    }
}


