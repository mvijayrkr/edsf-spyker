package com.dbs.edsf.service;

import com.dbs.edsf.model.UserTableProfileCacheTest;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class test {
    Map<String,Map<String, String>> userTableprofileMap = new ConcurrentHashMap<>();
    Map<String, String> tableprofileMap = new ConcurrentHashMap<>();
    UserTableProfileCacheTest userTableProfileCacheTest = new UserTableProfileCacheTest();


    @CachePut(value = "Policycache", key="#userName")
    public void UserTableProfileMappingCacheSample(String userName, String tableName, String profile) throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Executing UserRowLevelFiltersCache method...");


        if(userTableprofileMap.get(userName) == null) {
            userTableprofileMap.put(userName,new ConcurrentHashMap<String,String>());
        }
        userTableprofileMap.get(userName).put(tableName,profile);
        userTableProfileCacheTest.setUsersProfileMappingMap(userTableprofileMap);
    }
    @Cacheable(value="Policycache", key = "#userName")
    public void fetchcache(String userName) throws InterruptedException {
        UserTableProfileCacheTest u = new UserTableProfileCacheTest();
        Thread.sleep(4000);
        u.setProfile(userTableprofileMap.get(userName).get("table2"));
        System.out.println(u.getProfile());
    }

    public static void main(String[] args) throws InterruptedException {

        UserTableProfileCacheTest u = new UserTableProfileCacheTest();
        test t =new test();
        t.UserTableProfileMappingCacheSample("vijay","table2","ns");
        t.fetchcache("vijay");
       // System.out.println(t.userTableprofileMap.get("vijay").get("table2"));
       /* u.setProfile(t.userTableprofileMap.get("vijay").get("table2"));
        u.setTableName("");
        u.setUserName("");

        System.out.println(u.getProfile());*/
      /*  String colname = "col1,col2,col3";
        String udfmethod = "col1,udf(col2),udf(col3)";
        String profile="ns_npi";
        String tablename="table1";
        // Thread.sleep(4000);
        System.out.println("Executing UserTableProfileCache method...");
        Map<String,Object> udfColumnMap= new ConcurrentHashMap<>();
        Map<String,Map<String, Object>> profileUdfColumnsMap = new ConcurrentHashMap<>();
        Map<String, Map<String, Map<String, Object>>> TableProfileudfmap = new ConcurrentHashMap<>();
        //List<Map<String, Object>> listofcoludf = new ArrayList<>();
        //Iterator itr=map.keySet().iterator();
        List<String> udfcolumns= Arrays.asList(udfmethod.split(","));
        List<String> columns=  Arrays.asList(colname.split(","));
        for (int i=0; i< columns.size(); i++){
            udfColumnMap.put(columns.get(i),udfcolumns.get(i));
        }

        //udfColumnMap.put(colname,udfmethod);
        // listofcoludf.add(udfColumnMap);
        profileUdfColumnsMap.put(profile,udfColumnMap);
        TableProfileudfmap.put(tablename,profileUdfColumnsMap);
        if(TableProfileudfmap.equals(tablename)){

            profileUdfColumnsMap.put("all",udfColumnMap);
            // TableProfileudfmap.put(tablename,profileUdfColumnsMap);
        }
        for (Map.Entry<String, Map<String, Map<String, Object>>> entry : TableProfileudfmap.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }*/


    }

}
