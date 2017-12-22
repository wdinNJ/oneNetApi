package com.privateOneNetApi.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 获取下发及时命令-响应消息返回值
 */
public class GetSendPromptCmdRespEntity {

    private JSONObject body;

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }
}
