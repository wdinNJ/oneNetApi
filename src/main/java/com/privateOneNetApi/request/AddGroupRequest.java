package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.AddGroupBodyReqEntity;
import com.privateOneNetApi.entity.AddGroupReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.AddGroupResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 新建分组请求类
 */
public class AddGroupRequest extends BaseOneNetRequest<AddGroupBodyReqEntity,AddGroupResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/group";
    private AddGroupReqEntity  addGroupReqEntity;

    public AddGroupReqEntity getAddGroupReqEntity() {
        return addGroupReqEntity;
    }

    public void setAddGroupReqEntity(AddGroupReqEntity addGroupReqEntity) {
        this.addGroupReqEntity = addGroupReqEntity;
    }

    @Override
    public String getURL(OneNetContext context){
        //将url地址中的？后面部分添加
        context.getParameter().putAll(addGroupReqEntity);
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<AddGroupResponse> getResponseClass() {
        return AddGroupResponse.class;
    }

    public HTTPMETHOD getMethod()
    {
        return HTTPMETHOD.POST;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();
        RequestCheckUtils.checkNotEmpty(getEntity().getName(), "name");
        RequestCheckUtils.checkNotEmpty(getEntity().getFilter(), "filter");
        RequestCheckUtils.checkNotEmpty(getEntity().getWeight(), "weight");
        RequestCheckUtils.checkNotEmpty(addGroupReqEntity, "Entity");
        RequestCheckUtils.checkNotEmpty(addGroupReqEntity.getToken(),"token");
        RequestCheckUtils.checkNotEmpty(addGroupReqEntity.getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null : addGroupReqEntity.getProductId(),"product_id");
    }
}
