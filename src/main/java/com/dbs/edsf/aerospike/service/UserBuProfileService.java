package com.dbs.edsf.aerospike.service;


import com.dbs.edsf.aerospike.domain.UserBuProfile;

public interface UserBuProfileService {
	Iterable<UserBuProfile> listAllUsers();

	UserBuProfile getBuProfileByUser(String user);

	UserBuProfile saveUserBuProfile(UserBuProfile userBuProfile);

	void deleteUser(String user);
}