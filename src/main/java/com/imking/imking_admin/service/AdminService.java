package com.imking.imking_admin.service;

import com.imking.imking_admin.entity.Admin;
import com.imking.imking_admin.vo.PageVo;

public interface AdminService {
    boolean save(Admin admin);

    PageVo<Admin> queryByPage(int page,int limit);

    Admin login(String name,String password);
}
