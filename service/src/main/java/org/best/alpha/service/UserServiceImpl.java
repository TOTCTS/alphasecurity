package org.best.alpha.service;

import org.best.alpha.base.AbstractService;
import org.best.alpha.entity.po.Authority;
import org.best.alpha.entity.po.User;
import org.best.alpha.entity.po.UserAuthority;
import org.best.alpha.entity.so.PageBean;
import org.best.alpha.entity.so.UserSo;
import org.best.alpha.exception.DataPersistenceException;
import org.best.alpha.exception.ParameterException;
import org.best.alpha.manager.UserManager;
import org.best.alpha.dao.UserDao;
import org.best.alpha.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:13
 * @description:
 **/
@Service
public class UserServiceImpl extends AbstractService<User, UserSo>implements UserService{

    private final UserDao userDao;
    private final UserManager userManager;
    private final AuthorityService authorityService;
    private final UserAuthorityService userAuthorityService;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserManager userManager, AuthorityService authorityService,
                           UserAuthorityService userAuthorityService) {
        super(userDao, userManager);
        this.userDao = userDao;
        this.userManager = userManager;
        this.authorityService = authorityService;
        this.userAuthorityService = userAuthorityService;
    }


    @Override
    public User create(User user) {
        userManager.createVerification(user);
        User existUser = userDao.getByUsername(user.getUsername());
        if (Assert.isNotNull(existUser)) {
            throw new ParameterException("用户名已存在！");
        }
        userDao.create(user);
        user = userDao.getByUsername(user.getUsername());
        if (Assert.isNull(user)) {
            throw new DataPersistenceException("创建用户异常！");
        }
        List<Authority> defaultAuthority = authorityService.getDefaultAuthority();
        if (!Assert.isEmpty(defaultAuthority)) {
            List<UserAuthority> userAuthorityList = userManager.createUserAuthorities(user.getUsername(), defaultAuthority);
            userAuthorityService.createUserAuthorityList(userAuthorityList);
        }
        List<Authority> authorityList = authorityService.getByUsername(user.getUsername());
        user.setAuthorities(authorityList);
        return user;
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "删除的用户ID不能为空！");
        userDao.delete(id);
    }

    @Override
    public User update(User user) {
        userManager.updateVerification(user);
        User userByUsername = userDao.getByUsername(user.getUsername());
        if (Assert.isNull(userByUsername)) {
            throw new ParameterException("没有对应用户名的用户！");
        }
        userDao.update(user);
        user = userDao.get(user.getId());
        pushUserAuthority(user);
        return user;
    }

    @Override
    public User get(Long id) {
        Assert.notNull(id, "查找的用户ID不能为空！");
        User user = userDao.get(id);
        user = pushUserAuthority(user);
        return user;
    }

    @Override
    public List<User> getAll(UserSo userSo) {
        userManager.queryVerification(userSo);
        List<User> userList = userDao.getAll(userSo);
        if (Assert.isEmpty(userList)) {
            return Collections.emptyList();
        }
        userList = pushUserAuthority(userList);
        return userList;
    }

    @Override
    public PageBean<User> getPageList(UserSo userSo) {
        userManager.pageVerification(userSo);
        PageBean<User> pageList = userDao.getPageList(userSo);
        pushUserAuthority(pageList.getData());
        return pageList;
    }

    @Override
    public Long getCount(UserSo userSo) {
        userManager.queryVerification(userSo);
        return userDao.getCount(userSo);
    }

    @Override
    public void deleteByUsername(String username) {
        Assert.notEmpty(username, "删除的用户不能为空！");
        userDao.deleteByUsername(username);
    }

    @Override
    public User getByUsername(String username) {
        Assert.notNull(username, "查找的用户名不能为空");
        User user = userDao.getByUsername(username);
        if (Assert.isNull(user)) {
            return null;
        }
        pushUserAuthority(user);
        return user;
    }

    @Override
    public List<User> getByUsername(List<String> usernameList) {
        if (Assert.isEmpty(usernameList)) {
            return Collections.emptyList();
        }
        List<User> users = new ArrayList<>(usernameList.size());
        for (String username : usernameList) {
            User user = userDao.getByUsername(username);
            pushUserAuthority(user);
            users.add(user);
        }
        return users;
    }

    private User pushUserAuthority(User user) {
        Assert.notNull(user, "给用户填充权限时，用户不能为空！");
        List<UserAuthority> userAuthorityList = userAuthorityService.getUserAuthoritiesByUsername(user.getUsername());
        List<Authority> authorityList = authorityService.getByIdList(userAuthorityList.stream()
                .map(UserAuthority::getAuthorityId)
                .collect(Collectors.toList()));
        if (Assert.isEmpty(authorityList)) {
            authorityList = Collections.emptyList();
        }
        user.setAuthorities(authorityList);
        return user;
    }

    private List<User> pushUserAuthority(List<User> userList) {
        Assert.notNull(userList, "批量填充用户权限时，用户列表不能为空！");
        for (User user : userList) {
            pushUserAuthority(user);
        }
        return userList;
    }
}
