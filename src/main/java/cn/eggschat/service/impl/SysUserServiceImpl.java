package cn.eggschat.service.impl;

import cn.eggschat.dto.Result;
import cn.eggschat.entity.Sys_user;
import cn.eggschat.service.SysUnitService;
import cn.eggschat.service.SysUserService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;


@IocBean(args = {"refer:dao"})
public class SysUserServiceImpl extends BaseServiceImpl<Sys_user> implements SysUserService {


    @Inject
    SysUnitService sysUnitService;

    public SysUserServiceImpl(Dao dao) {
        super(dao);
    }

    @Override
    public Result register(String userName, String password, String email,String compayName) {
//        Sys_user dbUser = this.fetch(Cnd.where("loginname", "=", userName));
//        if (!Lang.isEmpty(dbUser)) {
//            return Result.ERROR("用户名已存在");
//        }
//
//        Sys_unit unit = new Sys_unit();
//        unit.setEmail("");
//        unit.setLogo("");
//        unit.setName(compayName);
//        unit.setNote(compayName);
//        unit.setPhone("");
//        sysUnitService.insert(unit);
//
//        //初始角色
//        List<Sys_role> roles = new ArrayList<>();
//
//        Sys_user user = new Sys_user();
//        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
//        String salt = rng.nextBytes().toBase64();
//        String hashedPasswordBase64 = new Sha256Hash(password, salt, 1024).toHex();
//        user.setSalt(salt);
//        user.setPassword(hashedPasswordBase64);
//        user.setLoginCount(0);
//        user.setLoginName(userName);
//        user.setUserName(userName);
//        user.setEmail(Strings.sBlank(email));
//        user.setUnitId(unit.getId());
//        user.setRoles(roles);
//        user.setMaxServiceCount(20); //默认10个最大有效服务数
//        user = this.insert(user);
//
//        this.insertRelation(user, "roles");


        return Result.SUCCESS("注册成功");
    }
}
