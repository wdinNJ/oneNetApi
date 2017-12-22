package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetGroupsReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetGroupsRequest;
import com.privateOneNetApi.response.GetGroupsResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 获取设备分组列表
 */
public class GetGroupsTest {

    public static void main(String [] args) throws Exception {
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");
        GetGroupsRequest getGroupsRequest = new GetGroupsRequest();
        GetGroupsReqEntity getGroupsReqEntity = new GetGroupsReqEntity();
        getGroupsReqEntity.setToken("LZADdwbn_DG6OU8HkNzrMBhJD9YK06ew5oPVqaiJMBjrH-lBox8P_bB97uW57bAk");
        getGroupsReqEntity.setProductId(104018);
        getGroupsReqEntity.setPage(1);
        getGroupsReqEntity.setPerPage(10);
        getGroupsRequest.setEntity(getGroupsReqEntity);

        GetGroupsResponse getGroupsResponse = oneNetClient.execute(getGroupsRequest);

        if(getGroupsResponse.getErrno() != 0){
            System.out.println("获取分组列表错误:" + getGroupsResponse.getError());
        }else {
            System.out.println("分组的数量:" + getGroupsResponse.getTotal_count());
            getGroupsResponse.getData().getItems().forEach(group -> System.out.printf("获取的分组id:%s,分组名称:%s\n",group.getId(),group.getName()));
        }
    }

}
