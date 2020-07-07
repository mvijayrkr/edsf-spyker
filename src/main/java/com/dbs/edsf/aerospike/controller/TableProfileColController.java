package com.dbs.edsf.aerospike.controller;

import com.dbs.edsf.aerospike.configuration.EhCacheConfiguration;
import com.dbs.edsf.aerospike.domain.TblProfileCol;
import com.dbs.edsf.aerospike.domain.UserTblOpertn;
import com.dbs.edsf.aerospike.domain.UserTblRlfOpr;
import com.dbs.edsf.aerospike.service.TableProfileColumnService;
import com.dbs.edsf.aerospike.service.UserTableOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TableProfileColController {
    EhCacheConfiguration cache = new EhCacheConfiguration();
    @Autowired
    TableProfileColumnService tableProfileColumnService;
    TblProfileCol tblProfileCol = new TblProfileCol();

    @RequestMapping(value = "savetableprofilecol", method = RequestMethod.GET)
    public TblProfileCol saveUser(@RequestParam(name = "table_profile") String table_profile,
                                  @RequestParam(name = "bu") String bu, @RequestParam(name = "columns") String columns,@RequestParam(name = "udfcolumns") String udfcolumns ) {
        List<String> bu_lst = Arrays.asList(bu.split(","));
        List<String> columns_lst = Arrays.asList(columns.split(","));
        List<String> udfcolumns_lst = Arrays.asList(udfcolumns.split(","));

        tblProfileCol.setTable_profile(table_profile);
        tblProfileCol.setBu(bu_lst);

        HashMap<String, String> udfcol_map = new HashMap<>();
        for (int i = 0; i < columns_lst.size(); i++) {
            System.out.println(columns_lst.get(i));
            tblProfileCol.setColudf( udfcol_map.put(columns_lst.get(i),udfcolumns_lst.get(i)));
        }

        tableProfileColumnService.saveTableProfileCol(tblProfileCol);
        return tblProfileCol;
    }


    @RequestMapping(value = "gettableprofilecol/{table_profile}", method = RequestMethod.GET)
    public TblProfileCol getBUProfileByUser(@PathVariable String table_profile) {
        TblProfileCol uto = tableProfileColumnService.getTableProfileCol(table_profile);
        //String profile = ubp.getBuprofile().get("CBG");
        return uto;
    }

    @RequestMapping(value = "deletetableprofilecol/{table_profile}", method = RequestMethod.GET)
    public String deleteBUProfileByUser(@PathVariable String table_profile) {
        tableProfileColumnService.deleteTableProfileCol(table_profile);
        //String profile = ubp.getBuprofile().get("CBG");
        return "deleted " + table_profile;
    }
}
