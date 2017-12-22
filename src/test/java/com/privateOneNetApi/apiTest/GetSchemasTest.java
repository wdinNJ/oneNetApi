package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetSchemasReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetSchemasRequest;
import com.privateOneNetApi.response.GetSchemasResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取数据模板
 */
public class GetSchemasTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetSchemasRequest getSchemasRequest = new GetSchemasRequest();

        GetSchemasReqEntity getSchemasReqEntity = new GetSchemasReqEntity();
        getSchemasReqEntity.setProductId(104018);
        getSchemasReqEntity.setToken("LZADdwbn_DG6OU8HkNzrMBhJD9YK06ew5oPVqaiJMBjrH-lBox8P_bB97uW57bAk");
        getSchemasReqEntity.setPage(1);
        getSchemasReqEntity.setPerPage(10);
        getSchemasReqEntity.setType("CONFIGURATION");
        getSchemasRequest.setEntity(getSchemasReqEntity);

        GetSchemasResponse getSchemasResponse = oneNetClient.execute(getSchemasRequest);

        if(getSchemasResponse.getErrno() != 0 ){
            System.out.println("获取数据模板失败:" + getSchemasResponse.getError());
        }else {
            System.out.println("数据模板个数:" + getSchemasResponse.getData().getTotal_count());

            getSchemasResponse.getData().getItems().forEach(schema -> System.out.printf("数据模板的id:%s,名称:%s,schema:%s\n",schema.getId(),schema.getName(),schema.getSchema()));
        }
    }

}
