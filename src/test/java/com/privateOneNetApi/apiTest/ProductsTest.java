package com.privateOneNetApi.apiTest;

import com.privateOneNetApi.common.DefaultOneNetClient;
import com.privateOneNetApi.common.OneNetClient;
import com.privateOneNetApi.entity.ProductsReqEntity;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.ProductsRequest;
import com.privateOneNetApi.response.ProductsResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 获取产品列表
 */
public class ProductsTest {

    public static void main(String [] args) throws Exception {
        OneNetClient oneNetClient = new DefaultOneNetClient("api.heclouds.com");
        ProductsRequest productListRequest = new ProductsRequest();
        ProductsReqEntity productListReqEntity = new ProductsReqEntity();
        productListReqEntity.setPage(1);
        productListReqEntity.setPerPage(10);
        productListReqEntity.setToken("N9oFualVaKoguNm9lcpMF0wtwv2oTpiU3zD2sWCMXs1GQGquNJYMvt-uw-PqPge7");
        productListRequest.setEntity(productListReqEntity);
        ProductsResponse productListResponse = oneNetClient.execute(productListRequest);
        if(productListResponse.getErrno() != 0){
            System.out.println("获取产品列表出错");
        }else {
            System.out.println("产品的个数是:" + productListResponse.getTotal_count());
            productListResponse.getData().getItems().forEach(product -> System.out.printf("产品id：%s,产品名称:%s\n",product.getId(),product.getName()));
        }
    }

}
