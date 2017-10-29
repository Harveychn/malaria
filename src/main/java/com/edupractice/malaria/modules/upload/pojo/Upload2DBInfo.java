package com.edupractice.malaria.modules.upload.pojo;

public class Upload2DBInfo {
    private boolean isNeedUpdate;
    private boolean isNeedInsert;
    private boolean isSuccessOp;

    public boolean isNeedUpdate() {
        return isNeedUpdate;
    }

    public void setNeedUpdate(boolean needUpdate) {
        isNeedUpdate = needUpdate;
    }

    public boolean isNeedInsert() {
        return isNeedInsert;
    }

    public void setNeedInsert(boolean needInsert) {
        isNeedInsert = needInsert;
    }

    public boolean isSuccessOp() {
        return isSuccessOp;
    }

    public void setSuccessOp(boolean successOp) {
        isSuccessOp = successOp;
    }
}
