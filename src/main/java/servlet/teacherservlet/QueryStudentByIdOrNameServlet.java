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
    //教师功能的服务类，里面有教师的操作的所有方法
    TeacherService teacherService = new TeacherServiceImp();
    //接收后台返回查询到的学生
    List<Teacher_Student> teacher_students = null;
    //判断是否为数字，如果为数字就按照学号查询，如果是姓名就按照姓名查询
    //如果是数字返回true，否者返回false
    if (!str.equals("")){
      boolean flage = Character.isDigit(str.charAt(0));
      if(flage){
        //是数字，用学号查询
        teacher_students = teacherService.queryStudentById(str);
      }else{
        //不是数字，用姓名查询
        teacher_students = teacherService.queryStudentByName(str);
      }
    }else{
      //如果输入的是"" 则查询所有的学生成绩信息
      teacher_students = teacherService.queryAllStudent();
    }
    //用JsonData工具类格式化List对象变成一个Layui所需要的JSON格式
    JsonData jsonData = new JsonData();
    JSONObject jsonObject = jsonData.getJsonObject(teacher_students);
    PrintWriter writer = response.getWriter();
    writer.write(jsonObject.toString());
  }
}
