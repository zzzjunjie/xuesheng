package servlet.teacherservlet;

import com.alibaba.fastjson.JSONObject;
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

@WebServlet(name = "QueryStudentByIdOrNameServlet",urlPatterns = "/QueryStudentByIdOrName")
public class QueryStudentByIdOrNameServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 请求和响应编码设置
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    //获取前端编辑框所输入的内容
    String str = request.getParameter("str");
    //判断是否为数字，如果为数字就按照学号查询，如果是姓名就按照姓名查询
    //如果是数字返回true，否者返回false
    boolean flage = Character.isDigit(str.charAt(0));
    TeacherService teacherService = new TeacherServiceImp();
    //接收后台返回查询到的学生
    List<Teacher_Student> teacher_students = null;
    if(flage){
      //是数字，用学号查询
      teacher_students = teacherService.queryStudentById(str);
    }else{
      //不是数字，用姓名查询
      teacher_students = teacherService.queryStudentByName(str);
    }
    //用JsonData工具类格式化List对象变成一个Layui所需要的JSON格式
    JsonData jsonData = new JsonData();
    JSONObject jsonObject = jsonData.getJsonObject(teacher_students);
    PrintWriter writer = response.getWriter();
    writer.write(jsonObject.toString());

  }
}
