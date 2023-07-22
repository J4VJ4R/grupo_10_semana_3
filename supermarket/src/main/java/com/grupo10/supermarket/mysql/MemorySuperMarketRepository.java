/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.supermarket.mysql;

import com.grupo10.supermarket.models.ISuperMarketRepository;
import com.grupo10.supermarket.models.SuperMarket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author jeiss
 */
public class MemorySuperMarketRepository implements ISuperMarketRepository {
    private int lastId = 0;
    
    private final List<SuperMarket> entries = new ArrayList<>();
    
    @Override
    public void add(SuperMarket entry) {
        entries.add(new SuperMarket(lastId++, entry.getName(), entry.getCity()));
    }

    @Override
    public Collection<SuperMarket> list() {
        return entries;
    }    
}
