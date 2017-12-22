package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetEventsReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetEventsResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取产品事件列表的请求类
 */
public class GetEventsRequest extends BaseOneNetRequest<GetEventsReqEntity,GetEventsResponse> {

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/event";

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetEventsResponse> getResponseClass() {
        return GetEventsResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPage(), "page");
        RequestCheckUtils.checkNotEmpty(getEntity().getPerPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPerPage(), "per_page");

        RequestCheckUtils.checkMinValue(Long.valueOf(getEntity().getPage()),1,"page");
        RequestCheckUtils.checkMinValue(Long.valueOf(getEntity().getPerPage()),1,"per_page");
    }
}
