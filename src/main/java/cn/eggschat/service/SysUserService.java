package cn.eggschat.service;

import cn.eggschat.dto.Result;
import cn.eggschat.entity.Sys_user;


public interface SysUserService extends BaseService<Sys_user> {
    /**
     * 注册
     * @param userName
     * @param password
     * @param compayName
     * @return
     */
    Result register(String userName, String password, String email, String compayName);
}
