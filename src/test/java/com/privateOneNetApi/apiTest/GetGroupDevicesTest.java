package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetGroupDevicesReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetGroupDevicesRequest;
import com.privateOneNetApi.response.GetGroupDevicesResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取设备分组下面的设备
 */
public class GetGroupDevicesTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetGroupDevicesRequest getGroupDevicesRequest = new GetGroupDevicesRequest();

        getGroupDevicesRequest.setGroupId(1393);

        GetGroupDevicesReqEntity getGroupDevicesReqEntity = new GetGroupDevicesReqEntity();
        getGroupDevicesReqEntity.setProductId(104018);
        getGroupDevicesReqEntity.setToken("Z-4_kMUIAetDWz16oC2yuXKWrshPmr_7OnGkYVUMu64yIhGJ809YoJkZdNBuCv7E");
        getGroupDevicesReqEntity.setLimit(2);
        getGroupDevicesReqEntity.setCursor("1");
        getGroupDevicesRequest.setEntity(getGroupDevicesReqEntity);

        GetGroupDevicesResponse getGroupDevicesResponse = oneNetClient.execute(getGroupDevicesRequest);

        if(getGroupDevicesResponse.getErrno() != 0){
            System.out.println("获取设备分组下面的设备失败:" + getGroupDevicesResponse.getError());
        }else {
            System.out.println("cursor:" + getGroupDevicesResponse.getData().getCursor());

            getGroupDevicesResponse.getData().getItems().forEach(groupDevice -> System.out.printf("设备id:%s,设备在线状态:%s\n",groupDevice.getDevice_id(),groupDevice.isOnline()));
        }

    }

}
