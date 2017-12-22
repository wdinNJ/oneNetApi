package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetEventsReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetEventsRequest;
import com.privateOneNetApi.response.GetEventsResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取产品事件列表
 */
public class GetEventsTest {

    public static void main(String [] args) throws Exception {
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetEventsRequest getEventsRequest = new GetEventsRequest();
        GetEventsReqEntity getEventsReqEntity = new GetEventsReqEntity();
        getEventsReqEntity.setProductId(104018);
        getEventsReqEntity.setToken("4CGPTcfrReXSMX_E5nnG5gp4zGEN-NgP-MI3og7YBNhD72R_KFecUt1VMla_Rd0R");
        getEventsReqEntity.setPage(1);
        getEventsReqEntity.setPerPage(10);
        //可选
        //getEventsReqEntity.setStatus("UNREAD");
        getEventsRequest.setEntity(getEventsReqEntity);

        GetEventsResponse getEventsResponse = oneNetClient.execute(getEventsRequest);

        if(getEventsResponse.getErrno() != 0){
            System.out.println("获取产品事件列表失败:" + getEventsResponse.getError());
        }else {
            System.out.println("获取产品事件列表的个数:" + getEventsResponse.getData().getTotal_count());

            getEventsResponse.getData().getItems().
                    forEach(
                            event -> System.out.printf("事件id:%s,事件类型：%s,事件来源：%s,事件状态：%s\n",
                                    event.getUuid(),event.getLevel(), event.getAt(),event.getStatus()
                            )
                    );
        }
    }

}
