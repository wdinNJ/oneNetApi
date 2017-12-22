package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetDeviceNotificationReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetDeviceNotificationRequest;
import com.privateOneNetApi.response.GetDeviceNotificationResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备通知列表
 */
public class GetDeviceNotificationTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetDeviceNotificationRequest getDeviceNotificationRequest = new GetDeviceNotificationRequest();
        GetDeviceNotificationReqEntity getDeviceNotificationReqEntity = new GetDeviceNotificationReqEntity();
        getDeviceNotificationReqEntity.setProductId(104018);
        getDeviceNotificationReqEntity.setToken("7xW3QX1ssWfAZrpmGcFCnHQBnmdSDxxmJ0RJl18xS0Hmwmpi3PoeR4iu6cQppQjY");
        getDeviceNotificationReqEntity.setPage(1);
        getDeviceNotificationReqEntity.setPerPage(1);
        getDeviceNotificationRequest.setEntity(getDeviceNotificationReqEntity);

        getDeviceNotificationRequest.setDeviceId("20405876");

        GetDeviceNotificationResponse getDeviceNotificationResponse = oneNetClient.execute(getDeviceNotificationRequest);

        if(getDeviceNotificationResponse.getErrno() != 0){
            System.out.println("获取设备通知列表失败:" + getDeviceNotificationResponse.getError());
        }else {
            System.out.println("获取设备通知列表的个数:" + getDeviceNotificationResponse.getData().getTotal_count());

            getDeviceNotificationResponse.getData().getItems().forEach(notification -> System.out.printf("通知id:%s,创建时间:%s\n",notification.getUuid(),notification.getCreated_time()));
        }

    }

}
