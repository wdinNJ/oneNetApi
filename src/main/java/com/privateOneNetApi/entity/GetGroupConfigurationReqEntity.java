package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 用于组装获取组配置内容详情的url地址
 */
public class GetGroupConfigurationReqEntity extends BaseEntity{

    private final String SCHEMA_ID = "schema_id";

    private final String GROUP_ID = "group_id";

    public int getSchemaId() {
        return get(SCHEMA_ID) == null ? DefaultValue.DEFAULT_NULL_VALUE:Integer.parseInt(get(SCHEMA_ID));
    }

    public void setSchemaId(int schemaId) {
        put(SCHEMA_ID,schemaId);
    }

    public int getGroupId() {
        return get(GROUP_ID) == null ? DefaultValue.DEFAULT_NULL_VALUE:Integer.parseInt(get(GROUP_ID));
    }

    public void setGroupId(int groupId) {
        put(GROUP_ID,groupId);
    }

}
