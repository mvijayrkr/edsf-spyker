package com.dbs.edsf.controller;

import com.dbs.edsf.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dbs.edsf.service.APIService;

import java.util.List;

@RestController
public class ApiController {

	@Autowired
	private APIService aPIService;

/*
	@RequestMapping(value = "/edsf/cache/v1/fetchProfileByUser", method = RequestMethod.GET)
	public UserProfile fetchProfileByUser(@RequestParam(name = "userName") String userName,
														   @RequestParam(name = "isCacheable") boolean isCacheable) throws InterruptedException {
		return  aPIService.fetchProfileByUser(userName, isCacheable);
	}


	@RequestMapping(value = "/edsf/cache/v1/getUserProfile", method = RequestMethod.GET)
	public UserProfile getUserProfile(@RequestParam(name = "userName") String userName) throws InterruptedException {
		return  aPIService.getUserProfile(userName);
	}

	@RequestMapping(value = "/edsf/cache/v1/cacheUserProfile", method = RequestMethod.GET)
	public UserProfile cacheUserProfile(@RequestParam(name = "userName") String userName, @RequestParam(name = "profile") String profile) throws InterruptedException {
		return  aPIService.cacheUserProfile(userName, profile);
	}*/


	@RequestMapping(value = "/edsf/cache/v1/refreshAllUserProfiles", method = RequestMethod.GET)
	public UserProfile refreshAllUserProfiles() throws InterruptedException {
		return  aPIService.refreshAllUserProfiles();
	}


	@RequestMapping(value = "/edsf/cache/v1/UserProfileMappingcache", method = RequestMethod.GET)
	public UserProfileCache UserProfileMappingcache(@RequestParam(name = "userName") String userName, @RequestParam(name = "profile") List<String> profile) throws InterruptedException {
		return  aPIService.UsersProfileMappingCache(userName, profile);
	}


	@RequestMapping(value = "/edsf/cache/v1/UserTableProfileCache", method = RequestMethod.GET)
	public UserTableProfileCache UserTableProfileCache(@RequestParam(name = "tableName") String tableName, @RequestParam(name = "colNames") String colNames, @RequestParam(name = "coludf") String coludf, @RequestParam(name = "profile") String profile) throws InterruptedException {
		return  aPIService.UsersTableProfileMappingCache(tableName,profile,colNames,coludf);
	}


	@RequestMapping(value = "/edsf/cache/v1/UserRowLevelFiltersMappingCache", method = RequestMethod.GET)
	public UserRowLevelFiltersCache UserRowLevelFiltersMappingCache(@RequestParam(name = "userName") String userName,@RequestParam(name = "tableName") String tableName,  @RequestParam(name = "operations") List<String> operations, @RequestParam(name = "rlf") String rlf) throws InterruptedException {
		return  aPIService.UserRowLevelFiltersMappingCache(userName,tableName,operations,rlf);
	}

	/*@RequestMapping(value = "/edsf/cache/v1/getUsersTableProfileMappingCache", method = RequestMethod.GET)
	public UserTableProfileCache UserRowLevelFiltersMappingCache(@RequestParam(name = "tableName") String tableName) throws InterruptedException {
		return  aPIService.getUsersTableProfileMappingCache(tableName);
	}*/


	@RequestMapping(value = "/edsf/cache/v1/UserTableProfileCacheTest", method = RequestMethod.GET)
	public UserTableProfileCacheTest UserTableProfileCacheTest(@RequestParam(name = "userName") String userName,@RequestParam(name = "tableName") String tableName,  @RequestParam(name = "profile") String profile) throws InterruptedException {
		return  aPIService.UserTableProfileMappingCacheSample(userName,tableName,profile);
	}


	@RequestMapping(value = "/edsf/cache/v1/fetchProfileByUser", method = RequestMethod.GET)
	public UserTableProfileCacheTest fetchTableProfileByUser(@RequestParam(name = "userName") String userName,
										  @RequestParam(name = "tableName") String tableName) throws InterruptedException {

		return  aPIService.fetchTableProfileByUser(userName, tableName);
	}
}