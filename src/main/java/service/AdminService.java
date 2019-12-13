package service;

import model.Admin;

public interface AdminService {
  //根据Admin对象的id查询
  public Admin queryAdminByIdAndPwd(Admin admin);
}
