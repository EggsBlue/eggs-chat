package cn.eggschat.entity;

import cn.eggschat.enums.CustomerSourceEnum;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;


/**
 * @author: eggsblue
 * @date: 2020/8/29 12:54
 **/
@Table("customer_chat")
public class Customer_chat  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Name
    @PrevInsert(els = {@EL("ig(view.tableName,'')")})
    @Comment("id")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("unit id")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String unit_id;

    @Column
    @Comment("user id")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String user_id;

    @Column
    @Comment("customer name")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @Column
    @Comment("customer ip")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String ip;

    @Column
    @Comment("customer source")
    @ColDefine(type = ColType.INT, width = 1)
    private CustomerSourceEnum source;

    @Column
    @Comment("priority")
    @ColDefine(type = ColType.INT, width = 1)
    @Default("0")
    private Boolean mark_priority;

    @Column
    @Comment("customer brower agent")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String brower_agent;

    @Column
    @Comment("visits count ")
    @ColDefine(type = ColType.INT)
    private Integer chat_count;

    @Column
    @Comment("last visits time")
    @ColDefine(type = ColType.INT)
    private Long last_time;

    @Column
    @Comment("last visits close time")
    @ColDefine(type = ColType.INT)
    private Long close_time;

    @Column
    @Comment("customer region")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String region;

    @Column
    @Comment("created time")
    @ColDefine(type = ColType.INT)
    private Long ct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public CustomerSourceEnum getSource() {
        return source;
    }

    public void setSource(CustomerSourceEnum source) {
        this.source = source;
    }

    public String getBrower_agent() {
        return brower_agent;
    }

    public void setBrower_agent(String brower_agent) {
        this.brower_agent = brower_agent;
    }

    public Integer getChat_count() {
        return chat_count;
    }

    public void setChat_count(Integer chat_count) {
        this.chat_count = chat_count;
    }

    public Long getLast_time() {
        return last_time;
    }

    public void setLast_time(Long last_time) {
        this.last_time = last_time;
    }

    public Long getClose_time() {
        return close_time;
    }

    public void setClose_time(Long close_time) {
        this.close_time = close_time;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getCt() {
        return ct;
    }

    public void setCt(Long ct) {
        this.ct = ct;
    }

    public Boolean getMark_priority() {
        return mark_priority;
    }

    public void setMark_priority(Boolean mark_priority) {
        this.mark_priority = mark_priority;
    }
}
