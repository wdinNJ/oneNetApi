package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetDevicesReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetDevicesResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备列表请求类
 */
public class GetDevicesRequest extends BaseOneNetRequest<GetDevicesReqEntity,GetDevicesResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/device";

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetDevicesResponse> getResponseClass() {
        return GetDevicesResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {

        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getLimit() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getLimit(), "limit");

        RequestCheckUtils.checkMaxValue(Long.valueOf(getEntity().getLimit()),100,"limit");
    }
}
