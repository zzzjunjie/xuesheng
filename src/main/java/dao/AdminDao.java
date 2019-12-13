package dao;

import model.Admin;
import utils.DaoUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
老师登陆查询
 */
public class AdminDao {

//  根据教师账号密码验证登陆信息是否正确，如果正确则返回相应的Admin对象，否则返回null
  public Admin queryAdminByIdAndPwd(Admin admin){
    System.out.println(admin);
    Admin result = null;
    String sql = "select * from t_admin where t_id=? and t_password=?";
//    使用DaoUtils自定义工具类获取PreparedStatement
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    try {
      preparedStatement.setString(1, String.valueOf(admin.gettId()));
      preparedStatement.setString(2,admin.gettPassword());
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        result = new Admin();
        result.settId(resultSet.getInt("t_id"));
        result.settName(resultSet.getString("t_name"));
      }
    } catch (SQLException e) {
      System.out.println("查询不到Admin");
    }
    return result;
  }



}
