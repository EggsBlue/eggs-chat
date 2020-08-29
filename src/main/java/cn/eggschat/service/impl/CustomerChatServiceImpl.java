package cn.eggschat.service.impl;

import cn.eggschat.entity.Customer_chat;
import cn.eggschat.service.CustomerChatService;
import cn.eggschat.service.SysUnitService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;


@IocBean(args = {"refer:dao"})
public class CustomerChatServiceImpl extends BaseServiceImpl<Customer_chat> implements CustomerChatService {
    public CustomerChatServiceImpl(Dao dao) {
        super(dao);
    }

    @Inject
    private CustomerChatService chatService;

    @Inject
    private SysUnitService sysUnitService;

}
