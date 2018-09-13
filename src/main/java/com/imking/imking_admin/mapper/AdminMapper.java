package com.imking.imking_admin.mapper;

import com.imking.imking_admin.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
   // 新增员工
   int inshert(Admin admin);
    //搜索所有数量，分页展示用，算出index；
   int selectCount();
   //分页查询，参数个数大于1，需要@param注解
   List<Admin> selectByPage(@Param("index")int index, @Param("limit")int limit);
   //搜索用户，登录用，对于密码
   Admin selectByName(String name);
}
