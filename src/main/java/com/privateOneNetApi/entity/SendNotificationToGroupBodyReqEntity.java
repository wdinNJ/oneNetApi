package com.privateOneNetApi.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发通知-组的HTTP内容
 */
public class SendNotificationToGroupBodyReqEntity {

    //单位秒[300，一周 ],最小300秒，最大一周
    private int time_out;

    //通知内容，必选，根据schema填写，JSON, 可选用传统方式和新增的通用方式
    private Object body;

    public int getTime_out() {
        return time_out == 0 ? DefaultValue.DEFAULT_NULL_VALUE : time_out;
    }

    public void setTime_out(int time_out) {
        this.time_out = time_out;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
