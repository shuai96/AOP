package com.shuai.testproject.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    private String respCode = "0000";
    private String respDesc = null;
    private T respInfo = null;


    public BaseResponse() {
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public T getRespInfo() {
        return respInfo;
    }

    public void setRespInfo(T respInfo) {
        this.respInfo = respInfo;
    }

    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    public void build(ErrorCode errorCode){
        this.respCode = errorCode.code();
        this.respDesc = errorCode.description();
    }

}
