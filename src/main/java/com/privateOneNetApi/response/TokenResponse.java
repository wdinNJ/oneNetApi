package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.TokenRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 获取token返回类
 */
public class TokenResponse extends BaseResponse{

    public static class Data extends TokenRespEntity {

    }

    private Data data;

    public Data getData()
    {
        return data;
    }

    public void setData(Data data)
    {
        this.data = data;
    }

}
