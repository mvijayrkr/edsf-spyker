package com.dbs.edsf.CacheModel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheMockData {

    UserProfileCache userProfileCache;
    UserTableOperationsCache userTableOperationsCache;
    TableProfileColumnsCache tableProfileColumnsCache;
    TableProfileColumnsBUMapping tableProfileColumnsBUMapping;
    UserOperationRLFMapping userOperationRLFMapping;

    public CacheMockData() {
        userProfileCache = new UserProfileCache();
        userTableOperationsCache = new UserTableOperationsCache();
        tableProfileColumnsCache= new TableProfileColumnsCache();
        tableProfileColumnsBUMapping = new TableProfileColumnsBUMapping();
        //userOperationRLFMapping = new UserOperationRLFMapping();
    }
    public UserProfileCache UserProfileCacheLoad(){
        Map<String, Map<String, String>> userProfileMap = new ConcurrentHashMap<>();
        Map<String, String> buProfile = new ConcurrentHashMap<>();
        buProfile.put("cbg","ns");
        buProfile.put("ibg","ns_pni");
        buProfile.put("etc","all");
        userProfileMap.put("vijay",buProfile);
        userProfileMap.put("nishant",buProfile);
        userProfileMap.put("abhishek",buProfile);
        userProfileCache.setUserProfileMap(userProfileMap);
        return userProfileCache;
    }



    /*HashMap<String, HashMap<String, UserTableMapping>> hm = new HashMap<>();
        String1 (outer key)= user
        String2 (inner key)= table
        Class = anchorpoints(row level filter),operation(select,delete)*/
    public UserTableOperationsCache UserTableOperationsCacheLoad(){
        Map<String, Map<String, UserOperationRLFMapping>> userTableOperationsMap = new ConcurrentHashMap<>();
        Map<String, UserOperationRLFMapping> tableOperationsMap = new ConcurrentHashMap<>();


        List<String> operations = new ArrayList<>();
        List<String> rowlevelfilters = new ArrayList<>();
        operations.add("select");
        operations.add("drop");
        operations.add("insert");
        rowlevelfilters.add("in");
        rowlevelfilters.add("edsf");

        tableOperationsMap.put("table1", new UserOperationRLFMapping(operations, rowlevelfilters));
        tableOperationsMap.put("table2", new UserOperationRLFMapping(operations, rowlevelfilters));
        userTableOperationsMap.put("vijay",tableOperationsMap);
        userTableOperationsMap.put("nishant",tableOperationsMap);

        userTableOperationsCache.setHm(userTableOperationsMap);
        return userTableOperationsCache;
    }


    //Map<Table, class(Map<profile,Map<col,udf>>, String[] BU)>
    public TableProfileColumnsCache tableProfileColumnsCacheLoad(){
        //table,obj(map<profile,map<col,udf>)
        Map<String, TableProfileColumnsBUMapping> tableprofile = new ConcurrentHashMap<>();
        //profile,<col,udf>
        Map<String, Map<String, String>> profileColumns = new ConcurrentHashMap<>();
        //col,udf
        Map<String, String> colUdfs = new ConcurrentHashMap<>();

        colUdfs.put("col1","udf(col1)");
        colUdfs.put("col2","udf(col2)");
        colUdfs.put("col3","col3");

        profileColumns.put("ns",colUdfs);
        profileColumns.put("ns_pni",colUdfs);
        profileColumns.put("all",colUdfs);

        String[] businessUnit = {"cbg","ibg"};

        tableprofile.put("table1",new TableProfileColumnsBUMapping(profileColumns,businessUnit));
        tableprofile.put("table2",new TableProfileColumnsBUMapping(profileColumns,businessUnit));
        tableprofile.put("table3",new TableProfileColumnsBUMapping(profileColumns,businessUnit));

        tableProfileColumnsCache.setUserTableProfilemap(tableprofile);

        return tableProfileColumnsCache;
    }



}
