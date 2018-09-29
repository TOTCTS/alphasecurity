package org.best.alpha.service;

import org.best.alpha.base.BaseService;
import org.best.alpha.entity.po.User;
import org.best.alpha.entity.po.UserAuthority;
import org.best.alpha.entity.so.UserAuthoritySo;
import org.best.alpha.exception.NullPointException;
import org.best.alpha.exception.ParameterException;

import java.util.List;

public interface UserAuthorityService extends BaseService<UserAuthority, UserAuthoritySo> {

    List<UserAuthority> createUserAuthorityList(List<UserAuthority> userAuthorityList);

    List<UserAuthority> getUserAuthoritiesByUsername(String username);

    void deleteUserAuthoritiesByUsername(String username);

}
