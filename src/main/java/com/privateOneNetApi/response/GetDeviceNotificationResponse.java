package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetDeviceNotificationRespEntity;

import java.util.List;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备通知列表返回类
 */
public class GetDeviceNotificationResponse extends BaseResponse {

    public class Data{

        private int total_count;

        private List<GetDeviceNotificationRespEntity> items;

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public List<GetDeviceNotificationRespEntity> getItems() {
            return items;
        }

        public void setItems(List<GetDeviceNotificationRespEntity> items) {
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
