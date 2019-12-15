package service;

import model.Admin;
import model.User;

import java.util.List;

public interface AdminService {
  //根据Admin对象的id查询
  public Admin queryAdminByIdAndPwd(Admin admin);
  //查询所有用户
  public List<User> queryAllUser();
  //修改用户信息,根据用户ID修改
  public int updateUserById(User user);
  //删除一个或者多个用户,根据id删除
  public int deleteUserById(String u_id);
  //添加一个用户
  public int addUser(User user);
  //根据姓名查找用户
  public List<User> queryUserByU_name(String u_name);
  //根据ID查找用户
  public List<User> queryUserById(String u_id);
}
