package org.best.alpha.dao;

import org.best.alpha.base.AbstractDao;
import org.best.alpha.entity.po.User;
import org.best.alpha.entity.so.UserSo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: BG336672
 * @create: 2018-09-28 20:05
 * @description:
 **/

@Repository
public class UserDaoImpl extends AbstractDao<User, UserSo> implements UserDao{

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public UserDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
        super(sqlSessionTemplate, User.class);
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public User getByUsername(String username) {
        statement = "getByUsername";
        return sqlSessionTemplate.selectOne(getStatement(), username);
    }

    @Override
    public void deleteByUsername(String username) {
        statement = "deleteByUsername";
        sqlSessionTemplate.delete(getStatement(), username);
    }
}
