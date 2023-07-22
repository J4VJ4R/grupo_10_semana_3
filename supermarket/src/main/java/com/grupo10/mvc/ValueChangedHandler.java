/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.mvc;

/**
 *
 * @author jeiss
 * @param <T>
 */
public interface ValueChangedHandler<T> {
    void HandleChange(T newValue, T oldValue);
}
