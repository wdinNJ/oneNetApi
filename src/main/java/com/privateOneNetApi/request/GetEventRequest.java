package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetEventReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetEventResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取产品事件列表请求类
 */
public class GetEventRequest extends BaseOneNetRequest<GetEventReqEntity,GetEventResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/event/<event_uuid>";

    private final String EVENT_UUID = "event_uuid";

    private String eventUuid;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(EVENT_UUID,eventUuid);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetEventResponse> getResponseClass() {
        return GetEventResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");

        RequestCheckUtils.checkNotEmpty(eventUuid, EVENT_UUID);
    }

    public String getEventUuid() {
        return eventUuid;
    }

    public void setEventUuid(String eventUuid) {
        this.eventUuid = eventUuid;
    }
}
