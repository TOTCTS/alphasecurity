package org.best.alpha.base;

import java.util.Date;

/**
 * @author: BG336672
 * @create: 2018-09-27 20:08
 * @description:
 **/
public class BaseSo {

    private Long id;

    private String nameLike;

    private Date fromTime;

    private Date toTime;

    private Long startIndex;

    private Long currentPage;

    private Long pageSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameLike() {
        return nameLike;
    }

    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public Long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Long startIndex) {
        this.startIndex = startIndex;
    }

    public Long getCurrentPage() {
        return Math.floorDiv(startIndex, pageSize) + 1;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
