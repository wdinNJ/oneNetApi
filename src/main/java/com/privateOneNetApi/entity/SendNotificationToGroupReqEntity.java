package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 用于组装下发通知-组的url地址
 */
public class SendNotificationToGroupReqEntity extends BaseEntity{

    private static final long serialVersionUID = 7L;

    //模板id
    private final String SCHEMA_ID = "schema_id";

    //组id
    private final String GROUP_ID = "group_id";

    public int getSchemaId() {
        return get(SCHEMA_ID) == null ? DefaultValue.DEFAULT_NULL_VALUE : Integer.parseInt(get(SCHEMA_ID));
    }

    public void setSchemaId(int schemaId) {
        put(SCHEMA_ID,schemaId);
    }

    public int getGroupId() {
        return get(GROUP_ID) == null ? DefaultValue.DEFAULT_NULL_VALUE : Integer.parseInt(get(GROUP_ID));
    }

    public void setGroupId(int groupId) {
        put(GROUP_ID,groupId);
    }

}
