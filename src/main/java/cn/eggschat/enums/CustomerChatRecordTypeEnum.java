package cn.eggschat.enums;


public enum CustomerChatRecordTypeEnum {
    SYSTEM(0, "系统消息"),
    CHAT(1, "聊天消息");
    private Integer value;
    private String text;

    CustomerChatRecordTypeEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer value() {
        return value;
    }

    public static CustomerChatRecordTypeEnum from(String value) {
        for (CustomerChatRecordTypeEnum c : CustomerChatRecordTypeEnum.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        return null;
    }
}
