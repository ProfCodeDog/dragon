package com.dragon.common.bean.entity;

import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.Collection;

public class PageEntity<T> {

    private int pageNum;
    private int pageSize;
    private long totalCount;
    private long totalPage;
    private Collection<T> data = new ArrayList<>(0);

    public PageEntity() {
    }

    public PageEntity(Page<T> page) {
        this(page.getPageNum(), page.getPageSize(), page.getTotal(), page.getPages(), page.getResult());
    }

    public PageEntity(int pageNum, int pageSize, long totalCount, long totalPage, Collection<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        if (null == data) {
            this.data = new ArrayList<>(0);
        } else {
            this.data = data;
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}
