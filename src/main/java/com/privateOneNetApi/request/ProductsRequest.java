package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.ProductsReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.ProductsResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 产品列表请求类
 */
public class ProductsRequest extends BaseOneNetRequest<ProductsReqEntity,ProductsResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/product_list";

    @Override
    public String getURL(OneNetContext context) {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<ProductsResponse> getResponseClass() {
        return ProductsResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();
        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPage(), "page");
        RequestCheckUtils.checkNotEmpty(getEntity().getPerPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPerPage(), "per_page");
    }
}
