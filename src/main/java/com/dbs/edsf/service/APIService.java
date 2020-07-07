package com.dbs.edsf.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.dbs.edsf.model.*;
import net.sf.ehcache.Cache;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class APIService {

	SampleData sampleData = new SampleData();
	UserProfileCache userProfileCache = new UserProfileCache();
	UserTableProfileCache userTableProfileCache = new UserTableProfileCache();
	UserTableMappingCache userTableMappingCache;
	UserRowLevelFiltersCache userRowLevelFiltersCache = new UserRowLevelFiltersCache();
	UserTableProfileCacheTest userTableProfileCacheTest = new UserTableProfileCacheTest();
	UserProfile userProfile;

	Map<String, List<String>> userprofilemap = new ConcurrentHashMap<>();

	Map<String,String> udfColumnMap= new ConcurrentHashMap<>();
	Map<String,Map<String, String>> profileUdfColumnsMap = new ConcurrentHashMap<>();
	Map<String, Map<String, Map<String, String>>> TableProfileudfmap = new ConcurrentHashMap<>();


	Map<String, Map<String, Object>> usertableOperationsmap = new ConcurrentHashMap<String, Map<String, Object>>();
	Map<String, Object> userTableRLFMap = new ConcurrentHashMap<String, Object>();


	Map<String,Map<String, String>> userTableprofileMap = new ConcurrentHashMap<>();
	Map<String, String> tableprofileMap = new ConcurrentHashMap<>();

	static HashMap<String, String> userprofile = new HashMap<>();
	/*static {
		userprofile.put("vijay","ns");
		userprofile.put("nishant","ns,ns_pni");
		userprofile.put("abhishek","all");
	}*/


/*
	//TODO: For testing using isCacheable
	@Cacheable(value="ten-second-cache", key = "#userName",
			condition = "#isCacheable != null && #isCacheable")
	public UserProfile fetchProfileByUser(String userName, boolean isCacheable) throws InterruptedException {
		Thread.sleep(4000);
		return new UserProfile(userName,userprofile.get(userName));

	}
*/

/*	@CachePut(value = "Policycache", key="#userName", unless="#result==null")
	public UserProfile cacheUserProfile(String userName, String profile) {
		System.out.println("Executing cacheUserProfile method...");
		*//*for(UserProfile up : sampleData.buildUserProfile()) {
			up.setUserName(userName);
			up.setProfile(profile);*//*
		UserProfile up = new UserProfile(userName,profile);

		userprofile.put(userName, profile);
		for (Map.Entry<String, String> entry : userprofile.entrySet()) {
			System.out.println("Key = " + entry.getKey() +
					", Value = " + entry.getValue());
			//	}

		*//*}
	    return null;*//*
		}
		return up;
	}*/

/*	@Cacheable(value = "Policycache", key="#userName")
	public UserProfile getUserProfile(String userName) throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Executing getUserProfile method...");
		UserProfile userProfile;
		return new UserProfile(userName,userprofile.get(userName));
	}*/

	@CacheEvict(value = "Policycache", allEntries = true)
	public UserProfile refreshAllUserProfiles() {
		//This method will remove all 'products' from cache, say as a result of flush API.
		return null;
	}



/*
Col1
        User, List<profile>
*/

	@Cacheable(value = "Policycache", key="#userName")
	public UserProfileCache UsersProfileMappingCache(String userName, List<String> profiles) throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Executing UserProfileCache method...");
		//userprofilemap= new ConcurrentHashMap<String, List<String>>();
		userprofilemap.put(userName,profiles);
		userProfileCache.setUsersProfileMappingMap(userprofilemap);
		for (Map.Entry<String,  List<String>> entry : userprofilemap.entrySet()){
			System.out.println("Key = " + entry.getKey() +
					", Value = " + entry.getValue());
		}
		return userProfileCache;
	}



 /*Hashmap<Table,Hashmap<profile ,List<Hashmap<col,maskexpr>>>
	        Key1 = table
	        Inner key = profile
	        col = columns
	        maskexpr(string) = example -> ptyunprotectstr(val,udfname)/NA*/

	@CachePut(value = "Policycache", key="#tablename")
	public UserTableProfileCache UsersTableProfileMappingCache(String tablename, String profile, String colname, String udfmethod) throws InterruptedException {
		Thread.sleep(4000);
		List<String> udfcolumns= Arrays.asList(udfmethod.split(","));
		List<String> columns=  Arrays.asList(colname.split(","));

		if(TableProfileudfmap.get(tablename) == null) {
			TableProfileudfmap.put(tablename, new ConcurrentHashMap<String,Map<String ,String>>());
		}
		if(TableProfileudfmap.get(tablename).get(profile) == null) {
			TableProfileudfmap.get(tablename).put(profile,new ConcurrentHashMap<String, String>());
		}
			for (int i=0; i< columns.size(); i++){
		TableProfileudfmap.get(tablename).get(profile).put(columns.get(i), udfcolumns.get(i));
			}
		userTableProfileCache.setUserTableProfilemap(TableProfileudfmap);
		return userTableProfileCache;
	}




	@CachePut(value = "Policycache", key="#userName")
	public UserRowLevelFiltersCache UserRowLevelFiltersMappingCache(String userName, String tableName, List<String> operations, String rlf) throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Executing UserRowLevelFiltersCache method...");
		userTableMappingCache = new UserTableMappingCache();
		userTableMappingCache.setOperation(operations);
		userTableMappingCache.setRowLevelFilter(rlf);
		System.out.println(usertableOperationsmap.get(userName));
		if(usertableOperationsmap.get(userName) == null) {
			usertableOperationsmap.put(userName,new ConcurrentHashMap<String,Object>());
		}
		usertableOperationsmap.get(userName).put(tableName,userTableMappingCache);
		userRowLevelFiltersCache.setRlfusertablemap(usertableOperationsmap);
		return userRowLevelFiltersCache;
	}

//TEST
	@CachePut(value = "Policycache", key="#userName")
	public UserTableProfileCacheTest UserTableProfileMappingCacheSample(String userName, String tableName,  String profile) throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Executing UserRowLevelFiltersCache method...");


		if(userTableprofileMap.get(userName) == null) {
			userTableprofileMap.put(userName,new ConcurrentHashMap<String,String>());
		}
		userTableprofileMap.get(userName).put(tableName,profile);
		userTableProfileCacheTest.setUsersProfileMappingMap(userTableprofileMap);
		return userTableProfileCacheTest;
	}

	@Cacheable(value="Policycache", key = "#userName")
	public UserTableProfileCacheTest fetchTableProfileByUser(String userName, String tableName) throws InterruptedException {
		System.out.println("fetchTableProfileByUser---- inside");
		Thread.sleep(4000);

		String profile = userTableprofileMap.get(userName).get(tableName);
		userTableProfileCacheTest.setProfile(profile);
		userTableProfileCacheTest.setTableName(tableName);
		userTableProfileCacheTest.setUserName(userName);
		//return new UserTableProfileCacheTest(userName,tableName,profile);
		return userTableProfileCacheTest;

	}
}
