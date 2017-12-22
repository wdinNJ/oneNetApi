package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetDeviceSensorDatasReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetDeviceSensorDatasRequest;
import com.privateOneNetApi.response.GetDeviceSensorDatasResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备传感器数据列表
 */
public class GetDeviceSensorDatasTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetDeviceSensorDatasRequest getDeviceSensorDatasRequest = new GetDeviceSensorDatasRequest();
        GetDeviceSensorDatasReqEntity getDeviceSensorDatasReqEntity = new GetDeviceSensorDatasReqEntity();
        getDeviceSensorDatasReqEntity.setProductId(104018);
        getDeviceSensorDatasReqEntity.setToken("He0a7CErIXUVMEJIOf-PHBhuXGeVZDMEwvSLrpx00MZGpsgWMj3FW0ccy8H2Am_z");
        getDeviceSensorDatasReqEntity.setPage(1);
        getDeviceSensorDatasReqEntity.setPerPage(10);
        getDeviceSensorDatasReqEntity.setBegin("2017-10-22T15:20:55");
        getDeviceSensorDatasReqEntity.setEnd("2017-11-21T15:22:35");
        getDeviceSensorDatasRequest.setEntity(getDeviceSensorDatasReqEntity);

        getDeviceSensorDatasRequest.setDeviceId("20405876");

        GetDeviceSensorDatasResponse getDeviceSensorDatasResponse = oneNetClient.execute(getDeviceSensorDatasRequest);

        if(getDeviceSensorDatasResponse.getErrno() != 0){
            System.out.println("获取设备传感器数据列表失败:" + getDeviceSensorDatasResponse.getError());
        }else {
            System.out.println("获取设备传感器数据列表条数:" + getDeviceSensorDatasResponse.getData().getTotal_count());

            getDeviceSensorDatasResponse.getData().getItems().forEach(sensor -> System.out.printf("上传时间:%s,内容:%s\n",sensor.getAt(),sensor.getBody()));
        }

    }

}
