package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetSendPromptCmdRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 获取下发及时命令-响应消息返回类
 */
public class GetSendPromptCmdResponse extends BaseResponse{

    public class Data extends GetSendPromptCmdRespEntity{

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
