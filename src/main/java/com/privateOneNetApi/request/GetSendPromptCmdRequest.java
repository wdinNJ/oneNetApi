package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetSendPromptCmdReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetSendPromptCmdResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 获取下发及时命令-响应消息请求类
 */
public class GetSendPromptCmdRequest extends BaseOneNetRequest<GetSendPromptCmdReqEntity,GetSendPromptCmdResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/prompt_cmd/<cmd_uuid>";

    private final String CMD_UUID = "cmd_uuid";

    private String cmdUuid;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //设置url地址中的前半部分的参数替换
        context.setContext(CMD_UUID,cmdUuid);
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetSendPromptCmdResponse> getResponseClass() {
        return GetSendPromptCmdResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(cmdUuid,CMD_UUID);

        RequestCheckUtils.checkNotEmpty(getEntity(), "Entity");
        RequestCheckUtils.checkNotEmpty(getEntity().getToken(),"token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null : getEntity().getProductId(),"product_id");
    }

    public String getCmdUuid() {
        return cmdUuid;
    }

    public void setCmdUuid(String cmdUuid) {
        this.cmdUuid = cmdUuid;
    }
}
