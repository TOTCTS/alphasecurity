package org.best.alpha.dao;

import org.best.alpha.base.AbstractDao;
import org.best.alpha.entity.po.Authority;
import org.best.alpha.entity.so.AuthoritySo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-28 20:39
 * @description:
 **/
@Repository
public class AuthorityDaoImpl extends AbstractDao<Authority, AuthoritySo> implements AuthorityDao{

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public AuthorityDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
        super(sqlSessionTemplate, Authority.class);
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public Authority getByName(String name) {
        statement = "getByName";
        return sqlSessionTemplate.selectOne(getStatement(), name);
    }

    @Override
    public List<Authority> getByUsername(String username) {
        statement = "getByUsername";
        return sqlSessionTemplate.selectList(getStatement(), username);
    }


    @Override
    public List<Authority> getDefaultAuthority() {
        statement = "getDefaultAuthority";
        return sqlSessionTemplate.selectList(statement);
    }
}
