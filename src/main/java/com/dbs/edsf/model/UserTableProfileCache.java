package com.dbs.edsf.model;

/*
Col3
        Hashmap<Table,objec(Hashmap<profile ,Hashmap<col,maskexpr>,String[]) >
        Key1 = table1
        objet.get(map) -> profile ,col:udf
        object.get(allowed_bu)
        Inner key = profile
        col = columns
        maskexpr(string) = example -> ptyunprotectstr(val,udfname)/NA
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTableProfileCache implements java.io.Serializable{

    Map<String,Map<String, Map<String,String>>> userTableProfilemap;
    String[] allowed_bu;// EDSF,CBG..


    String tablenmae;
    String profile;
    Map<String,String> m;
    public Map<String, Map<String, Map<String, String>>> getUserTableProfilemap() {
        return userTableProfilemap;
    }

    public void setUserTableProfilemap(Map<String, Map<String, Map<String, String>>> userTableProfilemap) {
        this.userTableProfilemap = userTableProfilemap;
    }






//aerospike - push - cache(updates latest recors) => collection => get the reqired from cache by passing few paramters


}
