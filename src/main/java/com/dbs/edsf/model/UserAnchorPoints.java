package com.dbs.edsf.model;

public class UserAnchorPoints {

    String userTableName;
    String rowLevelFilters;

    public UserAnchorPoints(String userTableName, String rowLevelFilters) {
        this.userTableName = userTableName;
        this.rowLevelFilters = rowLevelFilters;
    }

    public String getUserTableName() {
        return userTableName;
    }

    public void setUserTableName(String userTableName) {
        this.userTableName = userTableName;
    }

    public String getRowLevelFilters() {
        return rowLevelFilters;
    }

    public void setRowLevelFilters(String rowLevelFilters) {
        this.rowLevelFilters = rowLevelFilters;
    }




}
