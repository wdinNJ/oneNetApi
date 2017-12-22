package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetSchemaReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetSchemaRequest;
import com.privateOneNetApi.response.GetSchemaResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取数据模板详情
 */
public class GetSchemaTest {

    public static void main(String [] args) throws Exception {
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetSchemaRequest getSchemaRequest = new GetSchemaRequest();
        GetSchemaReqEntity getSchemaReqEntity = new GetSchemaReqEntity();
        getSchemaReqEntity.setProductId(104018);
        getSchemaReqEntity.setToken("4lUO2flxSPEz8f1M6GnUNL7G4FtejQm1APNu1ZWTMd4VIfmrlxlAX6VkKFcy6pmR");
        getSchemaRequest.setEntity(getSchemaReqEntity);

        getSchemaRequest.setSchemaId(10725);

        GetSchemaResponse getSchemaResponse = oneNetClient.execute(getSchemaRequest);

        if(getSchemaResponse.getErrno() != 0){
            System.out.println("获取数据模板详情失败:" + getSchemaResponse.getError());
        }else{
            System.out.println("数据模板的名称：" + getSchemaResponse.getData().getName());
            System.out.println("数据模板的schema：" + getSchemaResponse.getData().getSchema());
        }
    }

}
