package service.imp;

import dao.AdminDao;
import model.Admin;
import service.AdminService;

public class AdminServiceImp implements AdminService {
  AdminDao adminDao = new AdminDao();
  @Override
  public Admin queryAdminByIdAndPwd(Admin admin) {
    return adminDao.queryAdminByIdAndPwd(admin);
  }
}
