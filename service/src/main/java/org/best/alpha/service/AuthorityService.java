package org.best.alpha.service;

import org.best.alpha.base.BaseService;
import org.best.alpha.entity.po.Authority;
import org.best.alpha.entity.so.AuthoritySo;
import org.best.alpha.exception.ParameterException;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:12
 * @description:
 **/
public interface AuthorityService extends BaseService<Authority, AuthoritySo> {

    Authority getByName(String name);

    List<Authority> getByUsername(String username);

    List<Authority> getByIdList(List<Long> idList);

    List<Authority> getDefaultAuthority();

}
