package com.dbs.edsf.aerospike.controller;

import com.dbs.edsf.aerospike.configuration.EhCacheConfiguration;
import com.dbs.edsf.aerospike.domain.UserBuProfile;
import com.dbs.edsf.aerospike.service.UserBuProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserBuProfileController {


	EhCacheConfiguration cache = new EhCacheConfiguration();
	@Autowired
	UserBuProfileService userBuProfileService;
	UserBuProfile userBuProfile = new UserBuProfile();
	HashMap<String, String> buprofilemap =  new HashMap<String, String>();

	@RequestMapping(value = "userbuprofile", method = RequestMethod.GET)
	public String saveUser(@RequestParam(name = "user") String user,
						   @RequestParam(name = "bu") String bu,@RequestParam(name = "profile") String profile) {

		userBuProfile.setUser(user);
		buprofilemap.put(bu,profile);
		userBuProfile.setBuprofile(buprofilemap);
		userBuProfileService.saveUserBuProfile(userBuProfile);
		return "userBuProfile";
	}


	@RequestMapping(value = "getBUProfileByUser/{user}/{bu}", method = RequestMethod.GET)
	public String getBUProfileByUser(@PathVariable String user, @PathVariable String bu) {
		UserBuProfile ubp = userBuProfileService.getBuProfileByUser(user);
		//String profile = ubp.getBuprofile().get("CBG");
		return ubp.getBuprofile().get(bu);
	}

	@RequestMapping(value = "deleteBUProfileByUser/{user}", method = RequestMethod.GET)
	public String deleteBUProfileByUser(@PathVariable String user) {
		 userBuProfileService.deleteUser(user);
		//String profile = ubp.getBuprofile().get("CBG");
		return "deleted " + user;
	}

	/*@RequestMapping(value = "getCacheStats", method = RequestMethod.GET)
	public void getCacheStats() {
		EhCacheCacheManager cacheManager = (EhCacheCacheManager) cache.cacheManager();
		cacheManager.
		//net.sf.ehcache.CacheManager cacheManager = (net.sf.ehcache.CacheManager) cache.cacheManager().getCache("Policycache");
		System.out.println(cacheManager.getStatus());
		System.out.println(cacheManager.getCacheNames());
		System.out.println(cacheManager.getDiskStorePathManager());
		System.out.println(cacheManager.getEhcache("Policycache").getKeys());
		System.out.println(cacheManager.getOnDiskPool());
		System.out.println(cacheManager.getOnHeapPool());

	}
*/
}
