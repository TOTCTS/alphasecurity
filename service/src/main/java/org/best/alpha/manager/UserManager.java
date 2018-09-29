package org.best.alpha.manager;

import org.best.alpha.base.AbstractManager;
import org.best.alpha.entity.po.Authority;
import org.best.alpha.entity.po.User;
import org.best.alpha.entity.po.UserAuthority;
import org.best.alpha.entity.so.UserSo;
import org.best.alpha.util.Assert;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:58
 * @description:
 **/
@Component
public class UserManager extends AbstractManager<User, UserSo> {
    @Override
    public void createVerification(User user) {
        Assert.notNull(user, "创建的用户为空！");
        Assert.notEmpty(user.getUsername(), "输入的用户名不能为空！");
        Assert.notEmpty(user.getPassword(), "输入的密码不能为空！");
        user.setCreateTime(new Date());
    }

    @Override
    public void updateVerification(User user) {
        createVerification(user);
        Assert.notNull(user.getId(), "需要更新的用户ID不能为空！");
    }

    public UserAuthority createUserAuthority(String username, Long authorityId) {
        Assert.notEmpty(username, "关联的用户名不能为空！");
        Assert.notNull(authorityId, "关联的权限ID不能为空！");
        return new UserAuthority(username, authorityId);
    }

    public List<UserAuthority> createUserAuthorities(String username, List<Authority> authorities) {
        List<UserAuthority> userAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            userAuthorities.add(new UserAuthority(username, authority.getId()));
        }
        return userAuthorities;
    }

}
