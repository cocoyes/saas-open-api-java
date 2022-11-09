package com.saasopen.api.client.domain;

import java.io.Serializable;

/**
 * @author liyong E-mail:liam.li@qiyihuo.com
 * @version 创建时间：2022/8/26 16:07
 * @describe:
 */
public class ErrorResult implements Serializable {
    public String timestamp;
    public Integer status;
    public String error;
    public String path;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
