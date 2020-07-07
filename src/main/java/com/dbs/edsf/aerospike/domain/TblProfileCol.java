package com.dbs.edsf.aerospike.domain;

import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.List;

public class TblProfileCol {

    @Id
    String table_profile;
    HashMap<String, String> coludf;
    List<String> bu;

    public String getTable_profile() {
        return table_profile;
    }

    public void setTable_profile(String table_profile) {
        this.table_profile = table_profile;
    }

    public HashMap<String, String> getColudf() {
        return coludf;
    }

    public void setColudf(String coludf) {
        this.coludf = coludf;
    }

    public List<String> getBu() {
        return bu;
    }

    public void setBu(List<String> bu) {
        this.bu = bu;
    }




}
