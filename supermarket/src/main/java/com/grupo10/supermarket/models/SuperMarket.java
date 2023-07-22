/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.models;

/**
 *
 * @author jeiss
 */
public class SuperMarket {

    private final Integer id;
    private final String name;
    private final String city;

    public SuperMarket() {
        this.id = null;
        this.name = "";
        this.city = "";
    }

    public SuperMarket(SuperMarket other) {
        this.id = other.id;
        this.name = other.name;
        this.city = other.city;
    }

    public SuperMarket(String name, String city) {
        this.id = null;
        this.name = name;
        this.city = city;
    }

    public SuperMarket(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + ", " + city;
    }
    
    
}
