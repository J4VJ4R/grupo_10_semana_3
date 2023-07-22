/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo10.mvc;

/**
 *
 * @author jeiss
 * @param <TModel>
 */
public interface IModelCellValueSelector<TModel> {
    public Object getCellValue(TModel model, int column, String columnName);
}
