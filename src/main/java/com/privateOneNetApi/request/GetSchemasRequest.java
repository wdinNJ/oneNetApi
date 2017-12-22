package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetSchemasReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetSchemasResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取数据模板列表请求类
 */
public class GetSchemasRequest extends BaseOneNetRequest<GetSchemasReqEntity,GetSchemasResponse> {

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/schema";

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetSchemasResponse> getResponseClass() {
        return GetSchemasResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPage(), "page");
        RequestCheckUtils.checkNotEmpty(getEntity().getPerPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPerPage(), "perPage");
        RequestCheckUtils.checkNotEmpty(getEntity().getType(), "type");
    }
}
