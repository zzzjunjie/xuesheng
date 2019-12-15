package service;

import model.Student;
import model.Teacher;
import model.view.Teacher_Student;
import model.view.Teacher_Student_Class;

import java.util.List;

public interface TeacherService {
  //教师查询自己的所有学生
  public List<Teacher_Student> queryStudentByTeach(Teacher teacher);
  //教师查询所有学生信息
  public List<Teacher_Student> queryAllStudent();
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

  //根据学生学号修改学生成绩
  public int EditStudentResultById(String s_id,String value);
  //根据姓名查询学生课程成绩
  public List<Teacher_Student_Class> queryStudentResultByS_name(String name);
  //根据学号查找学生课程成绩
  public List<Teacher_Student_Class> queryStudentResultByS_id(String s_id);
  //查询所有的学生成绩
  public List<Teacher_Student_Class> queryAllStudentResult();
  //根据学生ID清除学生成绩
  public int deleteStudentResultById(String s_id);
}
