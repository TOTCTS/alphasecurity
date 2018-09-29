package org.best.alpha.base;

import org.best.alpha.entity.so.PageBean;
import org.best.alpha.exception.DataPersistenceException;
import org.best.alpha.exception.NullPointException;
import org.best.alpha.exception.ParameterException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-26 14:36
 * @description:
 **/
@Transactional(transactionManager = "transactionManager")
public interface BaseService<E, S> {

    E create(E e) throws ParameterException, DataPersistenceException, NullPointException;

    void delete(Long id);

    E update(E e);

    E get(Long id);

    List<E> getAll(S s);

    PageBean<E> getPageList(S s);

    Long getCount(S s);

}
