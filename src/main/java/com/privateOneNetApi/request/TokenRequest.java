package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.TokenReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.BaseResponse;
import com.privateOneNetApi.response.TokenResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 获取token请求类
 */
public class TokenRequest extends BaseOneNetRequest<TokenReqEntity, TokenResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/token";

    @Override
    public String getURL(OneNetContext context) {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<TokenResponse> getResponseClass() {
        return TokenResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();
        RequestCheckUtils.checkNotEmpty(getEntity().getUserID() == DefaultValue.DEFAULT_NULL_VALUE ? null : getEntity().getUserID(), "user_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getSecret(), "secret");
    }
}
