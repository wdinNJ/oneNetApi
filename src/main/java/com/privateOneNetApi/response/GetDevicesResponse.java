package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetDevicesRespEntity;

import java.util.List;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备列表的返回类
 */
public class GetDevicesResponse extends BaseResponse{

    public class Data{

        private String cursor;

        private List<GetDevicesRespEntity> items;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<GetDevicesRespEntity> getItems() {
            return items;
        }

        public void setItems(List<GetDevicesRespEntity> items) {
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
