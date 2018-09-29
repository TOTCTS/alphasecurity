package org.best.alpha.dao;

import org.best.alpha.base.BaseDao;
import org.best.alpha.entity.po.Authority;
import org.best.alpha.entity.so.AuthoritySo;

import java.util.List;

public interface AuthorityDao extends BaseDao<Authority, AuthoritySo> {

    Authority getByName(String name);

    List<Authority> getByUsername(String username);

    List<Authority> getDefaultAuthority();

}
