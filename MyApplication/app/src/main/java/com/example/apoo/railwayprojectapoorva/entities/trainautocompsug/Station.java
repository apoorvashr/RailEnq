package com.example.apoo.railwayprojectapoorva.entities.trainautocompsug;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {

@SerializedName("fullname")
@Expose
private String fullname;
@SerializedName("code")
@Expose
private String code;

public String getFullname() {
return fullname;
}

public void setFullname(String fullname) {
this.fullname = fullname;
}

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

}