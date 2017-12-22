package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetGroupDevicesRespEntity;

import java.util.List;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取设备分组下面的设备的返回类
 */
public class GetGroupDevicesResponse extends  BaseResponse{

    public class Data {

        private String cursor;

        private List<GetGroupDevicesRespEntity> items;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<GetGroupDevicesRespEntity> getItems() {
            return items;
        }

        public void setItems(List<GetGroupDevicesRespEntity> items) {
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
