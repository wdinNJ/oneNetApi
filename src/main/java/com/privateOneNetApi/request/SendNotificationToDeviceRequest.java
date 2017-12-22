package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.SendNotificationToDeviceBodyReqEntity;
import com.privateOneNetApi.entity.SendNotificationToDeviceReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.SendNotificationToDeviceResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发通知-单个设备请求类
 */
public class SendNotificationToDeviceRequest extends BaseOneNetRequest<SendNotificationToDeviceBodyReqEntity,SendNotificationToDeviceResponse> {

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/notification_device/<device_id>";

    private final String DEVICE_ID = "device_id";

    private SendNotificationToDeviceReqEntity sendNotificationToDeviceReqEntity;
    private String deviceId;


    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(DEVICE_ID,deviceId);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(sendNotificationToDeviceReqEntity);
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<SendNotificationToDeviceResponse> getResponseClass() {
        return SendNotificationToDeviceResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(deviceId,DEVICE_ID);

        RequestCheckUtils.checkNotEmpty(getEntity().getTime_out() == DefaultValue.DEFAULT_NULL_VALUE ? null : getEntity().getTime_out(), "time_out");
        RequestCheckUtils.checkNotEmpty(getEntity().getBody(), "body");

        RequestCheckUtils.checkNotEmpty(sendNotificationToDeviceReqEntity, "Entity");
        RequestCheckUtils.checkNotEmpty(sendNotificationToDeviceReqEntity.getToken(),"token");
        RequestCheckUtils.checkNotEmpty(sendNotificationToDeviceReqEntity.getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null : sendNotificationToDeviceReqEntity.getProductId(),"product_id");
    }

    public HTTPMETHOD getMethod()
    {
        return HTTPMETHOD.POST;
    }

    public SendNotificationToDeviceReqEntity getSendNotificationToDeviceReqEntity() {
        return sendNotificationToDeviceReqEntity;
    }

    public void setSendNotificationToDeviceReqEntity(SendNotificationToDeviceReqEntity sendNotificationToDeviceReqEntity) {
        this.sendNotificationToDeviceReqEntity = sendNotificationToDeviceReqEntity;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
