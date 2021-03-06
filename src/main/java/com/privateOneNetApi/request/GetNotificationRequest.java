package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetNotificationReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetNotificationResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取通知详情请求类
 */
public class GetNotificationRequest extends BaseOneNetRequest<GetNotificationReqEntity,GetNotificationResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/notification/<notification_uuid>";

    private final String NOTIFICATION_UUID = "notification_uuid";

    private String notificationUuid;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(NOTIFICATION_UUID,notificationUuid);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetNotificationResponse> getResponseClass() {
        return GetNotificationResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");

        RequestCheckUtils.checkNotEmpty(notificationUuid,NOTIFICATION_UUID);
    }

    public String getNotificationUuid() {
        return notificationUuid;
    }

    public void setNotificationUuid(String notificationUuid) {
        this.notificationUuid = notificationUuid;
    }
}
