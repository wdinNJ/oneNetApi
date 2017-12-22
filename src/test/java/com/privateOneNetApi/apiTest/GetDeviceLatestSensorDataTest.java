package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetDeviceLatestSensorDataReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetDeviceLatestSensorDataRequest;
import com.privateOneNetApi.response.GetDeviceLatestSensorDataResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备最新一条传感器数据
 */
public class GetDeviceLatestSensorDataTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetDeviceLatestSensorDataRequest getDeviceLatestSensorDataRequest = new GetDeviceLatestSensorDataRequest();
        GetDeviceLatestSensorDataReqEntity getDeviceLatestSensorDataReqEntity = new GetDeviceLatestSensorDataReqEntity();
        getDeviceLatestSensorDataReqEntity.setProductId(104018);
        getDeviceLatestSensorDataReqEntity.setToken("He0a7CErIXUVMEJIOf-PHBhuXGeVZDMEwvSLrpx00MZGpsgWMj3FW0ccy8H2Am_z");
        getDeviceLatestSensorDataRequest.setEntity(getDeviceLatestSensorDataReqEntity);

        getDeviceLatestSensorDataRequest.setDeviceId("20405876");

        GetDeviceLatestSensorDataResponse getDeviceLatestSensorDataResponse = oneNetClient.execute(getDeviceLatestSensorDataRequest);

        if(getDeviceLatestSensorDataResponse.getErrno() != 0){
            System.out.println("获取设备最新一条传感器数据失败:" + getDeviceLatestSensorDataResponse.getError());
        }else {
            System.out.printf("上传时间:%s,上传内容:%s\n",
                    getDeviceLatestSensorDataResponse.getData().getAt(),
                    getDeviceLatestSensorDataResponse.getData().getBody());
        }

    }

}
