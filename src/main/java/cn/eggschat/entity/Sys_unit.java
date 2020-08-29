package cn.eggschat.entity;

import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;


/**
* @author: eggsblue
* @date: 2020/8/29 12:54
**/
@Table("sys_unit")
public class Sys_unit {
    private static final long serialVersionUID = 1L;

    @Name
    @PrevInsert(els = {@EL("ig(view.tableName,'')")})
    @Comment("id")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("unit name")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @Column
    @Comment("token")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String token;

//    The chat wedget start
    @Column
    @Comment("title")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String title;

    @Column
    @Comment("sub_title")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String sub_title;

    @Column
    @Comment("greeting")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String greeting;

    @Column
    @Comment("placeholder")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String placeholder;

    @Column
    @Comment("placeholder")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
