package com.privateOneNetApi.response;

import com.privateOneNetApi.entity.GetSchemaRespEntity;
import com.privateOneNetApi.entity.GetSchemasRespEntity;

import java.util.List;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取数据模板列表返回类
 */
public class GetSchemasResponse extends BaseResponse {

    public class  Data{

        private int total_count;

        private List<GetSchemasRespEntity> items;

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public List<GetSchemasRespEntity> getItems() {
            return items;
        }

        public void setItems(List<GetSchemasRespEntity> items) {
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
