package org.best.alpha.controller;

import org.best.alpha.base.AbstractController;
import org.best.alpha.entity.po.UserAuthority;
import org.best.alpha.entity.so.UserAuthoritySo;
import org.best.alpha.reponse.AppResponse;
import org.best.alpha.service.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-29 13:57
 * @description:
 **/
@RestController
@RequestMapping(value = {"userAuthority"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class UserAuthorityController extends AbstractController<UserAuthority, UserAuthoritySo> {

    private final UserAuthorityService userAuthorityService;

    @Autowired
    public UserAuthorityController(UserAuthorityService userAuthorityService) {
        super(userAuthorityService);
        this.userAuthorityService = userAuthorityService;
    }

    @RequestMapping(value = {"username"}, method = {RequestMethod.GET})
    public AppResponse getUserAuthoritiesByUsername(@RequestHeader(value = "username") String username) {
        List<UserAuthority> userAuthorityList = userAuthorityService.getUserAuthoritiesByUsername(username);
        return AppResponse.success(userAuthorityList);
    }

    @RequestMapping(value = {"username"}, method = {RequestMethod.DELETE})
    public AppResponse deleteUserAuthoritiesByUsername(@RequestHeader(value = "username") String username) {
        userAuthorityService.deleteUserAuthoritiesByUsername(username);
        return AppResponse.success();
    }

}
