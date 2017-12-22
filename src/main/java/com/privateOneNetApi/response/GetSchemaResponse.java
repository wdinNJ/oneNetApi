package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetSchemaRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取数据模板详情返回类
 */
public class GetSchemaResponse extends BaseResponse{

    public class Data extends GetSchemaRespEntity{

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
