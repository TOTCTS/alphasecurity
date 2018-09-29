package org.best.alpha.base;

import org.best.alpha.reponse.AppResponse;

/**
 * @author: BG336672
 * @create: 2018-09-26 15:16
 * @description:
 **/
public interface BaseController<E, S> {

    AppResponse create(E entity);

    AppResponse delete(Long id);

    AppResponse update(E entity);

    AppResponse get(Long id);

    AppResponse getAll(S so);

    AppResponse getPageList(S so);

    AppResponse getCount(S s0);
}
