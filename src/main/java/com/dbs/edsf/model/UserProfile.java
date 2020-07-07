package com.dbs.edsf.model;

public class UserProfile {

    String userName;
    String profile;
    String table;

    public UserProfile(String userName, String table, String profile) {
        super();
        this.userName = userName;
        this.profile = profile;
        this.table =table;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
