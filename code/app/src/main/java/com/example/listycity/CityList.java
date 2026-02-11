package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list fi the city does not exist.
     * @param city
     *      This is a candidate city to add
     *
     */
    public void add (City city){
        if (cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities.
     * @return
     *      Return sorted list
     */
    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns whether or not a given city is in the list
     * @param city
     *      This is the city to be checked if it is in the CityList
     * @return
     *      Returns whether the city is in the CityList (true if it is, false if it is not)
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * This removes a given city from CityList.
     * @param city
     *      This is the candidate city to remove.
     */
    public void deleteCity(City city){
        if (cities.contains(city)){
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns the size of a CityList.
     * @return
     *      Returns an integer representing the CityList's size.
     */
    public int countCities(){
        return cities.size();
    }

}
