package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetDeviceRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备详情的返回类
 */
public class GetDeviceResponse extends BaseResponse {

    public class Data extends GetDeviceRespEntity{

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
