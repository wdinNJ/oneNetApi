package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetGroupsRespEntity;

import java.util.List;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 获取设备分组列表返回类
 */
public class GetGroupsResponse extends BaseResponse{

    public class Data {

        private List<GetGroupsRespEntity> items;

        public List<GetGroupsRespEntity> getItems() {
            return items;
        }

        public void setItems(List<GetGroupsRespEntity> items) {
            this.items = items;
        }
    }

    private int total_count;

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
