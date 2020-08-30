package cn.eggschat.entity;

import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;


/**
 * @author: eggsblue
 * @date: 2020/8/29 12:54
 **/
@Table("sys_user")
@TableIndexes({@Index(name = "INDEX__EMAIL", fields = {"email"}, unique = true)})
public class Sys_user  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Name
    @PrevInsert(els = {@EL("ig(view.tableName,'')")})
    @Comment("id")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("email")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String email;

    @Column
    @Comment("密码")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String password;

    @Column
    @Comment("密码盐")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String salt;

    @Column
    @Comment("full name")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String full_name;

    @Column
    @Comment("display name")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String display_name;

    @Column
    @Comment("avatar url")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String avatar;

    @Column
    @Comment("join time")
    @ColDefine(type = ColType.INT)
    private Long join_time;

    @Column
    @Comment("is admin")
    @ColDefine(type = ColType.INT, width = 1)
    @Default("0")
    private Boolean admin;

    @Column
    @Comment("unit id")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String unit_id;

    @Column
    @Comment("device_info")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String device_info;

    @One(field = "unit_id")
    private Sys_unit unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getJoin_time() {
        return join_time;
    }

    public void setJoin_time(Long join_time) {
        this.join_time = join_time;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public Sys_unit getUnit() {
        return unit;
    }

    public void setUnit(Sys_unit unit) {
        this.unit = unit;
    }
}
