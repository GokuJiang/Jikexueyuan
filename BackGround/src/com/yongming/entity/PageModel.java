package com.yongming.entity;

import java.util.List;

/**
 * Created by jiangyongming on 4/22/16.
 */
public class PageModel<T> {

    private int pageNo = 1;

    private int pageSize = 10;

    private int recordCount;

    private int pageCount;

    private List<T> dates;

    public PageModel() {
    }

    public PageModel(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public List<T> getDates() {
        return dates;
    }

    public void setDates(List<T> dates) {
        this.dates = dates;
    }

    public int getPageCount() {
        if (this.getRecordCount()<=0){
            return 0;
        }
        else {
            pageCount = (recordCount+pageSize-1)/pageSize;
        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }
}
