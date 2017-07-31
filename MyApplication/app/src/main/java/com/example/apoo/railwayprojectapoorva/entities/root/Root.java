package com.example.apoo.railwayprojectapoorva.entities.root;

/**
 * Created by Apoo on 7/14/2017.
 */

public class Root {

    String schdep;
    String distance;
    String fullname;
    String day;
    String code;
    String scharr;
    String halt;
    String rootNumber;


    public Root( String schdep, String distance, String fullname, String day, String code,String scharr, String halt,String rootNumber) {
        this.schdep = schdep;
        this.distance = distance;
        this.fullname = fullname;
        this.day = day;
        this.code = code;
        this.scharr = scharr;
        this.halt = halt;
        this.rootNumber = rootNumber;

    }

    public String getHalt() {
        return halt;
    }

    public String getScharr() {
        return scharr;
    }

    public String getSchdep() {
        return schdep;
    }

    public String getDay() {
        return day;
    }

    public String getDistance() {
        return distance;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCode() {
        return code;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public void setHalt(String halt) {
        this.halt = halt;
    }

    public String getRootNumber() {
        return rootNumber;
    }

    public void setRootNumber(String rootNumber) {
        this.rootNumber = rootNumber;
    }
}
