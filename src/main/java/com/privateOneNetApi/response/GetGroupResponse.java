package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetGroupRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 获取设备分组的详情返回类
 */
public class GetGroupResponse extends BaseResponse{

    public class Data extends GetGroupRespEntity{

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
