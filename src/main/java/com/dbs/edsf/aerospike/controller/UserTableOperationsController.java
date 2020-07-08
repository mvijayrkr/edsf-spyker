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

    @RequestMapping(value = "saveuserrlfoperations", method = RequestMethod.GET)
    public UserTblOpertn saveUser(@RequestParam(name = "user_table") String user_table,
                                  @RequestParam(name = "rlf") String rlf, @RequestParam(name = "operations") String operations ) {
        List<String> rlf_lst = Arrays.asList(rlf.split(","));
        List<String> operations_lst = Arrays.asList(operations.split(","));
        userTblOpertn.setUser_table(user_table);
        userTblOpertn.setUserTblRlfOpr(new UserTblRlfOpr(rlf_lst,operations_lst));
        userTableOperationsService.saveUserTableRlfOperations(userTblOpertn);
        return userTblOpertn;
    }


    @RequestMapping(value = "getuserrlfoperations/{user_table}", method = RequestMethod.GET)
    public UserTblOpertn getBUProfileByUser(@PathVariable String user_table) {
        UserTblOpertn uto = userTableOperationsService.getUserTableRlfOperations(user_table);
        //String profile = ubp.getBuprofile().get("CBG");
        return uto;
    }

    @RequestMapping(value = "deleteuserrlfoperations/{user_table}", method = RequestMethod.GET)
    public String deleteBUProfileByUser(@PathVariable String user_table) {
        userTableOperationsService.deleteUserTableRlfOperations(user_table);
        //String profile = ubp.getBuprofile().get("CBG");
        return "deleted " + user_table;
    }
}
