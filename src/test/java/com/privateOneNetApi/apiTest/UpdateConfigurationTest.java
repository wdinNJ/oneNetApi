package com.privateOneNetApi.apiTest;

import com.alibaba.fastjson.JSONObject;
import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.UpdateConfigurationBodyReqEntity;
import com.privateOneNetApi.entity.UpdateConfigurationReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.UpdateConfigurationRequest;
import com.privateOneNetApi.response.UpdateConfigurationResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 配置变更
 */
public class UpdateConfigurationTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        UpdateConfigurationRequest updateConfigurationRequest = new UpdateConfigurationRequest();

        UpdateConfigurationReqEntity updateConfigurationReqEntity = new UpdateConfigurationReqEntity();
        updateConfigurationReqEntity.setProductId(104018);
        updateConfigurationReqEntity.setToken("LZADdwbn_DG6OU8HkNzrMBhJD9YK06ew5oPVqaiJMBjrH-lBox8P_bB97uW57bAk");
        updateConfigurationRequest.setUpdateConfigurationReqEntity(updateConfigurationReqEntity);

        UpdateConfigurationBodyReqEntity updateConfigurationBodyReqEntity = new UpdateConfigurationBodyReqEntity();
        updateConfigurationBodyReqEntity.setSchema_id(10719);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("device_name","3");
        jsonObject.put("device_info","3333");
        updateConfigurationBodyReqEntity.setBody(jsonObject);
        //配置该参数的时候一定要满足group_id要存在，同时定义的group_ids长度不能多于group_id的个数
        int [] group_ids = new int[1];
        group_ids[0] = 1277;
        updateConfigurationBodyReqEntity.setGroup_ids(group_ids);
        updateConfigurationRequest.setEntity(updateConfigurationBodyReqEntity);

        UpdateConfigurationResponse updateConfigurationResponse = oneNetClient.execute(updateConfigurationRequest);

        if(updateConfigurationResponse.getErrno() != 0){
            System.out.println("配置变更失败:" + updateConfigurationResponse.getError());
        }else {
            System.out.println("配置变更成功");
        }

    }

}
