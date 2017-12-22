package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.SendNotificationToGroupBodyReqEntity;
import com.privateOneNetApi.entity.SendNotificationToGroupReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.SendNotificationToGroupResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发通知-组的请求类
 */
public class SendNotificationToGroupRequest extends BaseOneNetRequest<SendNotificationToGroupBodyReqEntity,SendNotificationToGroupResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/notification";

    private SendNotificationToGroupReqEntity sendNotificationToGroupReqEntity;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(sendNotificationToGroupReqEntity);
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<SendNotificationToGroupResponse> getResponseClass() {
        return SendNotificationToGroupResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getTime_out() == DefaultValue.DEFAULT_NULL_VALUE ? null : getEntity().getTime_out(), "time_out");
        RequestCheckUtils.checkNotEmpty(getEntity().getBody(), "body");

        RequestCheckUtils.checkNotEmpty(sendNotificationToGroupReqEntity, "Entity");
        RequestCheckUtils.checkNotEmpty(sendNotificationToGroupReqEntity.getToken(),"token");
        RequestCheckUtils.checkNotEmpty(sendNotificationToGroupReqEntity.getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null : sendNotificationToGroupReqEntity.getProductId(),"product_id");
        RequestCheckUtils.checkNotEmpty(sendNotificationToGroupReqEntity.getSchemaId() == DefaultValue.DEFAULT_NULL_VALUE ? null : sendNotificationToGroupReqEntity.getSchemaId(),"schema_id");
        RequestCheckUtils.checkNotEmpty(sendNotificationToGroupReqEntity.getGroupId() == DefaultValue.DEFAULT_NULL_VALUE ? null : sendNotificationToGroupReqEntity.getGroupId(),"group_id");
    }

    public HTTPMETHOD getMethod()
    {
        return HTTPMETHOD.POST;
    }

    public SendNotificationToGroupReqEntity getSendNotificationToGroupReqEntity() {
        return sendNotificationToGroupReqEntity;
    }

    public void setSendNotificationToGroupReqEntity(SendNotificationToGroupReqEntity sendNotificationToGroupReqEntity) {
        this.sendNotificationToGroupReqEntity = sendNotificationToGroupReqEntity;
    }
}
