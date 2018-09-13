package com.imking.imking_admin.service.impl;

import com.imking.imking_admin.entity.Admin;
import com.imking.imking_admin.mapper.AdminMapper;
import com.imking.imking_admin.service.AdminService;
import com.imking.imking_admin.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

//@Transactional 声明本类下面所有的方法都参与事务
@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public boolean save(Admin admin) {
        return adminMapper.inshert(admin) > 0;
    }

    @Override
    public PageVo<Admin> queryByPage(int page, int limit) {
        int index = (page -1) * limit;
        return new PageVo<>(adminMapper.selectCount(),adminMapper.selectByPage(index,limit));
    }

    @Override
    public Admin login(String name, String password) {
        //判断这个结果是否为null
        if (adminMapper.selectByName(name) != null) {
            if (Objects.equals(adminMapper.selectByName(name).getPassword(),password)) {
                return adminMapper.selectByName(name);
            }
        }
        return null;
    }
}
