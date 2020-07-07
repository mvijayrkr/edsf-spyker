package com.dbs.edsf.model;


/*Col2
        HashMap<String, HashMap<String, UserTableMapping>> hm = new HashMap<>();
        String1 (outer key)= user
        String2 (inner key)= table
        Class = anchorpoints(row level filter),operation(select,delete)*/

import java.util.HashMap;
import java.util.Map;

public class UserRowLevelFiltersCache {


    Map<String,Map<String, Object>> rlfusertablemap ;

    public Map<String, Map<String, Object>> getRlfusertablemap() {
        return rlfusertablemap;
    }

    public void setRlfusertablemap(Map<String, Map<String, Object>> rlfusertablemap) {
        this.rlfusertablemap = rlfusertablemap;
    }




}
