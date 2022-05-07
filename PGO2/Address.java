package com.company;

public class Address {
    private String country;
    private String city;
    private String street;
    private int house;
    private int flat;

    public Address(String country, String city, String street, int house, int flat) {
        setCountry(country);
        setCity(city);
        setStreet(street);
        setHouse(house);
        setFlat(flat);
    }

    public void setCountry(String country) {
        if (country == null || country.isEmpty()) {
            throw new ValidationException("Name your country");
        }
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null || city.isEmpty()) {
            throw new ValidationException("City cannot be empty");
        }
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (city == null || city.isEmpty()) {
            throw new ValidationException("Street cannot be empty");
        }
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        if (house < 0 || house == 0) {
            throw new ValidationException("House number cannot be lower or equal to 0");
        }
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        if (flat < 0 || flat == 0) {
            throw new ValidationException("Flat number cannot be lower or equal to 0");
        }
        this.flat = flat;
    }
}