package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetGroupReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetGroupRequest;
import com.privateOneNetApi.response.GetGroupResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 获取设备分组详情
 */
public class GetGroupTest {

    public static void main(String [] args) throws Exception {
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");
        GetGroupRequest getGroupRequest = new GetGroupRequest();
        GetGroupReqEntity getGroupReqEntity = new GetGroupReqEntity();
        getGroupReqEntity.setToken("4CGPTcfrReXSMX_E5nnG5gp4zGEN-NgP-MI3og7YBNhD72R_KFecUt1VMla_Rd0R");
        getGroupReqEntity.setProductId(104018);
        getGroupRequest.setEntity(getGroupReqEntity);

        getGroupRequest.setGroupId(1277);

        GetGroupResponse getGroupResponse = oneNetClient.execute(getGroupRequest);

        if(getGroupResponse.getErrno() != 0){
            System.out.println("获取设备分组详情失败:" + getGroupResponse.getError());
        }else {
            System.out.println("设备分组名称:" + getGroupResponse.getData().getName());
            getGroupResponse.getData().getConfigurations().forEach(configuration -> System.out.printf("name:%s---version:%s\n",configuration.getName(),configuration.getVersion()));
        }
    }

}
