package com.dbs.edsf.aerospike.service;

import com.dbs.edsf.aerospike.domain.UserBuProfile;
import com.dbs.edsf.aerospike.repository.UserBuProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class UserBuProfileServiceImpl implements UserBuProfileService{

	@Autowired
	private UserBuProfileRepository userBuProfileRepository;


	@Override
	public Iterable<UserBuProfile> listAllUsers() {
		return userBuProfileRepository.findAll();
	}

//	@Cacheable(value="Policycache", key="#user")
	@Override
	public UserBuProfile getBuProfileByUser(String user) {
		slowQuery(2000L);
		System.out.println("inside -------------------------------------");
		return userBuProfileRepository.findOne(user);
	}

	@CachePut(value="Policycache", key="#userBuProfile.user")
	@Override
	public UserBuProfile saveUserBuProfile(UserBuProfile userBuProfile) {
		System.out.println("cache enabled");
		return userBuProfileRepository.save(userBuProfile);
	}

	@CacheEvict(value="Policycache", key="#user")
	@Override
	public void deleteUser(String user) {
		userBuProfileRepository.delete(user);

	}



	private void slowQuery(long seconds){
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
	/*@Override
	public Iterable<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findOne(id);
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.delete(id);
	}*/
}
