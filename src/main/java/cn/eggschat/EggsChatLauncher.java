package cn.eggschat;

import cn.eggschat.common.ig.RedisIdGenerator;
import org.nutz.boot.NbApp;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.el.opt.custom.CustomMake;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.ChainBy;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Modules;

/**
 * @author: Eggsblue
 * @date: 2020-08-24
 **/
@IocBean(create = "init")
@Encoding(input = "UTF-8", output = "UTF-8")
@Modules(packages = "cn.eggschat")
@ChainBy(args = "config/chain/mvc-chain.json")
public class EggsChatLauncher {
    private static final Log log = Logs.get();

    @Inject("refer:$ioc")
    private Ioc ioc;

    @Inject
    private PropertiesProxy conf;

    @Inject
    private Dao dao;

    public static void main(String[] args) throws Exception {
        NbApp nb = new NbApp().setArgs(args);
        nb.getAppContext().setMainPackage("cn.eggschat");
        nb.run();
    }

    public void init() {
        //注册主键生成器
        CustomMake.me().register("ig", ioc.get(RedisIdGenerator.class));

        // 通过POJO类创建表结构
        try {
            Daos.createTablesInPackage(dao, "cn.eggschat", false);
            //通过POJO类修改表结构
            Daos.migration(dao, "cn.eggschat", true, false);
        } catch (Exception e) {
            log.error(e);
        }
    }

}
