package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.SendPromptCmdToDeviceBodyReqEntity;
import com.privateOneNetApi.entity.SendPromptCmdToDeviceReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.SendPromptCmdToDeviceResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发及时命令-单个设备（设备必须保证在线）请求类
 */
public class SendPromptCmdToDeviceRequest extends BaseOneNetRequest<SendPromptCmdToDeviceBodyReqEntity,SendPromptCmdToDeviceResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/prompt_cmd/<device_id>";

    private final String DEVICE_ID = "device_id";

    private String deviceId;
    private SendPromptCmdToDeviceReqEntity sendPromptCmdToDeviceReqEntity;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(DEVICE_ID,deviceId);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(sendPromptCmdToDeviceReqEntity);
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<SendPromptCmdToDeviceResponse> getResponseClass() {
        return SendPromptCmdToDeviceResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(deviceId,DEVICE_ID);

        RequestCheckUtils.checkNotEmpty(getEntity().getBody(), "body");

        RequestCheckUtils.checkNotEmpty(sendPromptCmdToDeviceReqEntity, "Entity");
        RequestCheckUtils.checkNotEmpty(sendPromptCmdToDeviceReqEntity.getToken(),"token");
        RequestCheckUtils.checkNotEmpty(sendPromptCmdToDeviceReqEntity.getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null : sendPromptCmdToDeviceReqEntity.getProductId(),"product_id");
    }

    public HTTPMETHOD getMethod()
    {
        return HTTPMETHOD.POST;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public SendPromptCmdToDeviceReqEntity getSendPromptCmdToDeviceReqEntity() {
        return sendPromptCmdToDeviceReqEntity;
    }

    public void setSendPromptCmdToDeviceReqEntity(SendPromptCmdToDeviceReqEntity sendPromptCmdToDeviceReqEntity) {
        this.sendPromptCmdToDeviceReqEntity = sendPromptCmdToDeviceReqEntity;
    }
}
