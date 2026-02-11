package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // checks if the first city in cityList is the same as city returned by mockCity

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // pushes down the original city

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCities(){
        CityList cityList = mockCityList();
        City city = new City("Hello", "Kitty");

        assertEquals(false, cityList.hasCity(city));
        // check if it correctly returns false when cityList does not have the city

        cityList.add(city);
        assertEquals(true, cityList.hasCity(city));

    }

    @Test
    void testDelete(){
        CityList cityList = mockCityList();
        cityList.deleteCity(cityList.getCities().get(0));
        assertEquals(0, cityList.getCities().size());
        //check if it deletes a city from the list


        City city = new City("Keroppi", "Sanrio");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
        //check if deleteCity throws illegal arg exception

    }

    @Test
    void testCountCities(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
    }
}
