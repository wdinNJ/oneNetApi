package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.UpdateGroupBodyReqEntity;
import com.privateOneNetApi.entity.UpdateGroupReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.UpdateGroupResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 更新设备分组的请求类
 */
public class UpdateGroupRequest extends BaseOneNetRequest<UpdateGroupBodyReqEntity,UpdateGroupResponse> {

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/group/<group_id>";

    private static final String GROUP_ID = "group_id";


    private UpdateGroupReqEntity updateGroupReqEntity;
    private int groupId;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(GROUP_ID,groupId);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(updateGroupReqEntity);
        return URIUtils.fmtURI(URI, context);
    }

    public HTTPMETHOD getMethod()
    {
        return HTTPMETHOD.PUT;
    }

    @Override
    public Class<UpdateGroupResponse> getResponseClass() {
        return UpdateGroupResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(groupId == 0 ? null : groupId, GROUP_ID);

        RequestCheckUtils.checkNotEmpty(getEntity().getName(), "name");
        RequestCheckUtils.checkNotEmpty(getEntity().getFilter(), "filter");
        RequestCheckUtils.checkNotEmpty(getEntity().getWeight(), "weight");

        RequestCheckUtils.checkNotEmpty(updateGroupReqEntity, "Entity");
        RequestCheckUtils.checkNotEmpty(updateGroupReqEntity.getToken(),"token");
        RequestCheckUtils.checkNotEmpty(updateGroupReqEntity.getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null : updateGroupReqEntity.getProductId(),"product_id");
    }

    public UpdateGroupReqEntity getUpdateGroupReqEntity() {
        return updateGroupReqEntity;
    }

    public void setUpdateGroupReqEntity(UpdateGroupReqEntity updateGroupReqEntity) {
        this.updateGroupReqEntity = updateGroupReqEntity;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
