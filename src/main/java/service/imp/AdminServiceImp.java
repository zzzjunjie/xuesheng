package service.imp;

import dao.AdminDao;
import model.Admin;
import model.User;
import service.AdminService;

import java.util.List;

public class AdminServiceImp implements AdminService {
  AdminDao adminDao = new AdminDao();
  @Override
  public Admin queryAdminByIdAndPwd(Admin admin) {
    return adminDao.queryAdminByIdAndPwd(admin);
  }

  @Override
  public List<User> queryAllUser() {
    return adminDao.queryAllUser();
  }

  @Override
  public int updateUserById(User user) {
    return adminDao.updateUserById(user);
  }

  @Override
  public int deleteUserById(String u_id) {
    return adminDao.deleteUserById(u_id);
  }

  @Override
  public int addUser(User user) {
    return adminDao.addUser(user);
  }

  @Override
  public List<User> queryUserByU_name(String u_name) {
    return adminDao.queryUserByU_name(u_name);
  }

  @Override
  public List<User> queryUserById(String u_id) {
    return adminDao.queryUserById(u_id);
  }
}
