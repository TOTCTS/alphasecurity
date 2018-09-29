package org.best.alpha.entity.po;

import org.best.alpha.base.BaseEntity;

import java.util.Date;

/**
 * @author: BG336672
 * @create: 2018-09-26 14:31
 * @description:
 **/
public class Authority extends BaseEntity{

    private String authority;

    private Boolean defaultAuthority;

    private String remark;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Boolean getDefaultAuthority() {
        return defaultAuthority;
    }

    public void setDefaultAuthority(Boolean defaultAuthority) {
        this.defaultAuthority = defaultAuthority;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authority='" + authority + '\'' +
                ", defaultAuthority=" + defaultAuthority +
                ", remark='" + remark + '\'' +
                '}';
    }
}
