package com.dbs.edsf.model;

public class TableProfile {

    String tableProfile;
    String columns;


    public TableProfile(String tableProfile, String columns) {
        this.tableProfile = tableProfile;
        this.columns = columns;
    }

    public String getTableProfile() {
        return tableProfile;
    }

    public void setTableProfile(String tableProfile) {
        this.tableProfile = tableProfile;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }



}
