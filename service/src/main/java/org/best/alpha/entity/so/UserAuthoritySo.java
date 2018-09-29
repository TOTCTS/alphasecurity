package org.best.alpha.entity.so;

import org.best.alpha.base.BaseSo;
import org.best.alpha.entity.po.UserAuthority;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:08
 * @description:
 **/
public class UserAuthoritySo extends BaseSo{

    private String username;

    private Long authorityId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }
}
