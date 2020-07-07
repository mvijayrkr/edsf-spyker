package com.dbs.edsf.model;

import java.util.Map;

public class UserTableProfileCacheTest {
    String userName;
    String tableName;
    String profile;
    private Map<String , Map<String ,String>> usersProfileMappingMap;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public UserTableProfileCacheTest(){

    }


    public UserTableProfileCacheTest(String userName, String tableName, String profile) {
        this.userName = userName;
        this.tableName = tableName;
        this.profile = profile;
    }






    public Map<String, Map<String, String>> getUsersProfileMappingMap() {
        return usersProfileMappingMap;
    }

    public void setUsersProfileMappingMap(Map<String, Map<String, String>> usersProfileMappingMap) {
        this.usersProfileMappingMap = usersProfileMappingMap;
    }


}
