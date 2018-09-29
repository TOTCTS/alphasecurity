package org.best.alpha.base;

import org.best.alpha.entity.so.PageBean;
import org.best.alpha.reponse.AppResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-29 13:34
 * @description:
 **/
public abstract class AbstractController<E, S> implements BaseController<E, S> {

    private BaseService<E, S> baseService;

    public AbstractController(BaseService<E, S> baseService) {
        this.baseService = baseService;
    }

    @Override
    @RequestMapping(method = {RequestMethod.POST})
    public AppResponse create(@RequestBody E entity) {
        entity = baseService.create(entity);
        return AppResponse.success(entity);
    }

    @Override
    @RequestMapping(method = {RequestMethod.DELETE})
    public AppResponse delete(@RequestHeader Long id) {
        baseService.delete(id);
        return AppResponse.success();
    }

    @Override
    @RequestMapping(method = {RequestMethod.PUT})
    public AppResponse update(@RequestBody E entity) {
        entity = baseService.update(entity);
        return AppResponse.success(entity);
    }

    @Override
    @RequestMapping(method = {RequestMethod.GET})
    public AppResponse get(@RequestHeader Long id) {
        E entity = baseService.get(id);
        return AppResponse.success(entity);
    }

    @Override
    @RequestMapping(value = {"list"}, method = RequestMethod.POST)
    public AppResponse getAll(@RequestBody S so) {
        List<E> entityList = baseService.getAll(so);
        return AppResponse.success(entityList);
    }

    @Override
    @RequestMapping(value = {"page"}, method = {RequestMethod.POST})
    public AppResponse getPageList(@RequestBody S so) {
        PageBean<E> pageBean = baseService.getPageList(so);
        return AppResponse.success(pageBean);
    }

    @Override
    @RequestMapping(value = {"count"}, method = {RequestMethod.POST})
    public AppResponse getCount(@RequestBody S so) {
        Long count = baseService.getCount(so);
        return AppResponse.success(count);
    }
}
