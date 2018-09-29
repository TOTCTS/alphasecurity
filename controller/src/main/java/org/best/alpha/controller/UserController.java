package org.best.alpha.controller;

import org.best.alpha.base.AbstractController;
import org.best.alpha.entity.po.User;
import org.best.alpha.entity.so.UserSo;
import org.best.alpha.exception.DataPersistenceException;
import org.best.alpha.exception.NullPointException;
import org.best.alpha.exception.ParameterException;
import org.best.alpha.reponse.AppResponse;
import org.best.alpha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:39
 * @description:
 **/
@RestController
@RequestMapping(value = {"user"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class UserController extends AbstractController<User, UserSo> {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @RequestMapping(value = {"login"})
    public AppResponse login(@RequestBody User user) {

        return null;
    }

    @RequestMapping(value = {"logout"})
    public AppResponse logout(@RequestBody User user) {
        return null;
    }

    @RequestMapping(value = {"register"})
    public AppResponse register(@RequestBody User user) throws ParameterException, DataPersistenceException, NullPointException {
        user = userService.create(user);
        return AppResponse.success(user);
    }

    @RequestMapping(value = {"username"}, method = {RequestMethod.GET})
    public AppResponse getByUsername(@RequestHeader(value = "username") String username) {
        User user = userService.getByUsername(username);
        return AppResponse.success(user);
    }

    @RequestMapping(value = {"username"}, method = {RequestMethod.POST})
    public AppResponse getByUsername(@RequestBody List<String> usernameList) {
        List<User> userList = userService.getByUsername(usernameList);
        return AppResponse.success(userList);
    }

}
