package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.TokenReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.TokenRequest;
import com.privateOneNetApi.response.TokenResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 获取token
 */
public class GetTokenTest {

    public static void main(String [] args) throws Exception {
        //头部是application/json
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");
        TokenRequest tokenRequest = new TokenRequest();
        TokenReqEntity tokenReqEntity = new TokenReqEntity();
        tokenReqEntity.setUserID(28016);
        tokenReqEntity.setSecret("GGpNzwkQjFeuM1jpiMQIpM3mGg2JcqHc");
        tokenRequest.setEntity(tokenReqEntity);
        TokenResponse tokenResponse = oneNetClient.execute(tokenRequest);
        if(tokenResponse.getErrno() != 0){
            System.out.println("未成功获取token");
        }else {
            System.out.printf("获取到的token:%s,失效时间:%s\n",tokenResponse.getData().getToken(),tokenResponse.getData().getTimeout());
        }
    }

}
