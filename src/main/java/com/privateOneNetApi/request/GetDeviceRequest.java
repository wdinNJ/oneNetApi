package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetDeviceReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetDeviceResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备详情的请求类
 */
public class GetDeviceRequest extends BaseOneNetRequest<GetDeviceReqEntity,GetDeviceResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/device/<device_id>";

    private final String DEVICE_ID = "device_id";

    private String deviceId;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(DEVICE_ID,deviceId);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetDeviceResponse> getResponseClass() {
        return GetDeviceResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");

        RequestCheckUtils.checkNotEmpty(deviceId, DEVICE_ID);
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
