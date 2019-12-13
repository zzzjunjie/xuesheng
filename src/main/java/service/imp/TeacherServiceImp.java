package service.imp;

import dao.TeacherDao;
import model.Student;
import model.Teacher;
import model.view.Teacher_Student;
import model.view.Teacher_Student_Class;
import service.TeacherService;

import java.util.List;

public class TeacherServiceImp implements TeacherService {
  TeacherDao teacherDao = new TeacherDao();
  @Override
  public List<Teacher_Student> queryStudentByTeach(Teacher teacher) {
    return teacherDao.queryStudentByTeach(teacher);
  }

  @Override
  public List<Teacher_Student_Class> queryStudentResultByTid(Teacher teacher) {
    return teacherDao.queryStudentResultByTid(teacher);
  }

  @Override
  public int UpdateStudenInfoById(Teacher_Student teacher_student) {
    return teacherDao.UpdateStudenInfoById(teacher_student);
  }

  @Override
  public int DeleteStudentById(String s_id) {
    return teacherDao.DeleteStudentById(s_id);
  }

  @Override
  public Teacher queryTeacherInfo(Teacher teacher) {
    return teacherDao.queryTeacherById(teacher);
  }

  @Override
  public int addStudent(Student student) {
    return teacherDao.addStudent(student);
  }

  @Override
  public List<Teacher_Student> queryStudentByName(String name) {
    return teacherDao.queryStudentByName(name);
  }

  @Override
  public List<Teacher_Student> queryStudentById(String id) {
    return teacherDao.queryStudentById(id);
  }

}
