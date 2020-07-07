package com.dbs.edsf.aerospike.service;

import com.dbs.edsf.aerospike.domain.TblProfileCol;
import com.dbs.edsf.aerospike.domain.UserTblOpertn;
import com.dbs.edsf.aerospike.repository.TableProfileColumns;
import com.dbs.edsf.aerospike.repository.UserTableOperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@Service
public class TableProfileColumnServiceImpl implements TableProfileColumnService {

    @Autowired
    private TableProfileColumns tableProfileColumns;

    TblProfileCol tblProfileCol = new TblProfileCol();

   /* @Override
   public Iterable<UserTblOpertn> listAllUsers() {
        return userTableOperationsRepository.findAll();
    }*/


    @Cacheable(value="TableProfileColCache", key="#user_table")
    @Override
    public TblProfileCol getTableProfileCol(String table_profile) {

        TblProfileCol tblProfileCol = tableProfileColumns.findOne(table_profile);
     //   userTableOperations.getTable(use);
        return tblProfileCol;
    }

    @CachePut(value="TableProfileColCache", key="#UserTblOpertn.user_table")
    @Override
    public TblProfileCol saveTableProfileCol(TblProfileCol tblProfileCol) {

        TblProfileCol resp =tableProfileColumns.save(tblProfileCol);
        return resp;
    }

    @CacheEvict(value="TableProfileColCache", key="#user_table")
    @Override
    public void deleteTableProfileCol(String table_profile) {
        tableProfileColumns.delete(table_profile);
    }


}
