package servlet.teacherservlet;

import model.view.Teacher_Student;
import service.TeacherService;
import service.imp.TeacherServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateStudentInfoServlet",urlPatterns = "/UpdateStudentInfoServlet")
public class UpdateStudentInfoServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("utf-8");
    // 请求和响应编码设置
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    TeacherService teacherService = new TeacherServiceImp();
    //接收editStudentInfo.jsp传过来的所有数据
    String xsbh = request.getParameter("xsbh");
    String xsxm = request.getParameter("xsxm");
    String xsxb = request.getParameter("xsxb");
    String xsnj = request.getParameter("xsnj");
    String szbj = request.getParameter("szbj");
    String xsdh = request.getParameter("xsdh");
    String szxb = request.getParameter("szxb");
    String jtzz = request.getParameter("jtzz");
    //将数据放入Teacher_Student视图中
    Teacher_Student student = new Teacher_Student();
    student.setS_id(Integer.valueOf(xsbh));
    student.setS_name(xsxm);
    student.setS_sex(xsxb);
    student.setS_grade(xsnj);
    student.setS_class(szbj);
    student.setS_phone(xsdh);
    student.setS_department(szxb);
    student.setS_address(jtzz);

    int i = teacherService.UpdateStudenInfoById(student);
    PrintWriter writer = response.getWriter();
    writer.write(String.valueOf(i));
  }
}
