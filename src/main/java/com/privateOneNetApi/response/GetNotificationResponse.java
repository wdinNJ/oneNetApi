package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetNotificationRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取通知详情返回类
 */
public class GetNotificationResponse extends BaseResponse{

    public class Data extends GetNotificationRespEntity {

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
