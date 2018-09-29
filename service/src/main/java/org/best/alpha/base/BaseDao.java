package org.best.alpha.base;

import org.best.alpha.entity.so.PageBean;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-26 14:36
 * @description:
 **/
public interface BaseDao<E extends BaseEntity, S extends BaseSo> {

    E create(E e);

    Boolean delete(Long id);

    E update(E e);

    E get(Long id);

    List<E> getAll(S s);

    PageBean<E> getPageList(S s);

    Long getCount(S s);

}
