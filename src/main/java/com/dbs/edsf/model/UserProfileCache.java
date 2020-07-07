package com.dbs.edsf.model;

import java.util.List;
import java.util.Map;


/*
Col1
        User, List<profile>
*/

public class UserProfileCache {

// user,table
//private Map<user, Map<tableName,profile>> usersProfileMappingMap;
    private Map<String, List<String>> usersProfileMappingMap;




    //constructors
    public UserProfileCache(){

    }

    public Map<String, List<String>> getUsersProfileMappingMap() {
        return usersProfileMappingMap;
    }

    public void setUsersProfileMappingMap(Map<String, List<String>> usersProfileMappingMap) {
        this.usersProfileMappingMap = usersProfileMappingMap;
    }



}
