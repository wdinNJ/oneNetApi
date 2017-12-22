package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 更新设备分组的HTTP内容
 */
public class UpdateGroupBodyReqEntity {

    //名称，必选
    private String name;

    //过滤器，必选
    private String filter;

    //权重，必选，（范围1-100，同一product下weight不可以相同）
    private int weight;

    //描述，可选
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
