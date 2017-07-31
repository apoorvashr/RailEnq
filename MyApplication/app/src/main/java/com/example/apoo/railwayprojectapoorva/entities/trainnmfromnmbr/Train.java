package com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Train  implements Serializable{

@SerializedName("name")
@Expose
private String name;
@SerializedName("number")
@Expose
private String number;
@SerializedName("days")
@Expose
private List<Day> days = null;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getNumber() {
return number;
}

public void setNumber(String number) {
this.number = number;
}

public List<Day> getDays() {
return days;
}

public void setDays(List<Day> days) {
this.days = days;
}

}