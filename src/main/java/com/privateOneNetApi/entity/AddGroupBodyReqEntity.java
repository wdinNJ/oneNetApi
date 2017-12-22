package com.privateOneNetApi.entity;

import java.util.Arrays;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 新增设备分组的HTTP内容
 */
public class AddGroupBodyReqEntity {

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


    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AddGroupBodyReqEntity[name=");
        stringBuffer.append(name);
        stringBuffer.append(",filter=");
        stringBuffer.append(filter);
        stringBuffer.append(",weight=");
        stringBuffer.append(weight);
        stringBuffer.append(",description=");
        stringBuffer.append(description);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((filter == null) ? 0 : filter.hashCode());
        result = prime * result + weight;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AddGroupBodyReqEntity other = (AddGroupBodyReqEntity) obj;
        if (name == null)
        {
            if (other.name != null){
                return false;
            }
        }else if (!name.equals(other.name)){
            return false;
        }

        if (filter == null)
        {
            if (other.filter != null){
                return false;
            }
        }else if (!filter.equals(other.filter)){
            return false;
        }

        if (weight != other.weight){
            return false;
        }

        if (description == null)
        {
            if (other.description != null){
                return false;
            }
        }else if (!description.equals(other.description)){
            return false;
        }
        return true;
    }
}
