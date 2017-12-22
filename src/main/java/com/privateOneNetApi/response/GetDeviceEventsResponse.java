package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetDeviceEventsRespEntity;

import java.util.List;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 查看设备事件列表返回类
 */
public class GetDeviceEventsResponse extends BaseResponse{

    public class Data{

        private int total_count;

        private List<GetDeviceEventsRespEntity> items;

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public List<GetDeviceEventsRespEntity> getItems() {
            return items;
        }

        public void setItems(List<GetDeviceEventsRespEntity> items) {
            this.items = items;
        }
    }

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
