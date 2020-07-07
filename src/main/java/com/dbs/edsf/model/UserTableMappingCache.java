package com.dbs.edsf.model;

import java.util.List;

public class UserTableMappingCache {


    List<String> operation;//select,delete,insert
    String rowLevelFilter; //IN,EDSF

    public UserTableMappingCache(){

    }
    public UserTableMappingCache(List<String> operation, String rowLevelFilter) {
        this.operation = operation;
        this.rowLevelFilter = rowLevelFilter;
    }

    public List<String> getOperation() {
        return operation;
    }

    public void setOperation(List<String> operation) {
        this.operation = operation;
    }

    public String getRowLevelFilter() {
        return rowLevelFilter;
    }

    public void setRowLevelFilter(String rowLevelFilter) {
        this.rowLevelFilter = rowLevelFilter;
    }



}


