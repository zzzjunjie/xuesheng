package model;


public class Student {

  private long sId;
  private String sName;
  private String sSex;
  private String sAddress;
  private String sDepartment;
  private long sCnum;
  private String sClass;
  private String sGrade;
  private String sPhone;

  @Override
  public String toString() {
    return "Student{" +
     "sId=" + sId +
     ", sName='" + sName + '\'' +
     ", sSex='" + sSex + '\'' +
     ", sAddress='" + sAddress + '\'' +
     ", sDepartment='" + sDepartment + '\'' +
     ", sCnum=" + sCnum +
     ", sClass='" + sClass + '\'' +
     ", sGrade='" + sGrade + '\'' +
     ", sPhone='" + sPhone + '\'' +
     '}';
  }

  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public String getSName() {
    return sName;
  }

  public void setSName(String sName) {
    this.sName = sName;
  }


  public String getSSex() {
    return sSex;
  }

  public void setSSex(String sSex) {
    this.sSex = sSex;
  }


  public String getSAddress() {
    return sAddress;
  }

  public void setSAddress(String sAddress) {
    this.sAddress = sAddress;
  }


  public String getSDepartment() {
    return sDepartment;
  }

  public void setSDepartment(String sDepartment) {
    this.sDepartment = sDepartment;
  }


  public long getSCnum() {
    return sCnum;
  }

  public void setSCnum(long sCnum) {
    this.sCnum = sCnum;
  }


  public String getSClass() {
    return sClass;
  }

  public void setSClass(String sClass) {
    this.sClass = sClass;
  }


  public String getSGrade() {
    return sGrade;
  }

  public void setSGrade(String sGrade) {
    this.sGrade = sGrade;
  }


  public String getSPhone() {
    return sPhone;
  }

  public void setSPhone(String sPhone) {
    this.sPhone = sPhone;
  }

}
