package servlet.adminservlet;

import service.AdminService;
import service.imp.AdminServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteUserByIdServlet",urlPatterns = "/DeleteUserByIdServlet")
public class DeleteUserByIdServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 请求和响应编码设置
    response.setHeader("content-type", "text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    //获取前端传入的用户编号
    String u_ids = request.getParameter("u_ids");
    System.out.println(u_ids);
    //AdminService操作的服务类
    AdminService adminService = new AdminServiceImp();
    //删除对应ID编号的用户，并且返回删除了多少条数据
    int i = adminService.deleteUserById(u_ids);
    PrintWriter writer = response.getWriter();
    writer.write(String.valueOf(i));
  }
}
