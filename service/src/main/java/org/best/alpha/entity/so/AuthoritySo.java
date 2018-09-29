package org.best.alpha.entity.so;

import org.best.alpha.base.BaseSo;
import org.best.alpha.entity.po.Authority;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:04
 * @description:
 **/
public class AuthoritySo extends BaseSo{

    private String authority;

    private Boolean defaultAuthority;

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
}
