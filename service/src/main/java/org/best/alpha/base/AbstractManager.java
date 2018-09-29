package org.best.alpha.base;

import org.best.alpha.util.Assert;

/**
 * @author: BG336672
 * @create: 2018-09-29 14:45
 * @description:
 **/
public abstract class AbstractManager<E extends BaseEntity, S extends BaseSo> implements BaseManager<E, S>{

    @Override
    public void queryVerification(S s) {
        Assert.notNull(s, "查询对象不能为空！");
    }

    @Override
    public void pageVerification(S s) {
        queryVerification(s);
        Assert.notNull(s.getStartIndex(), "分页查询的初始位置不能为空！");
        Assert.isFalse(s.getStartIndex() > 0, "分页查询的初始位置必须大于0！");
        Assert.notNull(s.getPageSize(), "分页查询的单页数量不能为空！");
        Assert.isFalse(s.getPageSize() > 0, "分页查询的单页数量必须大于0！");
    }
}
