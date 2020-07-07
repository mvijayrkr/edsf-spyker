package com.dbs.edsf.service;

import com.dbs.edsf.model.SampleData;
import com.dbs.edsf.model.UserProfile;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;

public class userProfileService {
/*
    @Autowired
    private CacheManager cacheManager;
    SampleData sampleData = new SampleData();

    UserProfile userProfile = new UserProfile();



    Cache cache = cacheManager.getCache("ten-second-cache");


    public void cacheUserProfile(String userName, boolean isCacheable) throws InterruptedException {
        Thread.sleep(4000);
        HashMap<String, String> userprofile = new HashMap<String, String>();
        userprofile.put("vijay","ns");
        userprofile.put("nishant","ns,ns_pni");
        userprofile.put("abhishek","all");
        List<UserProfile> upl = sampleData.buildUserProfile();
        for(UserProfile up : upl){
            cache.put();
        }

        String value = cache.get(3L).get();

    }*/

}
