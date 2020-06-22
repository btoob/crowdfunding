package com.ryz.crowdfunding.util;

public class AjaxResult {

    private boolean success;
    private String message;
    private Page page;
    private Object treeData;

    public Object getTreeData() {
        return treeData;
    }

    public void setTreeData(Object treeData) {
        this.treeData = treeData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
