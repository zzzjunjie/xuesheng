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

@WebServlet(name = "DeleteStudentServlet",urlPatterns = "/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 请求和响应编码设置
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    String xsbh = request.getParameter("xsbh");
    TeacherService teacherService = new TeacherServiceImp();
    int i = teacherService.DeleteStudentById(xsbh);
    PrintWriter writer = response.getWriter();
    writer.write(String.valueOf(i));
  }
}
