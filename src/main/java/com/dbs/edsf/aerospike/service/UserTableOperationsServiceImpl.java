package com.dbs.edsf.aerospike.service;

import com.dbs.edsf.aerospike.domain.UserTblOpertn;
import com.dbs.edsf.aerospike.repository.UserTableOperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
public class UserTableOperationsServiceImpl implements UserTableOperationsService {

    @Autowired
    private UserTableOperationsRepository userTableOperationsRepository;

    UserTblOpertn userTblOpertn = new UserTblOpertn();

   /* @Override
   public Iterable<UserTblOpertn> listAllUsers() {
        return userTableOperationsRepository.findAll();
    }*/


    @Cacheable(value="userTableOperationsCache", key="#user_table")
    @Override
    public UserTblOpertn getUserTableRlfOperations(String user_table) {

        UserTblOpertn usrresponse = userTableOperationsRepository.findOne(user_table);
     //   userTableOperations.getTable(use);
        return usrresponse;
    }

    @CachePut(value="userTableOperationsCache", key="#UserTblOpertn.user_table")
    @Override
    public UserTblOpertn saveUserTableRlfOperations(UserTblOpertn userTblOpertn) {

        UserTblOpertn resp =userTableOperationsRepository.save(userTblOpertn);
        return resp;
    }

    @CacheEvict(value="userTableOperationsCache", key="#user_table")
    @Override
    public void deleteUserTableRlfOperations(String user_table) {
        userTableOperationsRepository.delete(user_table);
    }


}
