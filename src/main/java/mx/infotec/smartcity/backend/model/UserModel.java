package mx.infotec.smartcity.backend.model;

import java.io.Serializable;

import mx.infotec.smartcity.backend.model.RoleId;

public class UserModel implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private String name;
  
  private String familyName;
  
  private String email;
  
  private RoleId role;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public RoleId getRole() {
    return role;
  }

  public void setRole(RoleId role) {
    this.role = role;
  }
  
  
  

}