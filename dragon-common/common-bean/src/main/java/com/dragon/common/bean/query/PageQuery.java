package com.dragon.common.bean.query;

import io.swagger.annotations.ApiModelProperty;

public class PageQuery {

    @ApiModelProperty(value = "pageNum",position = 98)
    private int pageNum;

    @ApiModelProperty(value = "pageSize,默认值:20",position = 99)
    private int pageSize = 20;

    public PageQuery() {
    }

    public PageQuery(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
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
}
