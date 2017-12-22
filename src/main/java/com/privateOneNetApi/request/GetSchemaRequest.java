package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetSchemaReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetSchemaResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取数据模板详情请求类
 */
public class GetSchemaRequest extends BaseOneNetRequest<GetSchemaReqEntity,GetSchemaResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/schema/<schema_id>";

    private final String SCHEMA_ID = "schema_id";

    private int schemaId;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(SCHEMA_ID,schemaId);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetSchemaResponse> getResponseClass() {
        return GetSchemaResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");

        RequestCheckUtils.checkNotEmpty(schemaId == 0 ? null : schemaId, SCHEMA_ID);
    }

    public int getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(int schemaId) {
        this.schemaId = schemaId;
    }
}
