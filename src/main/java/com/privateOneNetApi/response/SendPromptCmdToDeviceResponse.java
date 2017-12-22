package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.SendPromptCmdToDeviceRespEntity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发及时命令-单个设备（设备必须保证在线）返回类
 */
public class SendPromptCmdToDeviceResponse extends BaseResponse{

    public class Data extends SendPromptCmdToDeviceRespEntity{

    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
