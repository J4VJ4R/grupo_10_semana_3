/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.mvc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jeiss
 * @param <TModel>
 */
public class DataTableModel<TModel> extends AbstractTableModel {
    
    private List<TModel> data;
    private final List<String> columns = new ArrayList<>();
    private final List<IModelCellValueSelector<TModel>> valueSelectors = new ArrayList<>();
    
    public DataTableModel<TModel> addColumn(String columnName, IModelCellValueSelector<TModel> cellValueSelector) {
        columns.add(columnName);
        valueSelectors.add(cellValueSelector);
        return this;
    }

    public void setData(List<TModel> data) {
        this.data = data;
        this.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        if(columns.size() <= column){
            return super.getColumnName(column);
        }
        return columns.get(column);
    }
    
    @Override
    public int getRowCount() {
        if(data == null) {
            return 0;
        }
        
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(data == null || rowIndex >= data.size()){
            return null;
        }
        
        var entry = data.get(rowIndex);
        var columnName = getColumnName(columnIndex);
        var valueSelector = valueSelectors.get(columnIndex);
        
        return valueSelector.getCellValue(entry, columnIndex, columnName);
    }
    
}
