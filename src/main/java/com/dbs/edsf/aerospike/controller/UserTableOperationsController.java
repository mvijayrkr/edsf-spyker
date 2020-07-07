package com.dbs.edsf.aerospike.controller;

import com.dbs.edsf.aerospike.configuration.EhCacheConfiguration;
import com.dbs.edsf.aerospike.domain.UserTblOpertn;
import com.dbs.edsf.aerospike.domain.UserTblRlfOpr;
import com.dbs.edsf.aerospike.service.UserTableOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserTableOperationsController {

    EhCacheConfiguration cache = new EhCacheConfiguration();
    @Autowired
    UserTableOperationsService userTableOperationsService;
    UserTblOpertn userTblOpertn = new UserTblOpertn();

    @RequestMapping(value = "savetableprofilecol", method = RequestMethod.GET)
    public UserTblOpertn saveUser(@RequestParam(name = "table_profile") String user_table,
                                  @RequestParam(name = "rlf") String rlf, @RequestParam(name = "operations") String operations ) {
        List<String> rlf_lst = Arrays.asList(rlf.split(","));
        List<String> operations_lst = Arrays.asList(operations.split(","));
        userTblOpertn.setUser_table(user_table);
        userTblOpertn.setUserTblRlfOpr(new UserTblRlfOpr(rlf_lst,operations_lst));
        userTableOperationsService.saveUserTableRlfOperations(userTblOpertn);
        return userTblOpertn;
    }


    @RequestMapping(value = "gettableprofilecol/{table_profile}", method = RequestMethod.GET)
    public UserTblOpertn getBUProfileByUser(@PathVariable String table_profile) {
        UserTblOpertn uto = userTableOperationsService.getUserTableRlfOperations(table_profile);
        //String profile = ubp.getBuprofile().get("CBG");
        return uto;
    }

    @RequestMapping(value = "deletetableprofilecol/{table_profile}", method = RequestMethod.GET)
    public String deleteBUProfileByUser(@PathVariable String table_profile) {
        userTableOperationsService.deleteUserTableRlfOperations(table_profile);
        //String profile = ubp.getBuprofile().get("CBG");
        return "deleted " + table_profile;
    }
}
