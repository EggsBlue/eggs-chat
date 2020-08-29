package cn.eggschat.enums;



public enum CustomerChatRecordsMsgTypeEnum {
    TEXT(0, "文本消息"),
    IMAGE(1, "图片消息"),
    VIDEO(2, "视频消息"),
    voice(3, "音频消息");

    private Integer value;
    private String text;


    CustomerChatRecordsMsgTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer value() {
        return value;
    }

    public static CustomerChatRecordsMsgTypeEnum from(String value) {
        for (CustomerChatRecordsMsgTypeEnum c : CustomerChatRecordsMsgTypeEnum.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        return null;
    }
}
