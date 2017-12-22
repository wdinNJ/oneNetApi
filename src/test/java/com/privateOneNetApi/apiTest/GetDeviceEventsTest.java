package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetDeviceEventsReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetDeviceEventsRequest;
import com.privateOneNetApi.response.GetDeviceEventsResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 获取设备事件
 */
public class GetDeviceEventsTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetDeviceEventsRequest getDeviceEventsRequest = new GetDeviceEventsRequest();

        GetDeviceEventsReqEntity getDeviceEventsReqEntity = new GetDeviceEventsReqEntity();
        getDeviceEventsReqEntity.setProductId(104018);
        getDeviceEventsReqEntity.setToken("4CGPTcfrReXSMX_E5nnG5gp4zGEN-NgP-MI3og7YBNhD72R_KFecUt1VMla_Rd0R");
        getDeviceEventsReqEntity.setPage(1);
        getDeviceEventsReqEntity.setPerPage(10);
        getDeviceEventsRequest.setEntity(getDeviceEventsReqEntity);

        getDeviceEventsRequest.setDeviceId("20405876");

        GetDeviceEventsResponse getDeviceEventsResponse = oneNetClient.execute(getDeviceEventsRequest);

        if(getDeviceEventsResponse.getErrno() != 0){
            System.out.println("获取设备事件列表失败:" + getDeviceEventsResponse.getError());
        }else {
            System.out.println("设备事件个数:" + getDeviceEventsResponse.getData().getTotal_count());

            getDeviceEventsResponse.getData().getItems().forEach(event -> System.out.printf("设备事件uuid:%s,事件类型:%s\n",event.getUuid(),event.getLevel()));
        }

    }

}
