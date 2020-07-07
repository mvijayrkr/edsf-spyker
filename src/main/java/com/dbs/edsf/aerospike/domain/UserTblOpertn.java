package com.dbs.edsf.aerospike.domain;

import org.springframework.data.annotation.Id;

public class UserTblOpertn {
    @Id
    String user_table;
    UserTblRlfOpr userTblRlfOpr;

    public String getUser_table() {
        return user_table;
    }

    public void setUser_table(String user_table) {
        this.user_table = user_table;
    }

    public UserTblRlfOpr getUserTblRlfOpr() {
        return userTblRlfOpr;
    }

    public void setUserTblRlfOpr(UserTblRlfOpr userTblRlfOpr) {
        this.userTblRlfOpr = userTblRlfOpr;
    }

}
