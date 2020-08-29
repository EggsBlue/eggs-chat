package cn.eggschat;

import org.nutz.boot.NbApp;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Modules;

/**
 * @author: Eggsblue
 * @date: 2020-08-24
 **/
@IocBean(create = "init", depose = "depose")
@Encoding(input = "UTF-8", output = "UTF-8")
@Modules(packages = "cn.eggschat")
public class EggsChatLauncher {
    private static final Log log = Logs.get();

    @Inject("refer:$ioc")
    private Ioc ioc;

    @Inject
    private PropertiesProxy conf;

    public static void main(String[] args) throws Exception {
        NbApp nb = new NbApp().setArgs(args);
        nb.getAppContext().setMainPackage("cn.eggschat");
        nb.run();
    }

    public void init() {

    }

    public void depose() {

    }

}
