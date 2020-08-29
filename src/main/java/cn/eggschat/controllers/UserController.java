package cn.eggschat.controllers;

import cn.eggschat.dto.Result;
import cn.eggschat.entity.Sys_user;
import cn.eggschat.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.*;

/**
 * @author: eggsblue
 * @date: 2020/8/29 19:49
 **/
@At("/user")
@IocBean
@Fail("http:500")
public class UserController extends AbsController {

    @Inject
    private SysUserService sysUserService;

    @At("/login")
    @Ok("re")
    @Filters
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/home";
        } else {
            return "beetl:/user/login.html";
        }
    }

    @At("/register")
    @Ok("re")
    @Filters
    public String register() {
//        Subject subject = SecurityUtils.getSubject();
//        if (subject.isAuthenticated()) {
//            return "redirect:/home";
//        }else{
        return "beetl:/user/register.html";
//        }
    }

    /**
     * 登陆
     *
     * @param userName
     * @param password
     * @return
     */
    @At("/doLogin")
    @Ok("json")
    public Result doLogin(@Param("userName") String userName, @Param("password") String password) {
        if (Strings.isBlank(userName)) {
            return Result.ERROR("请填写账号");
        }
        if (Strings.isBlank(password)) {
            return Result.ERROR("请填写密码");
        }

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return success();
        } catch (LockedAccountException e1) {
            log.error(e1);
            return error("登陆失败,账号已锁定");
        } catch (UnknownAccountException e2) {
            log.error(e2);
            return error("登陆失败,用户名不存在");
        } catch (AuthenticationException e3) {
            log.error(e3);
            return error("登陆失败,密码错误");
        } catch (Exception e4) {
            log.error(e4);
            return error("登陆失败");
        }
    }

    /**
     * 注册
     *
     * @param userName
     * @param password
     * @param email
     * @param compayName
     * @return
     */
    @At("/doReg")
    @Ok("json")
    @Filters
    public Result doReg( @Param("email") String email,@Param("password") String password, @Param("compayName") String compayName) {
        try {
            if (Strings.isBlank(password)) {
                return error("请填写密码");
            }

            if (password.length() < 6) {
                return error("密码长度太短了");
            }
            if (Strings.isBlank(compayName)) {
                return error("请填写公司名");
            }

            if (Strings.isBlank(email)) {
                return error("请输入邮箱");
            }
            if (!Strings.isEmail(email)) {
                return error("请输入正确的邮箱");
            }
            return sysUserService.register(email, password, compayName);
        } catch (Exception e) {
            log.error(e);
            return error("系统繁忙,请稍后再试");
        }
    }


    @At("/pwd/update")
    @Ok("json")
    @POST
    @AdaptBy(type = JsonAdaptor.class)
    @RequiresAuthentication
    public Object save(@Param("oldPwd") String oldPwd, @Param("newPwd") String newPwd, @Param("conformPwd") String conformPwd, @Attr("uid") String uid) {
        try {
            Sys_user user = sysUserService.fetch(uid);
            if (Strings.isBlank(oldPwd)) {
                return error("请填写原密码");
            }
            if (Strings.isBlank(newPwd)) {
                return error("请填写新密码");
            }
            if (Strings.isBlank(conformPwd)) {
                return error("请填写确认密码");
            }

            if (!newPwd.equals(conformPwd)) {
                return error("两次密码填写不一致");
            }

            String oldPwd_ = new Sha256Hash(oldPwd, user.getSalt(), 1024).toHex();
            if (!oldPwd_.equals(user.getPassword())) {
                return error("原密码不正确");
            }
            sysUserService.update(Chain.make("password", new Sha256Hash(newPwd, user.getSalt(), 1024).toHex()), Cnd.where("id", "=", user.getId()));
            return success();
        } catch (Exception e) {
            log.error(e);
            return error("系统繁忙,请稍后再试");
        }
    }

}
