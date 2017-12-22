package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetEventRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取产品事件列表返回类
 */
public class GetEventResponse extends BaseResponse{

    public class Data extends GetEventRespEntity{

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
