package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetDeviceReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetDeviceRequest;
import com.privateOneNetApi.response.GetDeviceResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备详情
 */
public class GetDeviceTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetDeviceRequest getDeviceRequest = new GetDeviceRequest();
        GetDeviceReqEntity getDeviceReqEntity = new GetDeviceReqEntity();
        getDeviceReqEntity.setProductId(104018);
        getDeviceReqEntity.setToken("2t-1c4qikmgRudXR-LPLG3tzWDqvYgcAaMQyBqCRYWL6gwggHID2Xl6LKlBZ4x4j");
        getDeviceRequest.setEntity(getDeviceReqEntity);

        getDeviceRequest.setDeviceId("20405876");

        GetDeviceResponse getDeviceResponse = oneNetClient.execute(getDeviceRequest);

        if(getDeviceResponse.getErrno() != 0){
            System.out.println("获取设备详情失败:" + getDeviceResponse.getError());
        }else {
            System.out.printf("设备在线状态:%s,设备详情:%s\n",getDeviceResponse.getData().isOnline(),getDeviceResponse.getData().getBody());
        }

    }

}
