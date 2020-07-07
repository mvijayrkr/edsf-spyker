package com.dbs.edsf.aerospike.domain;

import java.util.List;

public class UserTblRlfOpr {


    List<String> operation;//select,delete,insert
    List<String> rowLevelFilter; //IN,EDSF


    public List<String> getOperation() {
        return operation;
    }

    public void setOperation(List<String> operation) {
        this.operation = operation;
    }

    public List<String> getRowLevelFilter() {
        return rowLevelFilter;
    }

    public void setRowLevelFilter(List<String> rowLevelFilter) {
        this.rowLevelFilter = rowLevelFilter;
    }

    public UserTblRlfOpr(){

    }
    public UserTblRlfOpr(List<String> operation, List<String> rowLevelFilter) {
        this.operation = operation;
        this.rowLevelFilter = rowLevelFilter;
    }

}
