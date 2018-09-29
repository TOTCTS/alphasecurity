package org.best.alpha.service;

import org.best.alpha.base.BaseService;
import org.best.alpha.entity.po.User;
import org.best.alpha.entity.so.UserSo;
import org.best.alpha.exception.NullPointException;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:11
 * @description:
 **/
public interface UserService extends BaseService<User, UserSo>{

    void deleteByUsername(String username);

    User getByUsername(String username);

    List<User> getByUsername(List<String> usernameList);

}
