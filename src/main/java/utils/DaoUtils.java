package utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
数据库连接
@URL 数据库连接，默认mysql
@USERNAME 数据库用户名
@PASSWORD 数据库密码
 */
public class DaoUtils {
  private static final String URL= "jdbc:mysql://39.108.108.125:3306/sc";
  private static final String USERNAME = "zhou";
  private static final String PASSWORD = "981127";

  //数据库操作
  private static  Connection connection;
  private static Statement statement;
  private static PreparedStatement preparedStatement;

  /*
  获取数据库连接
   */
  public static Connection getConnection(){
    try {
//      加载数据库驱动类
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  /*
  实例化Statement对象
   */
  public static Statement getStatement(){
    if (connection==null){
      getConnection();
    }
    try {
      statement = connection.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return statement;
  }

  /*
  sql 传入sql语句，预处理sql
   */
  public static PreparedStatement getPreparedStatement(String sql){
    if (connection==null){
      getConnection();
    }
    try {
      preparedStatement = connection.prepareStatement(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return preparedStatement;
  }

  //将一个resultSet转换成List
  public static List populate(ResultSet rs , Class clazz) throws SQLException, InstantiationException, IllegalAccessException{
    //结果集的元素对象
    ResultSetMetaData rsmd = rs.getMetaData();
    //获取结果集的元素个数
    int colCount = rsmd.getColumnCount();
//         System.out.println("#");
//         for(int i = 1;i<=colCount;i++){
//             System.out.println(rsmd.getColumnName(i));
//             System.out.println(rsmd.getColumnClassName(i));
//             System.out.println("#");
//         }
    //返回结果的列表集合
    List list = new ArrayList();
    //业务对象的属性数组
    Field[] fields = clazz.getDeclaredFields();
    while(rs.next()){//对每一条记录进行操作
      Object obj = clazz.newInstance();//构造业务对象实体
      //将每一个字段取出进行赋值
      for(int i = 1;i<=colCount;i++){
        Object value = rs.getObject(i);
        //寻找该列对应的对象属性
        for(int j=0;j<fields.length;j++){
          Field f = fields[j];
          //如果匹配进行赋值
          if(f.getName().equalsIgnoreCase(rsmd.getColumnName(i))){
            boolean flag = f.isAccessible();
            f.setAccessible(true);
            f.set(obj, value);
            f.setAccessible(flag);
          }
        }
      }
      list.add(obj);
    }
    return list;
  }
}
