package com.example.dev.weatherapi;

/**
 * Created by dev on 11/9/16.
 */

public class Earthquakes {
    double magnitude;
    String Location;
    long date;
    public Earthquakes(double a, String b, long c){
        magnitude=a;
        Location=b;
        date=c;
    }
    public double getMagnitude(){return magnitude;}
    public String getLocation(){return Location;}
    public long getDate(){return date;}
}
