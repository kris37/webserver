package com.qyer.javaapi.rest.entity;

import java.io.Serializable;

/**
 * Created by panqiang on 2017/5/16.
 */
public class City implements Serializable{
    private static final long serialVersionUID = 8310721802036622337L;
    private int id;
    private String country;
    private String province;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        if (id != city1.id) return false;
        if (country != null ? !country.equals(city1.country) : city1.country != null) return false;
        if (province != null ? !province.equals(city1.province) : city1.province != null) return false;
        return city != null ? city.equals(city1.city) : city1.city == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
