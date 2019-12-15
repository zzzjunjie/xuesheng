package dao;

import model.Admin;
import model.User;
import utils.DaoUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
老师登陆查询
 */
public class AdminDao {

//  根据教师账号密码验证登陆信息是否正确，如果正确则返回相应的Admin对象，否则返回null
  public Admin queryAdminByIdAndPwd(Admin admin){
    Admin result = null;
    String sql = "select * from t_admin where t_id=? and t_password=?";
    ResultSet resultSet = null;
//    使用DaoUtils自定义工具类获取PreparedStatement
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    try {
      preparedStatement.setString(1, String.valueOf(admin.gettId()));
      preparedStatement.setString(2,admin.gettPassword());
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        result = new Admin();
        result.settId(resultSet.getInt("t_id"));
        result.settName(resultSet.getString("t_name"));
      }
    } catch (SQLException e) {
      System.out.println("查询不到Admin");
    }finally {
      if (resultSet!=null){
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(preparedStatement!=null){
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return result;
  }

  //查询所有用户
  public List<User> queryAllUser(){
    List<User> list = new ArrayList<>();
    //查询的sql语句
    String sql = "SELECT * FROM t_user";
    //获取statement对象用户查询
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    ResultSet resultSet = null;
    try {
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet.getFetchSize());
      while (resultSet.next()) {
        User user = new User();
        user.setUId(resultSet.getInt("u_id"));
        user.setUName(resultSet.getString("u_name"));
        user.setUPassword(resultSet.getString("u_password"));
        //放入list集合
        list.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if (resultSet!=null){
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(preparedStatement!=null){
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return list;
  }
  //添加一个用户
  public int addUser(User user){
    //插入学生的SQL语句
    String sql = "insert into t_user(u_id,u_name,u_password) values(?,?,?)";
    //标志，如果插入成功就是1，插入不成功就是0
    int count = 0;
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    try {
      preparedStatement.setString(1, String.valueOf(user.getUId()));
      preparedStatement.setString(2,user.getUName());
      preparedStatement.setString(3,user.getUPassword());
      //返回添加的条数
      count = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if (preparedStatement != null) {
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return count;
  }

  //删除一个或者多个用户,根据id删除
  public int deleteUserById(String u_id){
    //删除SQL语句  注：in是多删除
    String sql = "delete from t_user where u_id in "+u_id;
    //标志位 0为删除0条数据 其他值代表删除N条数据
    int count = 0;
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    try {
//      preparedStatement.setString(1, u_id);
      count = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if (preparedStatement!=null){
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
//    如果返回的count是0的话代表删除失败，1代表删除成功
    return count;
  }
  //修改用户信息,根据用户ID修改
  public int updateUserById(User user){
    //标志，返回0的话修改失败，返回1的话修改成功
    int count = 0;
    String sql = "UPDATE t_user set u_name=?,u_password=? WHERE u_id=?";
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    ResultSet resultSet = null;
    try {
      preparedStatement.setString(1,user.getUName());
      preparedStatement.setString(2,user.getUPassword());
      preparedStatement.setString(3, String.valueOf(user.getUId()));
      //修改的条数
      count = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if (resultSet!=null){
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (preparedStatement!=null){
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return count;
  }
  //根据ID查找用户
  public List<User> queryUserById(String u_id){
    List<User> list = new ArrayList<>();
    //查询的sql语句
    String sql = "SELECT * FROM t_user WHERE u_id=?";
    //获取statement对象用户查询
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    ResultSet resultSet = null;
    try {
      preparedStatement.setString(1,u_id);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        User user = new User();
        user.setUId(resultSet.getInt("u_id"));
        user.setUName(resultSet.getString("u_name"));
        user.setUPassword(resultSet.getString("u_password"));
        //放入list集合
        list.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if (resultSet!=null){
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(preparedStatement!=null){
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return list;
  }
  //根据姓名查找用户
  public List<User> queryUserByU_name(String u_name){
    List<User> list = new ArrayList<>();
    //查询的sql语句
    String sql = "SELECT * FROM t_user WHERE u_name=?";
    //获取statement对象用户查询
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    ResultSet resultSet = null;
    try {
      preparedStatement.setString(1,u_name);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        User user = new User();
        user.setUId(resultSet.getInt("u_id"));
        user.setUName(resultSet.getString("u_name"));
        user.setUPassword(resultSet.getString("u_password"));
        //放入list集合
        list.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if (resultSet!=null){
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(preparedStatement!=null){
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return list;
  }
}
