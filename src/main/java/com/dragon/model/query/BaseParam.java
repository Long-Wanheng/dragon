package com.dragon.model.query;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 公共基础类
 *
 * @author 龙万恒
 * @date 2020/08/01
 */
public class BaseParam<T> implements Serializable {
    private static final long seriaVersionUID = 1L;

    private final int DEFAULT_OFFSET = 0;
    private final int DEFAULT_PAGE_NUM = 1;
    private final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 分页类型: 空或者0或者不等于1和2为复杂分页,1为简单分页,2为不分页
     */
    private Integer pageType;
    /**
     * 页码,从1开始
     */
    private int pageNum = DEFAULT_PAGE_NUM;
    /**
     * 页码大小,默认10
     */
    private int pageSize = DEFAULT_PAGE_SIZE;
    /**
     * 返回记录行的偏移量
     */
    private int offset = DEFAULT_OFFSET;
    /**
     * 返回记录行的最大数目
     */
    private int limit = DEFAULT_PAGE_SIZE;
    /**
     * 进行count查询的列名
     */
    private String countColumn;
    /**
     * where condition
     */
    private T whereCondition;
    /**
     * order condition
     */
    private Map<String, String> orderCondition;
    /**
     * order by
     */
    private String orderBy;
    /**
     * group condition
     */
    private Map<String, String> groupCondition;
    /**
     * group condition
     */
    private List<String> groupByLst;
    /**
     * group by
     */
    private String groupBy;
    /**
     * id在集合中
     */
    private List<Long> idInList;
    /**
     * id不等于
     */
    private List<Long> idNotEquals;
    /**
     * id不在集合中
     */
    private List<Long> idNotInList;
    /**
     * 总记录数,前端传就用前端用的,前端不传就重新查
     * 使用场景:大数据情况下,减少查询次数,一般不使用
     */
    private Long total;

    public Integer getPageType() {
        return pageType;
    }

    public void setPageType(Integer pageType) {
        this.pageType = pageType;
        if (pageType != null && pageType == 2) {
            disablePage();
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum < 1) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        this.pageNum = pageNum;
        useLimit();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
        useLimit();
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getCountColumn() {
        return countColumn;
    }

    public void setCountColumn(String countColumn) {
        this.countColumn = countColumn;
    }

    public T getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(T whereCondition) {
        this.whereCondition = whereCondition;
    }

    public Map<String, String> getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(Map<String, String> orderCondition) {
        this.orderCondition = orderCondition;
        //排序条件
        StringBuilder orders = new StringBuilder();
        if (orderCondition != null) {
            Iterator<Map.Entry<String, String>> iterator = orderCondition.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                orders.append(entry.getKey() + " " + entry.getValue() + ",");
            }
            setOrderBy(orders.substring(0, orders.lastIndexOf(",")));
        }
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Map<String, String> getGroupCondition() {
        return groupCondition;
    }

    public void setGroupCondition(Map<String, String> groupCondition) {
        this.groupCondition = groupCondition;
        //分组条件
        StringBuilder groups = new StringBuilder();
        if (groupCondition != null) {
            Iterator<Map.Entry<String, String>> iterator = groupCondition.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                groups.append(entry.getKey())
                        .append(" ")
                        .append(entry.getValue() != null ? entry.getValue() : "")
                        .append(",");
            }
            setGroupBy(groups.substring(0, groups.lastIndexOf(",")));
        }
    }

    public List<String> getGroupByLst() {
        return groupByLst;
    }

    public void setGroupByLst(List<String> groupByLst) {
        this.groupByLst = groupByLst;
        //分组条件
        StringBuilder groups = new StringBuilder();
        if (groupByLst != null && groupByLst.size() > 0) {
            for (String groupBy : groupByLst) {
                groups.append(groupBy)
                        .append(",");
            }
            setGroupBy(groups.substring(0, groups.lastIndexOf(",")));
        }
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public List<Long> getIdInList() {
        return idInList;
    }

    public void setIdInList(List<Long> idInList) {
        this.idInList = idInList;
    }

    public List<Long> getIdNotEquals() {
        return idNotEquals;
    }

    public void setIdNotEquals(List<Long> idNotEquals) {
        this.idNotEquals = idNotEquals;
    }

    public List<Long> getIdNotInList() {
        return idNotInList;
    }

    public void setIdNotInList(List<Long> idNotInList) {
        this.idNotInList = idNotInList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void useLimit() {
        if (limit < 1 || pageSize > 0) {
            offset = (pageNum - 1) * pageSize;
            limit = pageSize;
        }
    }

    public void usePage() {
        if (pageSize < 1 || limit > 0) {
            pageNum = (offset - 1) * limit;
            pageSize = limit;
        }
    }

    public void initLimit() {
        offset = DEFAULT_OFFSET;
        limit = DEFAULT_PAGE_SIZE;
    }

    public void initPage() {
        pageNum = DEFAULT_PAGE_NUM;
        pageSize = DEFAULT_PAGE_SIZE;
    }

    public boolean isDisablePage() {
        return pageType != null && pageType == 2;
    }

    public void disablePage() {
        this.pageNum = DEFAULT_PAGE_NUM;
        this.pageSize = Integer.MAX_VALUE;
        this.offset = DEFAULT_OFFSET;
        this.limit = Integer.MAX_VALUE;
        if (!isDisablePage()) {
            this.pageType = 2;
        }
    }
}
