package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetNotificationReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetNotificationRequest;
import com.privateOneNetApi.response.GetNotificationResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 查看通知详情
 */
public class GetNotificationTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetNotificationRequest getNotificationRequest = new GetNotificationRequest();
        GetNotificationReqEntity getNotificationReqEntity = new GetNotificationReqEntity();
        getNotificationReqEntity.setProductId(104018);
        getNotificationReqEntity.setToken("7xW3QX1ssWfAZrpmGcFCnHQBnmdSDxxmJ0RJl18xS0Hmwmpi3PoeR4iu6cQppQjY");
        getNotificationRequest.setEntity(getNotificationReqEntity);

        getNotificationRequest.setNotificationUuid("8f9dbc7d-e092-4315-802f-efa887d87911");

        GetNotificationResponse getNotificationResponse = oneNetClient.execute(getNotificationRequest);

        if(getNotificationResponse.getErrno() != 0){
            System.out.println("查看通知详情失败:" + getNotificationResponse.getError());
        }else {
            System.out.printf("通知的模板id:%d,通知的内容:%s\n",getNotificationResponse.getData().getSchema_id(),getNotificationResponse.getData().getBody());
        }
    }

}
