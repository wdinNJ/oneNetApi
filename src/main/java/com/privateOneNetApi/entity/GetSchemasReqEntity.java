package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 用于组装获取数据模板列表的url地址
 */
public class GetSchemasReqEntity extends PageEntity{

    private static final long serialVersionUID = 7L;

    //类型，指定要查询的模式类型，只能选一个
    //PROFILE(设备档案)||CONFIGURATION(配置文件)||EVENT(事件)||NOTIFICATION(通知)||SENSORDATA(传感器数据)
    private final String TYPE = "type";

    //可选，支持搜索name和version
    private final String KEYWORD = "keyword";

    public String getType() {
        return get(TYPE);
    }

    public void setType(String type) {
        put(TYPE,type);
    }

    public String getKeyword() {
        return get(KEYWORD);
    }

    public void setKeyword(String keyword) {
        put(KEYWORD,keyword);
    }

}
