package org.best.alpha.service;

import org.best.alpha.base.AbstractService;
import org.best.alpha.entity.po.Authority;
import org.best.alpha.entity.so.AuthoritySo;
import org.best.alpha.entity.so.PageBean;
import org.best.alpha.exception.ParameterException;
import org.best.alpha.manager.AuthorityManager;
import org.best.alpha.dao.AuthorityDao;
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
public class AuthorityServiceImpl extends AbstractService<Authority, AuthoritySo> implements AuthorityService{

    private final AuthorityDao authorityDao;
    private final AuthorityManager authorityManager;

    @Autowired
    public AuthorityServiceImpl(AuthorityDao authorityDao, AuthorityManager authorityManager) {
        super(authorityDao, authorityManager);
        this.authorityDao = authorityDao;
        this.authorityManager = authorityManager;
    }

    @Override
    public Authority create(Authority authority) {
        authorityManager.createVerification(authority);
        Authority authorityByName = authorityDao.getByName(authority.getAuthority());
        if (!Assert.isNull(authorityByName)) {
            throw new ParameterException("创建的权限名已存在！");
        }
        authorityDao.create(authority);
        return authority;
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "删除的权限ID不能为空！");
        authorityDao.delete(id);
    }

    @Override
    public Authority update(Authority authority) {
        authorityManager.updateVerification(authority);
        Authority authorityById = authorityDao.get(authority.getId());
        if (Assert.isNull(authorityById)) {
            throw new ParameterException("没有对应ID的权限！");
        }
        authorityDao.update(authority);
        return authorityDao.get(authority.getId());
    }

    @Override
    public Authority get(Long id) {
        Assert.notNull(id, "查询权限的ID不能为空！");
        return authorityDao.get(id);
    }

    @Override
    public Authority getByName(String name) {
        Assert.notEmpty(name, "查询权限的名字不能为空！");
        return authorityDao.getByName(name);
    }

    @Override
    public List<Authority> getByUsername(String username) {
        Assert.notEmpty(username, "用户名不能为空！");
        return authorityDao.getByUsername(username);
    }

    @Override
    public List<Authority> getByIdList(List<Long> idList) {
        Assert.notNull(idList, "根据权限ID列表查询权限的ID列表不能为空！");
        return idList.stream()
                .map(authorityDao::get)
                .collect(Collectors.toList());
    }

    @Override
    public List<Authority> getDefaultAuthority() {
        List<Authority> defaultAuthority = authorityDao.getDefaultAuthority();
        if (Assert.isNull(defaultAuthority)) {
            defaultAuthority = Collections.emptyList();
        }
        return defaultAuthority;
    }
}
