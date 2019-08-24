package com.dragon.model.query;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-24 19:47
 * @Description: ${Description}
 */
public class Page {
    /**
     * 页码
     */
    private Integer pageNum = 0;
    /**
     * 偏移量
     */
    private Integer pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
