package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.ProductsRespEntity;

import java.util.List;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 产品列表返回类
 */
public class ProductsResponse extends BaseResponse{

    //产品列表的数量
    private int total_count;

    public class Data{
        private List<ProductsRespEntity> items;

        public List<ProductsRespEntity> getItems() {
            return items;
        }

        public void setItems(List<ProductsRespEntity> items) {
            this.items = items;
        }
    }

    private Data data;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
