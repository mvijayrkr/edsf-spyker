package com.dbs.edsf.aerospike.service;

//import com.dbs.edsf.aerospike.domain.UserBuProfile;
import com.dbs.edsf.aerospike.domain.TblProfileCol;
import com.dbs.edsf.aerospike.domain.UserTblOpertn;

public interface TableProfileColumnService {

  //  Iterable<TblProfileCol> listAllUsers();

    TblProfileCol getTableProfileCol(String table_profile);

    TblProfileCol saveTableProfileCol(TblProfileCol TblProfileCol);

    void deleteTableProfileCol(String table_profile);
}
