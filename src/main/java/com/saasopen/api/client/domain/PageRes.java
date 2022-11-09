package com.saasopen.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author liyong E-mail:liam.li@qiyihuo.com
 * @version 创建时间：2022/9/9 10:00
 * @describe:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageRes<T> {
    private Integer current;
    private Integer size;
    private Integer total;
    private List<T> records;
}
