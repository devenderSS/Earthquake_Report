package com.example.dev.weatherapi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dev on 11/9/16.
 */

public class QueryUtils {
    public QueryUtils(){

    }
    public static ArrayList<Earthquakes> extractData(String url)
    {
        ArrayList<Earthquakes> earthquakes = new ArrayList<>();
        JSONObject rootobject;
        JSONArray featureArrray;
        try{
        rootobject = new JSONObject(url);
            featureArrray = rootobject.getJSONArray("features");
            for(int i=0;i<featureArrray.length();i++){
                JSONObject innerObj = featureArrray.getJSONObject(i);
                JSONObject propobject = innerObj.getJSONObject("properties");
                JSONObject geoObj = innerObj.getJSONObject("geometry");
                JSONArray coor = geoObj.getJSONArray("coordinates");
                double latitude = coor.getDouble(1);
                double longitude = coor.getDouble(0);
                double mag =propobject.getDouble("mag");
                long time = propobject.getLong("time");
                String place = propobject.getString("place");
                earthquakes.add(new Earthquakes(mag,place,time,latitude,longitude));

            }
        }
        catch (JSONException joe){
            return null;
        }
        finally {
            return earthquakes;
        }

    }
}
