package com.a_ches.mygreatweatherapp.data;

public class WeatherJava {
    private String town;
    private int temperature;

    public WeatherJava(String town, int temperature) {
        this.town = town;
        this.temperature = temperature;
    }

    public String getTown() {
        return town;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
