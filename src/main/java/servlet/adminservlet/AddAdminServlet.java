package servlet.adminservlet;

import model.User;
import service.AdminService;
import service.imp.AdminServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddAdminServlet",urlPatterns = "/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 请求和响应编码设置
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    //AddAdmin.jsp传过来的所有数据
    String u_id = request.getParameter("u_id");
    String u_name = request.getParameter("u_name");
    String u_password = request.getParameter("u_password");
    //将数据放入User JavaBean中
    User user = new User();
    user.setUId(Long.parseLong(u_id));
    user.setUName(u_name);
    user.setUPassword(u_password);
    //AdminService服务类
    AdminService adminService = new AdminServiceImp();
    //添加；并且返回添加了多少行数据
    int i = adminService.addUser(user);
    PrintWriter writer = response.getWriter();
    writer.write(String.valueOf(i));
  }
}
