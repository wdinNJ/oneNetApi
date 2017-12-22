package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetDevicesReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetDevicesRequest;
import com.privateOneNetApi.response.GetDevicesResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备列表
 */
public class GetDevicesTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetDevicesRequest getDevicesRequest = new GetDevicesRequest();
        GetDevicesReqEntity getDevicesReqEntity = new GetDevicesReqEntity();
        getDevicesReqEntity.setProductId(104018);
        getDevicesReqEntity.setToken("2t-1c4qikmgRudXR-LPLG3tzWDqvYgcAaMQyBqCRYWL6gwggHID2Xl6LKlBZ4x4j");
        //getDevicesReqEntity.setCursor("20405880");
        getDevicesReqEntity.setLimit(6);
        getDevicesRequest.setEntity(getDevicesReqEntity);

        GetDevicesResponse getDevicesResponse = oneNetClient.execute(getDevicesRequest);

        if(getDevicesResponse.getErrno() != 0){
            System.out.println("获取设备列表失败：" + getDevicesResponse.getError());
        }else {
            System.out.println("获取设备列表的游标:" + getDevicesResponse.getData().getCursor());

            getDevicesResponse.getData().getItems().forEach(device -> System.out.printf("设备id:%s,在线状态:%s\n",device.getDevice_id(),device.isOnline()));
        }

    }

}
