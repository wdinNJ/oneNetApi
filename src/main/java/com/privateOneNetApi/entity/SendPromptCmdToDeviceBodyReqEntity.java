package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发及时命令-单个设备（设备必须保证在线）的HTTP内容
 */
public class SendPromptCmdToDeviceBodyReqEntity {

    //通知内容，必选，根据schema填写，JSON, 可选用传统方式和新增的通用方式
    private Object body;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
