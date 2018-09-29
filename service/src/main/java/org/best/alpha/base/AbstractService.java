package org.best.alpha.base;

import org.best.alpha.entity.so.PageBean;
import org.best.alpha.exception.DataPersistenceException;
import org.best.alpha.exception.NullPointException;
import org.best.alpha.exception.ParameterException;
import org.best.alpha.util.Assert;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-29 14:52
 * @description:
 **/
public abstract class AbstractService<E extends BaseEntity, S extends BaseSo> implements BaseService<E, S> {

    private BaseDao<E, S> baseDao;
    private BaseManager<E, S> baseManager;

    public AbstractService(BaseDao<E, S> baseDao, BaseManager<E, S> baseManager) {
        this.baseDao = baseDao;
        this.baseManager = baseManager;
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "根据ID删除数据的ID不能为空！");
        baseDao.delete(id);
    }

    @Override
    public E update(E e) {
        baseManager.updateVerification(e);
        E existE = baseDao.get(e.getId());
        if (Assert.isNull(existE)) {
            throw new ParameterException("没有找到需要更新的数据！");
        }
        baseDao.update(e);
        return baseDao.get(e.getId());
    }

    @Override
    public E get(Long id) {
        Assert.notNull(id, "根据ID查找的ID不能为空！");
        return baseDao.get(id);
    }

    @Override
    public List<E> getAll(S s) {
        baseManager.queryVerification(s);
        return baseDao.getAll(s);
    }

    @Override
    public PageBean<E> getPageList(S s) {
        baseManager.pageVerification(s);
        return baseDao.getPageList(s);
    }

    @Override
    public Long getCount(S s) {
        baseManager.queryVerification(s);
        return baseDao.getCount(s);
    }
}
