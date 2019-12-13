package servlet.teacherservlet;

import model.Admin;
import model.Student;
import model.Teacher;
import service.TeacherService;
import service.imp.TeacherServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddStudentServlet",urlPatterns = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 请求和响应编码设置
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    //获取老是的ID，因为要知道是谁添加的学生
    Admin admin = (Admin) request.getSession().getAttribute("teacher");
    //构建一个teacher对象用于查询条件
    Teacher teacher = new Teacher();
    teacher.setTId(admin.gettId());
    //老师服务类
    TeacherService teacherService = new TeacherServiceImp();
    //查询结果保存到teacher1里面
    Teacher teacher1 = teacherService.queryTeacherInfo(teacher);
    //获取老师教那个班级
    long t_cnum = teacher1.getTCnum();
    //获取前端传过来的数据
    String xsbh = request.getParameter("xsbh");
    String xsxm = request.getParameter("xsxm");
    String xsxb = request.getParameter("xsxb");
    String xsnj = request.getParameter("xsnj");
    String szbj = request.getParameter("szbj");
    String xsdh = request.getParameter("xsdh");
    String szxb = request.getParameter("szxb");
    String jtzz = request.getParameter("jtzz");

    //创建学生对象，用来保存该学生
    Student student = new Student();
    student.setSCnum(t_cnum);
    student.setSId(Integer.valueOf(xsbh));
    student.setSName(xsxm);
    student.setSSex(xsxb);
    student.setSGrade(xsnj);
    student.setSClass(szbj);
    student.setSPhone(xsdh);
    student.setSDepartment(szxb);
    student.setSAddress(jtzz);

    int i = teacherService.addStudent(student);
    PrintWriter writer = response.getWriter();
    writer.write(String.valueOf(i));
  }
}
