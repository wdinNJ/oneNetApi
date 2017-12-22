package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetNotificationsReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetNotificationsRequest;
import com.privateOneNetApi.response.GetNotificationsResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取产品通知列表
 */
public class GetNotificationsTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetNotificationsRequest getNotificationsRequest = new GetNotificationsRequest();
        GetNotificationsReqEntity getNotificationsReqEntity = new GetNotificationsReqEntity();
        getNotificationsReqEntity.setProductId(104018);
        getNotificationsReqEntity.setToken("7xW3QX1ssWfAZrpmGcFCnHQBnmdSDxxmJ0RJl18xS0Hmwmpi3PoeR4iu6cQppQjY");
        getNotificationsReqEntity.setPage(1);
        getNotificationsReqEntity.setPerPage(10);
        getNotificationsRequest.setEntity(getNotificationsReqEntity);

        GetNotificationsResponse getNotificationsResponse = oneNetClient.execute(getNotificationsRequest);

        if(getNotificationsResponse.getErrno() != 0){
            System.out.println("获取产品通知列表失败:" + getNotificationsResponse.getError());
        }else {
            System.out.println("获取产品通知列表的个数:" + getNotificationsResponse.getData().getTotal_count());

            getNotificationsResponse.getData().getItems().forEach(notification -> System.out.printf("通知的id:%s,通知的设备数:%d,下发类型:%s\n",notification.getUuid(),notification.getDevice_count(),notification.getTarget().getType()));
        }

    }

}
