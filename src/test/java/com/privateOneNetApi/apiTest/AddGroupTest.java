package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.AddGroupBodyReqEntity;
import com.privateOneNetApi.entity.AddGroupReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.AddGroupRequest;
import com.privateOneNetApi.response.AddGroupResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description
 */
public class AddGroupTest {

    public static void main(String [] args) throws Exception {
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");
        AddGroupRequest addGroupRequest = new AddGroupRequest();
        AddGroupBodyReqEntity addGroupBodyReqEntity = new AddGroupBodyReqEntity();
        addGroupBodyReqEntity.setName("xy04");
        addGroupBodyReqEntity.setFilter("sn == \"x06\"");
        addGroupBodyReqEntity.setWeight(6);
        addGroupBodyReqEntity.setDescription("代码新增1");
        addGroupRequest.setEntity(addGroupBodyReqEntity);

        AddGroupReqEntity addGroupReqEntity = new AddGroupReqEntity();
        addGroupReqEntity.setToken("N9oFualVaKoguNm9lcpMF0wtwv2oTpiU3zD2sWCMXs1GQGquNJYMvt-uw-PqPge7");
        addGroupReqEntity.setProductId(104018);
        addGroupRequest.setAddGroupReqEntity(addGroupReqEntity);

        AddGroupResponse addGroupResponse = oneNetClient.execute(addGroupRequest);

        if(addGroupResponse.getErrno() != 0){
            System.out.println("新增分组失败:" + addGroupResponse.getError());
        }else {
            System.out.println("新增分组成功，group_id=" + addGroupResponse.getData().getGroup_id());
        }
    }

}
