package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 用于组装获取产品事件列表的url地址
 */
public class GetEventsReqEntity extends PageEntity{

    private static final long serialVersionUID = 7L;

    //可选 事件类型
    //RESERVED|ERROR|WARNING|INFORMATION|DEBUG|USER_DEFINITION_TYPE
    private final String LEVEL = "level";

    //可选，unread未读状态, readed为已读
    private final String STATUS = "status";

    public String getLevel() {
        return get(LEVEL);
    }

    public void setLevel(String level) {
        put(LEVEL,level);
    }

    public String getStatus() {
        return get(STATUS);
    }

    public void setStatus(String status) {
        put(STATUS,status);
    }

}
