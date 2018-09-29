package org.best.alpha.manager;

import org.best.alpha.base.AbstractManager;
import org.best.alpha.entity.po.Authority;
import org.best.alpha.entity.so.AuthoritySo;
import org.best.alpha.util.Assert;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:58
 * @description:
 **/
@Component
public class AuthorityManager extends AbstractManager<Authority, AuthoritySo> {
    @Override
    public void createVerification(Authority authority) {
        Assert.notNull(authority, "创建的权限对象不能为空！");
        Assert.notEmpty(authority.getAuthority(), "创建的权限字符串不能为空！");
        Assert.notNull(authority.getDefaultAuthority(), "创建的权限必须制定是否为默认权限！");
        authority.setCreateTime(new Date());
    }

    @Override
    public void updateVerification(Authority authority) {
        createVerification(authority);
        Assert.notNull(authority.getId(), "更新的权限ID不能为空！");
    }

}
