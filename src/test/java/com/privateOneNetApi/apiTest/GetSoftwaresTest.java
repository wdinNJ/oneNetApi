package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetSoftwaresReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetSoftwaresRequest;
import com.privateOneNetApi.response.GetSoftwaresResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取固件列表
 */
public class GetSoftwaresTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetSoftwaresRequest getSoftwaresRequest = new GetSoftwaresRequest();
        GetSoftwaresReqEntity getSoftwaresReqEntity = new GetSoftwaresReqEntity();
        getSoftwaresReqEntity.setProductId(104018);
        getSoftwaresReqEntity.setToken("-aQdjZdZQSzkRrlyYwKZLBMHL2sHHdjLOK2rvvfwY6A56BVeF82oYX0nXrWtjsKS");
        getSoftwaresReqEntity.setPage(1);
        getSoftwaresReqEntity.setPerPage(10);
        getSoftwaresRequest.setEntity(getSoftwaresReqEntity);

        GetSoftwaresResponse getSoftwaresResponse = oneNetClient.execute(getSoftwaresRequest);

        if(getSoftwaresResponse.getErrno() != 0){
            System.out.println("获取固件列表失败:" + getSoftwaresResponse.getError());
        }else {
            System.out.println("获取固件列表个数:" + getSoftwaresResponse.getData().getTotal_count());

            getSoftwaresResponse.getData().getItems().forEach(software -> System.out.printf("固件uuid:%s,文件大小:%d\n",software.getUuid(),software.getLength()));
        }

    }

}
