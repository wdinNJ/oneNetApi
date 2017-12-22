package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetEventReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetEventRequest;
import com.privateOneNetApi.response.GetEventResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取产品事件详情
 */
public class GetEventTest {

    public static void main(String [] args) throws Exception {
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetEventRequest getEventRequest = new GetEventRequest();
        GetEventReqEntity getEventReqEntity = new GetEventReqEntity();
        getEventReqEntity.setProductId(104018);
        getEventReqEntity.setToken("4CGPTcfrReXSMX_E5nnG5gp4zGEN-NgP-MI3og7YBNhD72R_KFecUt1VMla_Rd0R");
        getEventRequest.setEntity(getEventReqEntity);

        getEventRequest.setEventUuid("25dc64d7-f221-3429-8063-239635dabc10");

        GetEventResponse getEventResponse = oneNetClient.execute(getEventRequest);

        if(getEventResponse.getErrno() != 0){
            System.out.println("获取产品事件详情失败:" + getEventResponse.getError());
        }else {
            System.out.println("事件内容:" + getEventResponse.getData().getBody());
            System.out.println("事件模板:" + getEventResponse.getData().getSchema());
            System.out.println("事件模板id:" + getEventResponse.getData().getSchema_id());
        }
    }

}
