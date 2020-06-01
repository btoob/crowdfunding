package com.ryz.crowdfunding.util;

import java.util.List;

public class Page {

    private Integer pageNo;
    private Integer pageSize;
    private Integer totalSize;
    private Integer totalNo;
    private List datas;

    public Page(Integer pageNo, Integer pageSize) {
        if(pageNo<=0){
            this.pageNo=1;
        }else{
            this.pageNo = pageNo;
        }
        if (pageSize<=0){
            this.pageSize=10;
        }else{
            this.pageSize = pageSize;
        }
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
        this.totalNo = (totalSize%pageSize)==0?(totalSize/pageSize):(totalSize/pageSize+1);
    }

    public Integer getTotalNo() {
        return totalNo;
    }

    private void setTotalNo(Integer totalNo) {
        this.totalNo = totalNo;
    }

    public List getDatas() {
        return datas;
    }

    public void setDatas(List datas) {
        this.datas = datas;
    }

    public Integer getStartIndex(){
        return (this.pageNo-1)*pageSize;
    }
}
