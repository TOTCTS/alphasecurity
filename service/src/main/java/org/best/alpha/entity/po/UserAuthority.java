package org.best.alpha.entity.po;

import org.best.alpha.base.BaseEntity;

/**
 * @author: BG336672
 * @create: 2018-09-26 14:34
 * @description:
 **/
public class UserAuthority extends BaseEntity{

    private String username;

    private Long authorityId;

    public UserAuthority() {
    }

    public UserAuthority(String username, Long authorityId) {
        this.username = username;
        this.authorityId = authorityId;
    }

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

    @Override
    public String toString() {
        return "UserAuthority{" +
                "username='" + username + '\'' +
                ", authorityId=" + authorityId +
                '}';
    }
}
