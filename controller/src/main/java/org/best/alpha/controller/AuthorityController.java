package org.best.alpha.controller;

import org.best.alpha.base.AbstractController;
import org.best.alpha.entity.po.Authority;
import org.best.alpha.entity.so.AuthoritySo;
import org.best.alpha.exception.ParameterException;
import org.best.alpha.reponse.AppResponse;
import org.best.alpha.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-27 15:28
 * @description:
 **/
@RestController
@RequestMapping(value = {"authority"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class AuthorityController extends AbstractController<Authority, AuthoritySo> {

    private final AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService) {
        super(authorityService);
        this.authorityService = authorityService;
    }

    @RequestMapping(value = {"name"}, method = {RequestMethod.GET})
    public AppResponse getByName(@RequestHeader(value = "name") String name) throws ParameterException {
        Authority authority = authorityService.getByName(name);
        return AppResponse.success(authority);
    }

    @RequestMapping(value = {"default"}, method = {RequestMethod.GET})
    public AppResponse getDefaultAuthority() {
        List<Authority> defaultAuthority = authorityService.getDefaultAuthority();
        return AppResponse.success(defaultAuthority);
    }

}
