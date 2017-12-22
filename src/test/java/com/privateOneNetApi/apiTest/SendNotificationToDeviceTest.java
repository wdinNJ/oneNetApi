package com.privateOneNetApi.apiTest;

import com.alibaba.fastjson.JSONObject;
import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.SendNotificationToDeviceBodyReqEntity;
import com.privateOneNetApi.entity.SendNotificationToDeviceReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.SendNotificationToDeviceRequest;
import com.privateOneNetApi.response.SendNotificationToDeviceResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发通知-单个设备
 */
public class SendNotificationToDeviceTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        SendNotificationToDeviceRequest sendNotificationToDeviceRequest = new SendNotificationToDeviceRequest();

        SendNotificationToDeviceBodyReqEntity sendNotificationToDeviceBodyReqEntity = new SendNotificationToDeviceBodyReqEntity();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("notice_type","1");
        jsonObject.put("notice_info","sendNotificationGroup");

        sendNotificationToDeviceBodyReqEntity.setBody(jsonObject);
        sendNotificationToDeviceBodyReqEntity.setTime_out(300);
        sendNotificationToDeviceRequest.setEntity(sendNotificationToDeviceBodyReqEntity);
        System.out.println(sendNotificationToDeviceRequest.getEntity().toString());

        SendNotificationToDeviceReqEntity sendNotificationToDeviceReqEntity = new SendNotificationToDeviceReqEntity();
        sendNotificationToDeviceReqEntity.setProductId(104018);
        sendNotificationToDeviceReqEntity.setToken("4lUO2flxSPEz8f1M6GnUNL7G4FtejQm1APNu1ZWTMd4VIfmrlxlAX6VkKFcy6pmR");

        sendNotificationToDeviceRequest.setSendNotificationToDeviceReqEntity(sendNotificationToDeviceReqEntity);

        sendNotificationToDeviceRequest.setDeviceId("20405876");

        SendNotificationToDeviceResponse sendNotificationToDeviceResponse = oneNetClient.execute(sendNotificationToDeviceRequest);

        if(sendNotificationToDeviceResponse.getErrno() != 0){
            System.out.println("下发通知设备-组失败:" + sendNotificationToDeviceResponse.getError());
        }else {
            System.out.println("下发通知设备-组成功");
        }

    }

}
