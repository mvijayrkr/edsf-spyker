package com.dbs.edsf.aerospike.service;

//import com.dbs.edsf.aerospike.domain.UserBuProfile;
import com.dbs.edsf.aerospike.domain.UserTblOpertn;

public interface UserTableOperationsService {

  //  Iterable<UserTblOpertn> listAllUsers();

    UserTblOpertn getUserTableRlfOperations(String user_table);

    UserTblOpertn saveUserTableRlfOperations(UserTblOpertn userTblOpertn);

    void deleteUserTableRlfOperations(String user_table);
}
