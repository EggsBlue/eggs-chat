package cn.eggschat.controllers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;


/**
*
* @author: eggsblue
* @date: 2020/8/29 19:52
**/
@IocBean
@Fail("http:500")
@At({"/","/home"})
public class HomeController extends AbsController {

    @At("")
    @Ok("re")
    public String home(){
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            return "redirect:/user/login";
        }
        return "beetl:/user/home.html";
    }

    @At("/logout")
    @Ok(">>:/user/login")
    public void logout(){
        SecurityUtils.getSubject().logout();
    }
}
