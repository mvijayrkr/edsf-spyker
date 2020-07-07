package com.dbs.edsf.aerospike.configuration;


import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class EhCacheConfiguration extends CachingConfigurerSupport {


	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager() {
		//10sec for testing
		CacheConfiguration tenSecondCache = new CacheConfiguration();
		tenSecondCache.setName("ten-second-cache");
		tenSecondCache.setMemoryStoreEvictionPolicy("LRU");
		tenSecondCache.setMaxEntriesLocalHeap(1000);
		tenSecondCache.setTimeToLiveSeconds(10);


		//every 15 mins
		CacheConfiguration userpolicyCache = new CacheConfiguration();
		userpolicyCache.setName("Policycache");
		userpolicyCache.setMemoryStoreEvictionPolicy("LRU");
		userpolicyCache.setMaxEntriesLocalHeap(1000);
		userpolicyCache.setTimeToLiveSeconds(900);

		//every 15 mins
		CacheConfiguration userTableOperationsCache = new CacheConfiguration();
		userTableOperationsCache.setName("userTableOperationsCache");
		userTableOperationsCache.setMemoryStoreEvictionPolicy("LRU");
		userTableOperationsCache.setMaxEntriesLocalHeap(1000);
		userTableOperationsCache.setTimeToLiveSeconds(900);

		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(tenSecondCache);
		config.addCache(userpolicyCache);
		config.addCache(userTableOperationsCache);
		return net.sf.ehcache.CacheManager.newInstance(config);
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}

}