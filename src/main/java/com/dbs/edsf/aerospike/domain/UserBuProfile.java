package com.dbs.edsf.aerospike.domain;

import org.springframework.data.annotation.Id;

import java.util.HashMap;


public class UserBuProfile {

    @Id
    String user;
    HashMap<String, String> buprofile;



    public UserBuProfile() {
    }
    public UserBuProfile(String user, HashMap<String, String> buprofile) {
        this.user = user;
        this.buprofile = buprofile;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public HashMap<String, String> getBuprofile() {
        return buprofile;
    }

    public void setBuprofile(HashMap<String, String> buprofile) {
        this.buprofile = buprofile;
    }




    /*String bu;
    String profile;*/


   /* public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

      public UserBuProfile(String user, String bu, String profile) {
        this.user = user;
        this.bu = bu;
        this.profile = profile;
    }*/


}
