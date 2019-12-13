package dao;

import model.Student;
import model.Teacher;
import model.view.Teacher_Student;
import model.view.Teacher_Student_Class;
import utils.DaoUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
教师相关操作
 */
public class TeacherDao {
  //教师查询自己的所有学生
  public List<Teacher_Student> queryStudentByTeach(Teacher teacher){
    String sql = " SELECT * FROM teacher_student where t_id =? ";
    List<Teacher_Student> list = new ArrayList<>();
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    try {
      preparedStatement.setString(1, String.valueOf(teacher.getTId()));
      resultSet = preparedStatement.executeQuery();
      //将查询到的每一行数据放入list集合
      while (resultSet.next()) {
        Teacher_Student ts = new Teacher_Student();
        ts.setT_id(resultSet.getString("t_id"));
        ts.setS_id(Integer.valueOf(resultSet.getString("s_id")));
        ts.setS_name(resultSet.getString("s_name"));
        ts.setS_sex(resultSet.getString("s_sex"));
        ts.setS_address(resultSet.getString("s_address"));
        ts.setS_department(resultSet.getString("s_department"));
        ts.setS_class(resultSet.getString("s_class"));
        ts.setS_grade(resultSet.getString("s_grade"));
        ts.setS_phone(resultSet.getString("s_phone"));
        ts.setS_cnum(resultSet.getInt("s_cnum"));
        //加入list
        list.add(ts);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }//关闭连接
    finally {
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
  return list;
  }

//  根据教师编号查询该老师所有学生
  public List<Teacher_Student_Class> queryStudentResultByTid(Teacher teacher){
    List<Teacher_Student_Class> list = new ArrayList<>();
    String sql = "select *from teacher_student_class where t_id=?";
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    ResultSet resultSet = null;
    try {
      preparedStatement.setInt(1, (int) teacher.getTId());
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Teacher_Student_Class teacher_student_class = new Teacher_Student_Class();
        teacher_student_class.setS_id(resultSet.getInt("s_id"));
        teacher_student_class.setC_name(resultSet.getString("c_name"));
        teacher_student_class.setC_result(resultSet.getInt("c_result"));
        teacher_student_class.setS_class(resultSet.getString("s_class"));
        teacher_student_class.setS_department(resultSet.getString("s_department"));
        teacher_student_class.setS_grade(resultSet.getString("s_grade"));
        teacher_student_class.setS_sex(resultSet.getString("s_sex"));
        teacher_student_class.setS_name(resultSet.getString("s_name"));
        list.add(teacher_student_class);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    //关闭连接
    finally {
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
    return list;
  }

  //教师修改学生信息
  public int UpdateStudenInfoById(Teacher_Student teacher_student){
    //标志，返回0的话修改失败，返回1的话修改成功
    int count = 0;
    String sql = "UPDATE teacher_student set s_name=?,s_sex=?,s_address=?,s_department=?,s_class=?,s_grade=?,s_phone=? where s_id=?";
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    ResultSet resultSet = null;
    try {
      preparedStatement.setString(1,teacher_student.getS_name());
      preparedStatement.setString(2,teacher_student.getS_sex());
      preparedStatement.setString(3,teacher_student.getS_address());
      preparedStatement.setString(4,teacher_student.getS_department());
      preparedStatement.setString(5,teacher_student.getS_class());
      preparedStatement.setString(6,teacher_student.getS_grade());
      preparedStatement.setString(7,teacher_student.getS_phone());
      preparedStatement.setInt(8, teacher_student.getS_id());
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

  //根据学生Id删除学生
  public int DeleteStudentById(String s_id){//s_id的数据格式为(x,x,x,x)
    //删除SQL语句  注：in是多删除
    String sql = "delete from t_student where s_id in "+s_id;
    //标志位 0为删除0条数据 其他值代表删除N条数据
    int count = 0;
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    try {
//      preparedStatement.setString(1, s_id);
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
//查询老师个人信息
  public Teacher queryTeacherById(Teacher teacher) {
    Teacher result = null;
    String sql = "select * from t_teacher where t_id = ?";
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    ResultSet resultSet = null;
    try {
      preparedStatement.setString(1, String.valueOf(teacher.getTId()));
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        result = new Teacher();
       result.setTId(resultSet.getInt("t_id"));
       result.setTName(resultSet.getString("t_name"));
       result.setTYear(resultSet.getString("t_year"));
       result.setTProfessional(resultSet.getString("t_professional"));
       result.setTCid(resultSet.getInt("t_cid"));
       result.setTCnum(resultSet.getInt("t_cnum"));
       result.setTPhone(resultSet.getString("t_phone"));
       result.setTCname(resultSet.getString("t_cname"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (preparedStatement != null) {
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return result;
    }
  }
  //添加一个学生
  public int addStudent(Student student){
    //插入学生的SQL语句
    String sql = "insert into t_student(s_id,s_name,s_sex,s_address,s_department,s_cnum,s_class,s_grade,s_phone) values(?,?,?,?,?,?,?,?,?)";
    //标志，如果插入成功就是1，插入不成功就是0
    int count = 0;
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    try {
      preparedStatement.setString(1, String.valueOf(student.getSId()));
      preparedStatement.setString(2,student.getSName());
      preparedStatement.setString(3,student.getSSex());
      preparedStatement.setString(4,student.getSAddress());
      preparedStatement.setString(5,student.getSDepartment());
      preparedStatement.setString(6, String.valueOf(student.getSCnum()));
      preparedStatement.setString(7, student.getSClass());
      preparedStatement.setString(8,student.getSGrade());
      preparedStatement.setString(9,student.getSPhone());

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
  //用学生的姓名查询学生
  public List<Teacher_Student> queryStudentByName(String name){
    String sql = " SELECT * FROM teacher_student where s_name =? ";
    List<Teacher_Student> list = new ArrayList<>();
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    try {
      preparedStatement.setString(1,name);
      resultSet = preparedStatement.executeQuery();
      //将查询到的每一行数据放入list集合
      while (resultSet.next()) {
        Teacher_Student ts = new Teacher_Student();
        ts.setT_id(resultSet.getString("t_id"));
        ts.setS_id(Integer.valueOf(resultSet.getString("s_id")));
        ts.setS_name(resultSet.getString("s_name"));
        ts.setS_sex(resultSet.getString("s_sex"));
        ts.setS_address(resultSet.getString("s_address"));
        ts.setS_department(resultSet.getString("s_department"));
        ts.setS_class(resultSet.getString("s_class"));
        ts.setS_grade(resultSet.getString("s_grade"));
        ts.setS_phone(resultSet.getString("s_phone"));
        ts.setS_cnum(resultSet.getInt("s_cnum"));
        //加入list
        list.add(ts);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }//关闭连接
    finally {
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
    return list;
  }
  //用学号查询学生
  public List<Teacher_Student> queryStudentById(String id){
    //查询的sql语句
    String sql = " SELECT * FROM teacher_student where s_id =? ";
    List<Teacher_Student> list = new ArrayList<>();
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = DaoUtils.getPreparedStatement(sql);
    try {
      preparedStatement.setString(1,id);
      resultSet = preparedStatement.executeQuery();
      //将查询到的每一行数据放入list集合
      while (resultSet.next()) {
        Teacher_Student ts = new Teacher_Student();
        ts.setT_id(resultSet.getString("t_id"));
        ts.setS_id(Integer.valueOf(resultSet.getString("s_id")));
        ts.setS_name(resultSet.getString("s_name"));
        ts.setS_sex(resultSet.getString("s_sex"));
        ts.setS_address(resultSet.getString("s_address"));
        ts.setS_department(resultSet.getString("s_department"));
        ts.setS_class(resultSet.getString("s_class"));
        ts.setS_grade(resultSet.getString("s_grade"));
        ts.setS_phone(resultSet.getString("s_phone"));
        ts.setS_cnum(resultSet.getInt("s_cnum"));
        //加入list
        list.add(ts);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }//关闭连接
    finally {
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
    return list;
  }
}
