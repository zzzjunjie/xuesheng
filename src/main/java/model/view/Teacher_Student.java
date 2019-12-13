package model.view;

public class Teacher_Student {
  private Integer s_id;  //学生id
  private String s_name;//学生姓名
  private String s_sex;//学生性别
  private String s_address;//学生住址
  private String s_department;//学生所在院系
  private String s_class;//学生所在班级
  private String s_grade;//学生所在年级
  private String s_phone;//学生电话
  private Integer s_cnum;//学生课程号
  private String t_id;//教师id

  @Override
  public String toString() {
    return "Teacher_Student{" +
     "s_id=" + s_id +
     ", s_name='" + s_name + '\'' +
     ", s_sex='" + s_sex + '\'' +
     ", s_address='" + s_address + '\'' +
     ", s_department='" + s_department + '\'' +
     ", s_class='" + s_class + '\'' +
     ", s_grade='" + s_grade + '\'' +
     ", s_phone='" + s_phone + '\'' +
     ", s_cnum=" + s_cnum +
     ", t_id='" + t_id + '\'' +
     '}';
  }

  public Integer getS_id() {
    return s_id;
  }

  public void setS_id(Integer s_id) {
    this.s_id = s_id;
  }

  public String getS_name() {
    return s_name;
  }

  public void setS_name(String s_name) {
    this.s_name = s_name;
  }

  public String getS_sex() {
    return s_sex;
  }

  public void setS_sex(String s_sex) {
    this.s_sex = s_sex;
  }

  public String getS_address() {
    return s_address;
  }

  public void setS_address(String s_address) {
    this.s_address = s_address;
  }

  public String getS_department() {
    return s_department;
  }

  public void setS_department(String s_department) {
    this.s_department = s_department;
  }

  public String getS_class() {
    return s_class;
  }

  public void setS_class(String s_class) {
    this.s_class = s_class;
  }

  public String getS_grade() {
    return s_grade;
  }

  public void setS_grade(String s_grade) {
    this.s_grade = s_grade;
  }

  public String getS_phone() {
    return s_phone;
  }

  public void setS_phone(String s_phone) {
    this.s_phone = s_phone;
  }

  public Integer getS_cnum() {
    return s_cnum;
  }

  public void setS_cnum(Integer s_cnum) {
    this.s_cnum = s_cnum;
  }

  public String getT_id() {
    return t_id;
  }

  public void setT_id(String t_id) {
    this.t_id = t_id;
  }

  public Teacher_Student() {
  }

  public Teacher_Student(Integer s_id, String s_name, String s_sex, String s_address, String s_department, String s_class, String s_grade, String s_phone, Integer s_cnum, String t_id) {
    this.s_id = s_id;
    this.s_name = s_name;
    this.s_sex = s_sex;
    this.s_address = s_address;
    this.s_department = s_department;
    this.s_class = s_class;
    this.s_grade = s_grade;
    this.s_phone = s_phone;
    this.s_cnum = s_cnum;
    this.t_id = t_id;
  }
}
