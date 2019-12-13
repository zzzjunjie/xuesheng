package model;


public class Admin {

  private Integer tId;
  private String tName;
  private String tPassword;

  @Override
  public String toString() {
    return "Admin{" +
     "tId=" + tId +
     ", tName='" + tName + '\'' +
     ", tPassword='" + tPassword + '\'' +
     '}';
  }

  public Integer gettId() {
    return tId;
  }

  public void settId(Integer tId) {
    this.tId = tId;
  }

  public String gettName() {
    return tName;
  }

  public void settName(String tName) {
    this.tName = tName;
  }

  public String gettPassword() {
    return tPassword;
  }

  public void settPassword(String tPassword) {
    this.tPassword = tPassword;
  }

  public Admin() {

  }

  public Admin(Integer tId, String tPassword) {

    this.tId = tId;
    this.tPassword = tPassword;
  }
}
