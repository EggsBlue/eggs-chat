package cn.eggschat.enums;

import org.nutz.lang.Strings;

/**
* The customer source
* @author: eggsblue
* @date: 2020/8/29 13:06
**/
public enum CustomerSourceEnum {
    WEB_PC(0,"PC网站"),
    WEB_MOBILE(1,"手机网站");

    private Integer value;
    private String text;

    CustomerSourceEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer value() {
        return value;
    }

    public static CustomerSourceEnum from(String value) {
        for (CustomerSourceEnum c : CustomerSourceEnum.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        return null;
    }
}
