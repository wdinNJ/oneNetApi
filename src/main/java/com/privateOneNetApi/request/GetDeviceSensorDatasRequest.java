package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetDeviceSensorDatasReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetDeviceSensorDatasResponse;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备传感器数据列表请求类
 */
public class GetDeviceSensorDatasRequest extends BaseOneNetRequest<GetDeviceSensorDatasReqEntity,GetDeviceSensorDatasResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/device/<device_id>/sensordata";

    private final String DEVICE_ID = "device_id";

    private String deviceId;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(DEVICE_ID,deviceId);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetDeviceSensorDatasResponse> getResponseClass() {
        return GetDeviceSensorDatasResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPage(), "page");
        RequestCheckUtils.checkNotEmpty(getEntity().getPerPage() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getPerPage(), "per_page");

        RequestCheckUtils.checkNotEmpty(deviceId, DEVICE_ID);

        if(!"".equals(getEntity().getBegin()) && getEntity().getBegin() != null
                && !"".equals(getEntity().getEnd()) && getEntity().getEnd() != null){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime begin = LocalDateTime.parse(getEntity().getBegin().replace("T"," "), dateTimeFormatter);
            LocalDateTime end = LocalDateTime.parse(getEntity().getEnd().replace("T"," "), dateTimeFormatter);
            Duration duration = Duration.between(begin,end);
            long day = duration.get(ChronoUnit.SECONDS)/(60*60*24);
            RequestCheckUtils.checkMaxValue(day,30,"begin和end之间的天数");
        }
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
