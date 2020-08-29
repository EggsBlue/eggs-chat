package cn.eggschat.entity;

import cn.eggschat.enums.CustomerChatRecordTypeEnum;
import cn.eggschat.enums.CustomerChatRecordsMsgTypeEnum;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;


/**
 * @author: eggsblue
 * @date: 2020/8/29 12:54
 **/
@Table("customer_chat_records")
public class Customer_chat_records {
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
    @Comment("chat id")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String chat_id;

    @Column
    @Comment("record type")
    @ColDefine(type = ColType.INT,width = 1)
    private CustomerChatRecordTypeEnum record_type;

    @Column
    @Comment("message type")
    @ColDefine(type = ColType.INT,width = 1)
    private CustomerChatRecordsMsgTypeEnum msg_type;

    @Column
    @Comment("the msg from")//sys_user_id/chatId
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String msg_from;

    @Column
    @Comment("the msg to")//sys_user_id/chatId
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String msg_to;

    @Column
    @Comment("message content ")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String content;

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

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public CustomerChatRecordTypeEnum getRecord_type() {
        return record_type;
    }

    public void setRecord_type(CustomerChatRecordTypeEnum record_type) {
        this.record_type = record_type;
    }

    public CustomerChatRecordsMsgTypeEnum getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(CustomerChatRecordsMsgTypeEnum msg_type) {
        this.msg_type = msg_type;
    }

    public String getMsg_from() {
        return msg_from;
    }

    public void setMsg_from(String msg_from) {
        this.msg_from = msg_from;
    }

    public String getMsg_to() {
        return msg_to;
    }

    public void setMsg_to(String msg_to) {
        this.msg_to = msg_to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCt() {
        return ct;
    }

    public void setCt(Long ct) {
        this.ct = ct;
    }
}
