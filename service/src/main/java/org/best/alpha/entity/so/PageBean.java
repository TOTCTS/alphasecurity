package org.best.alpha.entity.so;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-27 20:08
 * @description:
 **/
public class PageBean<T> {

    private List<T> data;

    private Long firstPage;

    private Long prePage;

    private Long nextPage;

    private Long totalPage;

    private Long currentPage;

    private Long totalCount;

    private Long pageSize;

    public PageBean(List<T> data, Long currentPage, Long pageSize, Long totalCount) {
        this.data = data;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.firstPage = getFirstPage();
        this.prePage = getPrePage();
        this.nextPage = getNextPage();
        this.totalPage = getTotalPage();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Long firstPage) {
        this.firstPage = firstPage;
    }

    public Long getPrePage() {
        return prePage;
    }

    public void setPrePage(Long prePage) {
        this.prePage = prePage;
    }

    public Long getNextPage() {
        return nextPage;
    }

    public void setNextPage(Long nextPage) {
        this.nextPage = nextPage;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
