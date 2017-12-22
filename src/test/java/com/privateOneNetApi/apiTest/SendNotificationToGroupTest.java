package com.privateOneNetApi.apiTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.SendNotificationToGroupBodyReqEntity;
import com.privateOneNetApi.entity.SendNotificationToGroupReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.SendNotificationToGroupRequest;
import com.privateOneNetApi.response.SendNotificationToGroupResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 下发通知-组
 */
public class SendNotificationToGroupTest {

    public static void main(String [] args) throws Exception {
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        SendNotificationToGroupRequest sendNotificationToGroupRequest = new SendNotificationToGroupRequest();

        SendNotificationToGroupBodyReqEntity sendNotificationToGroupBodyReqEntity = new SendNotificationToGroupBodyReqEntity();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("notice_type","1");
        jsonObject.put("notice_info","sendNotificationGroup");

        sendNotificationToGroupBodyReqEntity.setBody(jsonObject);
        sendNotificationToGroupBodyReqEntity.setTime_out(300);
        sendNotificationToGroupRequest.setEntity(sendNotificationToGroupBodyReqEntity);
        System.out.println(sendNotificationToGroupRequest.getEntity().toString());

        SendNotificationToGroupReqEntity sendNotificationToGroupReqEntity = new SendNotificationToGroupReqEntity();
        sendNotificationToGroupReqEntity.setProductId(104018);
        sendNotificationToGroupReqEntity.setToken("4lUO2flxSPEz8f1M6GnUNL7G4FtejQm1APNu1ZWTMd4VIfmrlxlAX6VkKFcy6pmR");
        sendNotificationToGroupReqEntity.setSchemaId(10725);
        sendNotificationToGroupReqEntity.setGroupId(1277);
        sendNotificationToGroupRequest.setSendNotificationToGroupReqEntity(sendNotificationToGroupReqEntity);

        System.out.println(JSONObject.toJSONString(sendNotificationToGroupRequest.getEntity()));

        SendNotificationToGroupResponse sendNotificationToGroupResponse = oneNetClient.execute(sendNotificationToGroupRequest);

        if(sendNotificationToGroupResponse.getErrno() != 0){
            System.out.println("下发通知设备-组失败:" + sendNotificationToGroupResponse.getError());
        }else {
            System.out.println("下发通知设备-组成功");
        }


    }

}
