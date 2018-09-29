package org.best.alpha.dao;

import org.best.alpha.base.BaseDao;
import org.best.alpha.entity.po.User;
import org.best.alpha.entity.so.UserSo;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:00
 * @description:
 **/

public interface UserDao extends BaseDao<User, UserSo> {

    User getByUsername(String username);

    void deleteByUsername(String username);

}
