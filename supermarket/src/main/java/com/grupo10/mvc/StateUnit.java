/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeiss
 * @param <T>
 */
public final class StateUnit<T> {

    private T value;

    private final List<ValueChangedHandler> valueChangedHigh;
    private final List<ValueChangedHandler> valueChangedMedium;
    private final List<ValueChangedHandler> valueChangedLow;

    public StateUnit(T value) {
        this.valueChangedLow = new ArrayList<>();
        this.valueChangedMedium = new ArrayList<>();
        this.valueChangedHigh = new ArrayList<>();
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        valueChangedHigh.forEach(handler -> handler.HandleChange(value, this.value));
        valueChangedMedium.forEach(handler -> handler.HandleChange(value, this.value));
        valueChangedLow.forEach(handler -> handler.HandleChange(value, this.value));

        this.value = value;
    }

    public void onChange(ValueChangedHandler handler) {
        onChange(handler, ValueChangedHandlerPriority.Medium);
    }

    public void onChange(ValueChangedHandler handler, ValueChangedHandlerPriority priority) {
        switch (priority) {
            case Medium:
                valueChangedMedium.add(handler);
                break;
            case High:
                valueChangedHigh.add(handler);
                break;
            case Low:
                valueChangedLow.add(handler);
                break;
            default:
                throw new AssertionError(priority.name());
        }
    }
}
