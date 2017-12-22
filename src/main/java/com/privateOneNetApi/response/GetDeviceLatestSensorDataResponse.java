package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetDeviceLatestSensorDataRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备最新一条传感器数据返回类
 */
public class GetDeviceLatestSensorDataResponse extends BaseResponse{

    public  class Data extends GetDeviceLatestSensorDataRespEntity{

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
