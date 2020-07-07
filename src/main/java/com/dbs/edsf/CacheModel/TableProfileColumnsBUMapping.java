package com.dbs.edsf.CacheModel;

import java.util.Map;
//class(Map<profile,Map<col,udf>>, String[] BU)
public class TableProfileColumnsBUMapping {



    Map<String, Map<String,String>> ProfileColumnsMap;
    String[] BusinessUnit;

    public TableProfileColumnsBUMapping(){

    }
    public TableProfileColumnsBUMapping(Map<String, Map<String, String>> profileColumnsMap, String[] businessUnit) {
        ProfileColumnsMap = profileColumnsMap;
        BusinessUnit = businessUnit;
    }
}
