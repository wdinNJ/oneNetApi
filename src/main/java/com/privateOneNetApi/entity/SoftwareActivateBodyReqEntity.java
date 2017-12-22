package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/22
 * @description 固件升级的HTTP内容
 */
public class SoftwareActivateBodyReqEntity {

    //组id
    private int [] group_ids;

    //固件uuid
    private String [] software_uuids;

    public int[] getGroup_ids() {
        return group_ids;
    }

    public void setGroup_ids(int[] group_ids) {
        this.group_ids = group_ids;
    }

    public String[] getSoftware_uuids() {
        return software_uuids;
    }

    public void setSoftware_uuids(String[] software_uuids) {
        this.software_uuids = software_uuids;
    }
}
