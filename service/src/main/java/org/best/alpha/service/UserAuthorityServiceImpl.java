package org.best.alpha.service;

import org.best.alpha.base.AbstractService;
import org.best.alpha.entity.po.Authority;
import org.best.alpha.entity.po.User;
import org.best.alpha.entity.po.UserAuthority;
import org.best.alpha.entity.so.PageBean;
import org.best.alpha.entity.so.UserAuthoritySo;
import org.best.alpha.exception.ParameterException;
import org.best.alpha.manager.UserAuthorityManager;
import org.best.alpha.dao.UserAuthorityDao;
import org.best.alpha.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:14
 * @description:
 **/
@Service
public class UserAuthorityServiceImpl extends AbstractService<UserAuthority, UserAuthoritySo> implements UserAuthorityService{

    private final UserAuthorityDao userAuthorityDao;
    private final UserAuthorityManager userAuthorityManager;
    private final AuthorityService authorityService;

    @Autowired
    public UserAuthorityServiceImpl(UserAuthorityDao userAuthorityDao, UserAuthorityManager userAuthorityManager,
                                    AuthorityService authorityService) {
        super(userAuthorityDao, userAuthorityManager);
        this.userAuthorityDao = userAuthorityDao;
        this.userAuthorityManager = userAuthorityManager;
        this.authorityService = authorityService;
    }

    @Override
    public UserAuthority create(UserAuthority userAuthority) {
        userAuthorityManager.createVerification(userAuthority);
        Authority authority = authorityService.get(userAuthority.getAuthorityId());
        if (Assert.isNull(authority)) {
            throw new ParameterException("给定的权限ID未找到匹配的权限");
        }
        userAuthorityDao.create(userAuthority);
        return userAuthority;
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "删除的用户权限关联关系ID不能为空！");
        userAuthorityDao.delete(id);
    }

    @Override
    public UserAuthority update(UserAuthority userAuthority) {
        userAuthorityManager.updateVerification(userAuthority);
        UserAuthority userAuthorityById = userAuthorityDao.get(userAuthority.getId());
        if (Assert.isNull(userAuthorityById)) {
            throw new ParameterException("更新的用户权限ID不存在！");
        }
        userAuthorityDao.update(userAuthority);
        return userAuthorityDao.get(userAuthority.getId());
    }

    @Override
    public UserAuthority get(Long id) {
        Assert.notNull(id, "查找的用户权限关联关系ID不能为空！");
        return userAuthorityDao.get(id);
    }

    @Override
    public List<UserAuthority> createUserAuthorityList(List<UserAuthority> userAuthorityList) {
        userAuthorityList = userAuthorityList.stream()
                .map(this::create)
                .collect(Collectors.toList());
        return userAuthorityList;
    }

    @Override
    public List<UserAuthority> getUserAuthoritiesByUsername(String username) {
        Assert.notEmpty(username, "用户名不能为空！");
        List<UserAuthority> userAuthoritiesByUsername = userAuthorityDao.getUserAuthoritiesByUsername(username);
        if (Assert.isNull(userAuthoritiesByUsername)) {
            userAuthoritiesByUsername = Collections.emptyList();
        }
        return userAuthoritiesByUsername;
    }

    @Override
    public void deleteUserAuthoritiesByUsername(String username) {
        Assert.notEmpty(username, "删除的用户名不能为空！");
        userAuthorityDao.deleteUserAuthoritiesByUsername(username);
    }

}
