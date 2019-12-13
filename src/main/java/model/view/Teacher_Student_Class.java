package model.view;

public class Teacher_Student_Class {
  private Integer s_id;  //学生id
  private String s_name;//学生姓名
  private String s_sex;//学生性别
  private String s_department;//学生所在院系
  private String s_class;//学生所在班级
  private String s_grade;//学生所在年级
  private String c_name;//课程名
  private Integer c_result;//课程分数
  private String t_id;//教师id

  public Teacher_Student_Class() {
  }

  @Override

  public String toString() {
    return "Teacher_Student_Class{" +
     "s_id=" + s_id +
     ", s_name='" + s_name + '\'' +
     ", s_sex='" + s_sex + '\'' +
     ", s_department='" + s_department + '\'' +
     ", s_class='" + s_class + '\'' +
     ", s_grade='" + s_grade + '\'' +
     ", c_name='" + c_name + '\'' +
     ", c_result=" + c_result +
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

  public String getC_name() {
    return c_name;
  }

  public void setC_name(String c_name) {
    this.c_name = c_name;
  }

  public Integer getC_result() {
    return c_result;
  }

  public void setC_result(Integer c_result) {
    this.c_result = c_result;
  }

  public String getT_id() {
    return t_id;
  }

  public void setT_id(String t_id) {
    this.t_id = t_id;
  }

  public Teacher_Student_Class(Integer s_id, String s_name,
                               String s_sex, String s_department,
                               String s_class, String s_grade,
                               String c_name, Integer c_result, String t_id) {
    this.s_id = s_id;
    this.s_name = s_name;
    this.s_sex = s_sex;
    this.s_department = s_department;
    this.s_class = s_class;
    this.s_grade = s_grade;
    this.c_name = c_name;
    this.c_result = c_result;
    this.t_id = t_id;
  }
}
