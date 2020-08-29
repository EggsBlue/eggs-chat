package cn.eggschat.service.impl;

import cn.eggschat.dto.Result;
import cn.eggschat.entity.Sys_unit;
import cn.eggschat.entity.Sys_user;
import cn.eggschat.service.SysUnitService;
import cn.eggschat.service.SysUserService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.Times;
import org.nutz.lang.random.R;

@IocBean(args = {"refer:dao"})
public class SysUserServiceImpl extends BaseServiceImpl<Sys_user> implements SysUserService {

    @Inject
    SysUnitService sysUnitService;

    public SysUserServiceImpl(Dao dao) {
        super(dao);
    }

    @Override
    @Aop(TransAop.READ_COMMITTED)
    public Result register(String email, String password, String compayName) {
        Sys_user dbUser = fetch(Cnd.where("email", "=", email));
        if (!Lang.isEmpty(dbUser)) {
            return Result.ERROR("用户名已存在");
        }

        Sys_unit unit = new Sys_unit();
        unit.setName(compayName);
        unit.setToken(R.UU32());
        unit.setTitle(compayName);
        unit.setSub_title("");
        unit.setGreeting("");
        unit.setPlaceholder("请输入内容");
        unit.setColor("#1890FF");

        unit = sysUnitService.insert(unit);

        Sys_user user = new Sys_user();
        user.setEmail(email);
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        String salt = rng.nextBytes().toBase64();
        String hashedPasswordBase64 = new Sha256Hash(password, salt, 1024).toHex();
        user.setSalt(salt);
        user.setPassword(hashedPasswordBase64);
        user.setFull_name(compayName);
        user.setDisplay_name(compayName);
        user.setJoin_time(Times.getTS());
        user.setAdmin(true);
        user.setUnit_id(unit.getId());
        this.insert(user);

        return Result.SUCCESS("注册成功");
    }
}
