package service;

import model.Student;
import model.Teacher;
import model.view.Teacher_Student;
import model.view.Teacher_Student_Class;

import java.util.List;

public interface TeacherService {
  //教师查询自己的所有学生
  public List<Teacher_Student> queryStudentByTeach(Teacher teacher);
//  查询所有学生成绩
  public List<Teacher_Student_Class> queryStudentResultByTid(Teacher teacher);
//    修改学生信息
  public int UpdateStudenInfoById(Teacher_Student teacher_student);
//  删除学生
  public int DeleteStudentById(String s_id);
//  查询登陆教师信息
  public Teacher queryTeacherInfo(Teacher teacher);
  //老师添加学生
  public int addStudent(Student student);

  //根据学号查询学生
  public List<Teacher_Student> queryStudentByName(String name);

  //用学号查询学生
  public List<Teacher_Student> queryStudentById(String id);
}
