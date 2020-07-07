package com.dbs.edsf.aerospike.repository;

import com.dbs.edsf.aerospike.domain.UserTblOpertn;
import org.springframework.data.repository.CrudRepository;

public interface UserTableOperationsRepository extends CrudRepository<UserTblOpertn,String> {


}
