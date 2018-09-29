package org.best.alpha.base;

import org.best.alpha.entity.so.PageBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author BG336672
 * @create 2018-09-28 16:59
 * @description
 **/
public abstract class AbstractDao<E extends BaseEntity, S extends BaseSo> implements BaseDao<E, S>{

    private SqlSessionTemplate sqlSessionTemplate;
    private final Class<E> entityClass;
    private final String dot = ".";
    private final String statementPrefix;
    protected String statement;

    public AbstractDao(SqlSessionTemplate sqlSessionTemplate, final Class<E> entityClass) {
        this.sqlSessionTemplate = sqlSessionTemplate;
        this.entityClass = entityClass;
        this.statementPrefix = this.entityClass.getSimpleName() + dot;
    }

    protected String getStatement() {
        return statementPrefix + statement;
    }
    
    @Override
    public E create(E e) {
        statement = "create";
        sqlSessionTemplate.insert(getStatement(), e);
        return e;
    }

    @Override
    public Boolean delete(Long id) {
        statement = "delete";
        return sqlSessionTemplate.delete(getStatement(), id) > 0;
    }

    @Override
    public E update(E e) {
        statement = "update";
        sqlSessionTemplate.update(getStatement(), e);
        return sqlSessionTemplate.selectOne(getStatement(),e.getId());
    }

    @Override
    public E get(Long id) {
        statement = "get";
        return sqlSessionTemplate.selectOne(getStatement(), id);
    }

    @Override
    public List<E> getAll(S s) {
        statement = "getAll";
        return sqlSessionTemplate.selectList(getStatement(), s);
    }

    @Override
    public PageBean<E> getPageList(S s) {
        statement = "getPageList";
        List<E> date = sqlSessionTemplate.selectList(getStatement(), s);
        Long count = getCount(s);
        return new PageBean<>(date, s.getCurrentPage(), s.getPageSize(), count);
    }

    @Override
    public Long getCount(S s) {
        statement = "getCount";
        return sqlSessionTemplate.selectOne(getStatement(), s);
    }
}
