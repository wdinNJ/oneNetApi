package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetGroupDevicesReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetGroupDevicesResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取设备分组下面的设备的请求类
 */
public class GetGroupDevicesRequest extends BaseOneNetRequest<GetGroupDevicesReqEntity,GetGroupDevicesResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/group/<group_id>/device";

    private final String GROUP_ID = "group_id";

    private int groupId;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(GROUP_ID,groupId);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetGroupDevicesResponse> getResponseClass() {
        return GetGroupDevicesResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {

        super.check();

        RequestCheckUtils.checkNotEmpty(groupId == 0 ? null : groupId, GROUP_ID);

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getLimit() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getLimit(), "limit");

        RequestCheckUtils.checkMaxValue(Long.valueOf(getEntity().getLimit()),100,"limit");
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
