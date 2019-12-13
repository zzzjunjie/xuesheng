package servlet.adminservlet;

import model.Admin;
import service.AdminService;
import service.imp.AdminServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet",urlPatterns = "/AdminServlet")
public class AdminServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //设置请求编码
    response.setCharacterEncoding("UTF-8");
    response.setHeader("contentType", "text/html; charset=utf-8");
    //获取前端输入的数据
    Integer id = Integer.valueOf(request.getParameter("u"));
    String password = request.getParameter("p");
    //pow为标志位,代表教师(2) or 学生(1)
    Integer pow = Integer.valueOf(request.getParameter("POW"));
    switch (pow){
      //学生登陆
      case 1:
        //等待补充
        break;
        //教师登陆
      case 2:
        Admin admin = new Admin(id,password);
        AdminService adminService = new AdminServiceImp();
        Admin result = adminService.queryAdminByIdAndPwd(admin);
//        System.out.println(result);
        if(result!=null){
          request.getSession().setAttribute("teacher",result);
          request.getRequestDispatcher("/teacher/main.jsp").forward(request,response);
        }else{
         request.setAttribute("error",400);
         request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        break;
    }
  }
}
