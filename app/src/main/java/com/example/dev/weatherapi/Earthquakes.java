package com.example.dev.weatherapi;

/**
 * Created by dev on 11/9/16.
 */

public class Earthquakes {
    double magnitude;
    String Location;
    long date;
    double latitude;
    double longitude;
    public Earthquakes(double a, String b, long c,double d,double e){
        magnitude=a;
        Location=b;
        date=c;
        latitude=d;
        longitude=e;
    }
    public double getMagnitude(){return magnitude;}
    public String getLocation(){return Location;}
    public long getDate(){return date;}
    public double getLat(){return latitude;}
    public double getLong(){return longitude;}
}
