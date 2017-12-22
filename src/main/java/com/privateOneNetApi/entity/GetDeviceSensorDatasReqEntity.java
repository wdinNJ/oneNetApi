package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 用于组装获取设备传感器数据列表的url地址
 */
public class GetDeviceSensorDatasReqEntity extends PageEntity {

    private static final long serialVersionUID = 7L;

    //可选,开始时间
    private final String BEGIN = "begin";

    //可选，结束时间，最大间隔30天
    private final String END = "end";


    public String getBegin() {
        return get(BEGIN);
    }

    public void setBegin(String begin) {
        put(BEGIN,begin);
    }

    public String getEnd() {
        return get(END);
    }

    public void setEnd(String end) {
        put(END,end);
    }
}
