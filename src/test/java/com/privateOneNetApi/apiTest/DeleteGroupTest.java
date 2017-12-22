package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.DeleteGroupReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.DeleteGroupRequest;
import com.privateOneNetApi.response.DeleteGroupResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 删除设备分组
 */
public class DeleteGroupTest {

    public static void main(String [] args) throws Exception {
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        DeleteGroupRequest deleteGroupRequest = new DeleteGroupRequest();
        deleteGroupRequest.setGroupId(1394);

        DeleteGroupReqEntity deleteGroupReqEntity = new DeleteGroupReqEntity();
        deleteGroupReqEntity.setProductId(104018);
        deleteGroupReqEntity.setToken("Z-4_kMUIAetDWz16oC2yuXKWrshPmr_7OnGkYVUMu64yIhGJ809YoJkZdNBuCv7E");
        deleteGroupRequest.setEntity(deleteGroupReqEntity);

        DeleteGroupResponse deleteGroupResponse = oneNetClient.execute(deleteGroupRequest);

        if(deleteGroupResponse.getErrno() != 0){
            System.out.println("删除设备分组失败:" + deleteGroupResponse.getError());
        }else {
            System.out.println("删除设备分组成功");
        }
    }

}
