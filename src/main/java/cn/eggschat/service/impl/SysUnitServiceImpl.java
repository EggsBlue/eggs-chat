package cn.eggschat.service.impl;

import cn.eggschat.entity.Sys_unit;
import cn.eggschat.service.SysUnitService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class SysUnitServiceImpl extends BaseServiceImpl<Sys_unit> implements SysUnitService {
    public SysUnitServiceImpl(Dao dao) {
        super(dao);
    }
}
