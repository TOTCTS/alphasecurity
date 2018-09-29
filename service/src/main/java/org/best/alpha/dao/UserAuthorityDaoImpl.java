package org.best.alpha.dao;

import org.best.alpha.base.AbstractDao;
import org.best.alpha.entity.po.UserAuthority;
import org.best.alpha.entity.so.UserAuthoritySo;
import org.best.alpha.util.Assert;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-28 20:40
 * @description:
 **/
@Repository
public class UserAuthorityDaoImpl extends AbstractDao<UserAuthority, UserAuthoritySo> implements UserAuthorityDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public UserAuthorityDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
        super(sqlSessionTemplate, UserAuthority.class);
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<UserAuthority> getUserAuthoritiesByUsername(String username) {
        statement = "getUserAuthoritiesByUsername";
        Assert.notEmpty(username, "查询用户权限的用户名不能为空！");
        return sqlSessionTemplate.selectList(getStatement(), username);
    }

    @Override
    public void deleteUserAuthoritiesByUsername(String username) {
        statement = "deleteUserAuthoritiesByUsername";
        Assert.notEmpty(username, "删除用户权限的用户名不能为空！");
        sqlSessionTemplate.delete(getStatement(), username);
    }

    @Override
    public List<String> getUsernameByAuthorityId(Long authorityId) {
        statement = "getUsernameByAuthorityId";
        Assert.notNull(authorityId, "查询所有拥有该全选的权限ID不能为空！");
        return sqlSessionTemplate.selectList(getStatement(), authorityId);
    }
}
