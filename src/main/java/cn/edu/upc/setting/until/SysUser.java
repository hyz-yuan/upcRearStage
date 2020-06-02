package cn.edu.upc.setting.until;

import cn.edu.upc.manage.model.User;

import javax.servlet.http.HttpSession;

public class SysUser {
    public static Integer getCurrentUserId(HttpSession session){
//        System.out.println(SecurityUtils.getSubject().getPrincipal());
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
        User user=(User) session.getAttribute("user");
        return user.getId();
    }
    public static Integer getCurrentUserRole(HttpSession session){
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
        User user=(User) session.getAttribute("user");
        return user.getRole();
    }
}
