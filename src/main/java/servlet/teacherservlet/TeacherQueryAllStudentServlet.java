package servlet.teacherservlet;

import model.Admin;
import model.Teacher;
import model.view.Teacher_Student;
import service.TeacherService;
import service.imp.TeacherServiceImp;
import utils.JsonData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TeacherQueryAllStudentServlet",urlPatterns = "/TeacherQueryAllStudentServlet")
public class TeacherQueryAllStudentServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 请求和响应编码设置
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    //获取老师对象，将老师的id放入teacher对象中
    Admin admin = (Admin) request.getSession().getAttribute("teacher");
    Teacher teacher = new Teacher();
    teacher.setTId(admin.gettId());

    //调用teacherService查询该老师所教班级的学生
    TeacherService teacherService = new TeacherServiceImp();
    List<Teacher_Student> list = teacherService.queryStudentByTeach(teacher);
    //格式化List对象到Layui所需要的JSON数据格式
    JsonData jsonData  = new JsonData();
    String s = jsonData.getJsonObject(list).toString();
    PrintWriter writer = response.getWriter();
    writer.write(s);
  }
}
