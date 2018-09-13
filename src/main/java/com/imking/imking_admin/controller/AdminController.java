package com.imking.imking_admin.controller;

import com.imking.imking_admin.entity.Admin;
import com.imking.imking_admin.service.AdminService;
import com.imking.imking_admin.vo.PageVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    //新增员工
    @RequestMapping("/adminsave.do")
    public String adminsave(Admin admin) {
        if (adminService.save(admin)) {
            return "adminlist.html";
        }
        return "adminadd.html";
    }
    //分页查询
    @RequestMapping("/adminpage.do")
    @ResponseBody
    public PageVo<Admin> adminpage(int page, int limit) {
        return adminService.queryByPage(page,limit);

    }
    //员工登录
    @RequestMapping(value = "/adminlogin.do" ,method = RequestMethod.POST )
    public String adminlogin(String name, String password, String remberme, HttpSession session) {
        Admin admin = adminService.login(name, password);
        if (admin != null) {
            //进行shrio将进行结果告知shiro,获取syubject主题
            Subject subject = SecurityUtils.getSubject();
            //创建令牌
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            //尝试登陆
            subject.login(token);
            session.setAttribute("admin",admin);

            System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
            return "redirect:index.html";
        }
        return  "adminadd.html";
    }
}
