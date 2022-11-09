package com.saasopen.api.client.domain.req;

import lombok.Data;

/**
 * @author liyong E-mail:liam.li@qiyihuo.com
 * @version 创建时间：2022/9/9 10:00
 * @describe:
 */
@Data
public class Page {
    private Integer current;
    private Integer size;
    //排序类型， desc或asc
    private String sortType;
    //排序字段
    private String column;
}
