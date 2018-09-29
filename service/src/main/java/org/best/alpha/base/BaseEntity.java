package org.best.alpha.base;

import java.util.Date;

/**
 * @author: BG336672
 * @create: 2018-09-28 17:20
 * @description:
 **/
public abstract class BaseEntity {

    private Long id;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createTime=" + createTime +
                '}';
    }
}
