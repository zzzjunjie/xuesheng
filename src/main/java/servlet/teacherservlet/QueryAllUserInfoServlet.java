package servlet.teacherservlet;

import model.User;
import service.AdminService;
import service.imp.AdminServiceImp;
import utils.JsonData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QueryAllUserInfoServlet",urlPatterns = "/QueryAllUserInfoServlet")
public class QueryAllUserInfoServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 请求和响应编码设置
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    //管理员查询类
    AdminService adminService = new AdminServiceImp();
    //查询所有用户
    List<User> list = adminService.queryAllUser();
    //将返回的用户信息转换成layui所需要的JSON数据格式
    JsonData jsonData = new JsonData();
    String s = jsonData.getJsonObject(list).toString();
    PrintWriter writer = response.getWriter();
    writer.write(s);
  }
}
