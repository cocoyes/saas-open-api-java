package com.saasopen.api.client.domain.req;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShopQueryDto extends Page {
    /**
     * 空间名称
     */
    private String shopName;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 空间类型 1自营 2 他营
     */
    private Integer businessType;


    /**
     * 空间ID
     */
    private String shopId;
}
