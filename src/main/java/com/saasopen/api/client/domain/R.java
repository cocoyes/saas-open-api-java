package com.saasopen.api.client.domain;



import com.saasopen.api.client.constant.Constants;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author ruoyi
 */
public class R<T> extends ErrorResult implements Serializable
{

    private int code;

    private String msg;


    private T data;


    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }


    public Boolean isOk() {
        if(code!=  Constants.SUCCESS){
            return false;
        }else{
            return true;
        }
    }
    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
    public static <T> R<T> ok() {
        return restResult(null, Constants.SUCCESS, "成功");
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, Constants.SUCCESS, "成功");
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, Constants.SUCCESS, msg);
    }

    public static <T> R<T> failed() {
        return restResult(null, Constants.FAIL, "失败");
    }
    public static <T> R<T> failed(int code,String msg) {
        return restResult(null,code, msg);
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
