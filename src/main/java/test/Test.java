package test;

import dao.TeacherDao;
import model.Teacher;
import model.view.Teacher_Student;

import java.util.List;

public class Test {
  @org.junit.Test
  public void text1(){
    Teacher teacher = new Teacher();
    teacher.setTId(2001);
//    teacher.setTCid(2001);
    teacher.setTCnum(1);
    TeacherDao teacherDao = new TeacherDao();
    List<Teacher_Student> list = teacherDao.queryStudentByTeach(teacher);
    System.out.println(list.toString());
  }
}
