package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发及时命令-单个设备（设备必须保证在线）返回值
 */
public class SendPromptCmdToDeviceRespEntity {

    private String cmd_uuid;

    public String getCmd_uuid() {
        return cmd_uuid;
    }

    public void setCmd_uuid(String cmd_uuid) {
        this.cmd_uuid = cmd_uuid;
    }
}
