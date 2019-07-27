package com.dragon.util;

import java.util.List;

/**
 * 数据集
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-07-27 23:30
 */
public class TableData<T> {
    /**
     * 总条数
     */
    private Long count = 0L;
    /**
     * 页数
     */
    private Integer pageNum = 1;
    /**
     * 每页条数
     */
    private Integer pageSize = 10;
    /**
     * 数据
     */
    private List<T> data;


    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
