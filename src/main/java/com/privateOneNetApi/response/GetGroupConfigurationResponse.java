package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetGroupConfigurationRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取组配置内容详情的返回类
 */
public class GetGroupConfigurationResponse extends BaseResponse{

    public class Data extends GetGroupConfigurationRespEntity {

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
