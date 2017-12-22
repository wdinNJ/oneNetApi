package com.privateOneNetApi.apiTest;

import com.alibaba.fastjson.JSONObject;
import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.SendPromptCmdToDeviceBodyReqEntity;
import com.privateOneNetApi.entity.SendPromptCmdToDeviceReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.SendPromptCmdToDeviceRequest;
import com.privateOneNetApi.response.SendPromptCmdToDeviceResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发及时命令-单个设备（设备必须保证在线）
 */
public class SendPromptCmdToDeviceTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        SendPromptCmdToDeviceRequest sendPromptCmdToDeviceRequest = new SendPromptCmdToDeviceRequest();

        SendPromptCmdToDeviceBodyReqEntity sendPromptCmdToDeviceBodyReqEntity = new SendPromptCmdToDeviceBodyReqEntity();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("notice_type","1");
        jsonObject.put("notice_info","sendNotificationGroup");
        sendPromptCmdToDeviceBodyReqEntity.setBody(jsonObject);
        sendPromptCmdToDeviceRequest.setEntity(sendPromptCmdToDeviceBodyReqEntity);

        SendPromptCmdToDeviceReqEntity sendPromptCmdToDeviceReqEntity = new SendPromptCmdToDeviceReqEntity();
        sendPromptCmdToDeviceReqEntity.setProductId(104018);
        sendPromptCmdToDeviceReqEntity.setToken("e4ljlSJyp0XrxthCSro7iqKbTsiSuNPo5ose_w5tlVnXq_6Gva5aIEyHpJRZlu4p");
        sendPromptCmdToDeviceRequest.setSendPromptCmdToDeviceReqEntity(sendPromptCmdToDeviceReqEntity);

        sendPromptCmdToDeviceRequest.setDeviceId("20405876");

        SendPromptCmdToDeviceResponse sendPromptCmdToDeviceResponse = oneNetClient.execute(sendPromptCmdToDeviceRequest);

        if(sendPromptCmdToDeviceResponse.getErrno() != 0){
            System.out.println("下发及时命令失败:" + sendPromptCmdToDeviceResponse.getError());
        }else {
            System.out.println("下发及时命令成功,cmd_uuid:" + sendPromptCmdToDeviceResponse.getData().getCmd_uuid());
        }
    }

}
