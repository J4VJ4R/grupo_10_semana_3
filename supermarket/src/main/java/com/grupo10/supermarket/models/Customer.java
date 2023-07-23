/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.models;

/**
 *
 * @author jeiss
 */
public class Customer {

    private final Integer id;
    private final String name;
    private final String lastname;
    private final int identification;
    private final String telephone;
    private final String position;
    
    public Customer(){
        this.id = null;
        this.name = "";
        this.lastname = "";
        this.identification = 0;
        this.telephone = "";
        this.position = "";
    }
    
    public Customer(String name, String lastname, int identification, String telephone, String position) {
        this.id = null;
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.telephone = telephone;
        this.position = position;
    }

    public Customer(Integer id, String name, String lastname, int identification, String telephone, String position) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.telephone = telephone;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getIdentification() {
        return identification;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPosition() {
        return position;
    }
}
