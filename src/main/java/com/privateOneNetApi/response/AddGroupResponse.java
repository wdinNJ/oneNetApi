package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.AddGroupRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 新建设备分组返回类
 */
public class AddGroupResponse extends BaseResponse{


    public class Data extends AddGroupRespEntity {

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
