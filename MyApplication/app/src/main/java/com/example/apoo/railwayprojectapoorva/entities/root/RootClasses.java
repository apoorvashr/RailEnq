package com.example.apoo.railwayprojectapoorva.entities.root;

import java.io.Serializable;

/**
 * Created by Apoo on 7/14/2017.
 */

public class RootClasses implements Serializable {

      String classcode;
      String availablity;

     public RootClasses(String classcode, String availablity) {
          this.classcode = classcode;
          this.availablity = availablity;
     }

     public RootClasses() {
     }

     public String getClasscode() {
          return classcode;
     }

     public void setClasscode(String classcode) {
          this.classcode = classcode;
     }

     public String getAvailablity() {
          return availablity;
     }

     public void setAvailablity(String availablity) {
          this.availablity = availablity;
     }
}
