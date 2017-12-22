package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetGroupConfigurationReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetGroupConfigurationRequest;
import com.privateOneNetApi.response.GetGroupConfigurationResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取组配置内容详情
 */
public class GetGroupConfigurationTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetGroupConfigurationRequest getGroupConfigurationRequest = new GetGroupConfigurationRequest();
        GetGroupConfigurationReqEntity getGroupConfigurationReqEntity = new GetGroupConfigurationReqEntity();
        getGroupConfigurationReqEntity.setProductId(104018);
        getGroupConfigurationReqEntity.setToken("LZADdwbn_DG6OU8HkNzrMBhJD9YK06ew5oPVqaiJMBjrH-lBox8P_bB97uW57bAk");
        getGroupConfigurationReqEntity.setSchemaId(10719);
        getGroupConfigurationReqEntity.setGroupId(1277);
        getGroupConfigurationRequest.setEntity(getGroupConfigurationReqEntity);

        GetGroupConfigurationResponse getGroupConfigurationResponse = oneNetClient.execute(getGroupConfigurationRequest);

        if(getGroupConfigurationResponse.getErrno() != 0){
            System.out.println("获取组配置内容详情失败:" + getGroupConfigurationResponse.getError());
        }else {
            System.out.printf("模板id:%d,模板内容:%s,配置内容详情:%s\n",
                    getGroupConfigurationResponse.getData().getSchema_id(),
                    getGroupConfigurationResponse.getData().getSchema(),
                    getGroupConfigurationResponse.getData().getBody()
            );
        }

    }

}
