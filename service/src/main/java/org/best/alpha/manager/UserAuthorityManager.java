package org.best.alpha.manager;

import org.best.alpha.base.AbstractManager;
import org.best.alpha.entity.po.UserAuthority;
import org.best.alpha.entity.so.UserAuthoritySo;
import org.best.alpha.util.Assert;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:59
 * @description:
 **/
@Component
public class UserAuthorityManager extends AbstractManager<UserAuthority, UserAuthoritySo> {
    @Override
    public void createVerification(UserAuthority userAuthority) {
        Assert.notNull(userAuthority, "创建的用户权限关联关系不能为空！");
        Assert.notEmpty(userAuthority.getUsername(), "关联的用户名不能为空！");
        Assert.notNull(userAuthority.getAuthorityId(), "关联的权限ID不能为空！");
        userAuthority.setCreateTime(new Date());
    }

    @Override
    public void updateVerification(UserAuthority userAuthority) {
        createVerification(userAuthority);
        Assert.notNull(userAuthority.getId(), "更新的用户权限关联关系ID不能为空！");
    }

}
