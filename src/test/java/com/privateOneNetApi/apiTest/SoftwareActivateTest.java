package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.SoftwareActivateBodyReqEntity;
import com.privateOneNetApi.entity.SoftwareActivateReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.SoftwareActivateRequest;
import com.privateOneNetApi.response.SoftwareActivateResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/22
 * @description 固件升级
 */
public class SoftwareActivateTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        SoftwareActivateRequest softwareActivateRequest = new SoftwareActivateRequest();
        SoftwareActivateBodyReqEntity softwareActivateBodyReqEntity = new SoftwareActivateBodyReqEntity();
        int [] groupIds = new int[1];
        groupIds[0] = 1277;
        softwareActivateBodyReqEntity.setGroup_ids(groupIds);
        String [] software_uuids = new String[1];
        software_uuids[0] = "456c2581-55c6-443f-8388-4a47f255f142";
        softwareActivateBodyReqEntity.setSoftware_uuids(software_uuids);
        softwareActivateRequest.setEntity(softwareActivateBodyReqEntity);

        SoftwareActivateReqEntity softwareActivateReqEntity = new SoftwareActivateReqEntity();
        softwareActivateReqEntity.setProductId(104018);
        softwareActivateReqEntity.setToken("Dr4AxD8603f0w1V2f4o2lHABFG7-s-hdozxRck1XpLDXgI2W_q7ELsDR3EBQ_4h2");
        softwareActivateRequest.setSoftwareActivateReqEntity(softwareActivateReqEntity);

        SoftwareActivateResponse softwareActivateResponse = oneNetClient.execute(softwareActivateRequest);

        if(softwareActivateResponse.getErrno() != 0){
            System.out.println("固件升级失败:" + softwareActivateResponse.getError());
        }else {
            System.out.println("固件升级成功");
        }

    }

}
