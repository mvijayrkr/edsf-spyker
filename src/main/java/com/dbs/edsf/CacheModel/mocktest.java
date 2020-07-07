package com.dbs.edsf.CacheModel;

import java.util.Map;

public class mocktest {


    public static void main(String[] args){
        CacheMockData cacheMockData = new CacheMockData();

        UserProfileCache userProfileCache =  new UserProfileCache();
        userProfileCache = cacheMockData.UserProfileCacheLoad();

        Map<String, Map<String,String>> upMap= userProfileCache.getUserProfileMap();
        Boolean profile =upMap.containsKey("nishant");
        System.out.println(profile);
        String profile1 = upMap.get("nishant").get("ibg");
        System.out.println(profile1);

    }
}
