package org.best.alpha.dao;

import org.best.alpha.base.BaseDao;
import org.best.alpha.entity.po.UserAuthority;
import org.best.alpha.entity.so.UserAuthoritySo;

import java.util.List;

public interface UserAuthorityDao extends BaseDao<UserAuthority, UserAuthoritySo> {

    List<UserAuthority> getUserAuthoritiesByUsername(String username);

    void deleteUserAuthoritiesByUsername(String username);

    List<String> getUsernameByAuthorityId(Long authorityId);

}
