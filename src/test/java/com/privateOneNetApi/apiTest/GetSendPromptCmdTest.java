package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.GetSendPromptCmdReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.GetSendPromptCmdRequest;
import com.privateOneNetApi.response.GetSendPromptCmdResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 获取下发及时命令-响应消息
 */
public class GetSendPromptCmdTest {

    public static void main(String [] args) throws Exception {

        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");

        GetSendPromptCmdRequest getSendPromptCmdRequest = new GetSendPromptCmdRequest();
        GetSendPromptCmdReqEntity getSendPromptCmdReqEntity = new GetSendPromptCmdReqEntity();
        getSendPromptCmdReqEntity.setProductId(104018);
        getSendPromptCmdReqEntity.setToken("e4ljlSJyp0XrxthCSro7iqKbTsiSuNPo5ose_w5tlVnXq_6Gva5aIEyHpJRZlu4p");
        getSendPromptCmdRequest.setEntity(getSendPromptCmdReqEntity);

        getSendPromptCmdRequest.setCmdUuid("9eb69d45-66be-401f-ab9a-6a9c32c201dd");

        GetSendPromptCmdResponse getSendPromptCmdResponse = oneNetClient.execute(getSendPromptCmdRequest);

        if(getSendPromptCmdResponse.getErrno() != 0){
            System.out.println("获取下发及时命令-响应消息失败:" + getSendPromptCmdResponse.getError());
        }else {
            System.out.println("下发的模板内容:" + getSendPromptCmdResponse.getData().getBody());
        }

    }

}
