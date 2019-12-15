package servlet.teacherservlet;

import service.TeacherService;
import service.imp.TeacherServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditStudentResultServlet",urlPatterns = "/EditStudentResultServlet")
public class EditStudentResultServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 请求和响应编码设置
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    //获取前端传入的s_id 和 value，根据学生的学号修改学生的成绩
    String s_id = request.getParameter("s_id");
    String value = request.getParameter("value");
    System.out.println(s_id);
    //创建teacherService，用来操作数据
    TeacherService teacherService = new TeacherServiceImp();
    //根据学号更新学生的成绩
    int i = teacherService.EditStudentResultById(s_id, value);
    PrintWriter writer = response.getWriter();
    writer.write(String.valueOf(i));
  }
}
