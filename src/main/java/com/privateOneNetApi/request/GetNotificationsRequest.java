package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetNotificationsReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetNotificationsResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取产品通知列表请求类
 */
public class GetNotificationsRequest extends BaseOneNetRequest<GetNotificationsReqEntity,GetNotificationsResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/notification";

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetNotificationsResponse> getResponseClass() {
        return GetNotificationsResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPage(), "page");
        RequestCheckUtils.checkNotEmpty(getEntity().getPerPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPerPage(), "per_page");

    }
}
