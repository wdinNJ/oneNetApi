package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.UpdateGroupBodyReqEntity;
import com.privateOneNetApi.entity.UpdateGroupReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.UpdateGroupRequest;
import com.privateOneNetApi.response.UpdateGroupResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 更新设备分组
 */
public class UpdateGroupTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        UpdateGroupRequest updateGroupRequest = new UpdateGroupRequest();

        UpdateGroupReqEntity updateGroupReqEntity = new UpdateGroupReqEntity();
        updateGroupReqEntity.setToken("YEDBzUm-qTephd-cn2d3GEeotNqEr7aMgc2r1pP7L3YtuRpPMQoVrSE20fzEuGAv");
        updateGroupReqEntity.setProductId(104018);
        updateGroupRequest.setUpdateGroupReqEntity(updateGroupReqEntity);

        UpdateGroupBodyReqEntity updateGroupBodyReqEntity = new UpdateGroupBodyReqEntity();
        updateGroupBodyReqEntity.setName("xy04");
        updateGroupBodyReqEntity.setFilter("sn == \"x06\" || sn == \"x07\"");
        updateGroupBodyReqEntity.setWeight(6);
        updateGroupBodyReqEntity.setDescription("更新设备分组");
        updateGroupRequest.setEntity(updateGroupBodyReqEntity);

        updateGroupRequest.setGroupId(1689);

        UpdateGroupResponse updateGroupResponse = oneNetClient.execute(updateGroupRequest);

        if(updateGroupResponse.getErrno() != 0){
            System.out.println("更新设备分组失败:" + updateGroupResponse.getError());
        }else {
            System.out.println("更新设备分组成功");
        }

    }

}
