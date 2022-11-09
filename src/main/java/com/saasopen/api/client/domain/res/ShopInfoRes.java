/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.saasopen.api.client.domain.res;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 店铺表
 *
 * @author www.joolun.com
 * @date 2020-05-15 13:35:18
 */
@Data
public class ShopInfoRes implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     * PK
     */
    private String id;
    /**
     * 所属租户
     */
    private String tenantId;

	/**
	 * 类型
	 */
	private Integer type;

	/**
	 * 经营类型 1自营 2 他营
	 */
	private Integer businessType;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    private String delFlag;

	/**
	 * 13位时间戳
	 */
	private Long createTimeStamp;

    /**
     * 创建时间
     */
    private String createTime;



    /**
     * 联系人
     */
    private String contactPerson;

	/**
	 * 联系人微信
	 */
	private String contactWx;

	/**
	 * 联系邮箱
	 */
	private String contactEmail;

	/**
	 * 联系QQ
	 */
	private String contactQq;

	/**
	 * 联系微博
	 */
	private String contactWb;

	/**
	 * 联系公众号
	 */
	private String contactGzh;

	/**
	 * 联系网站
	 */
	private String contactWebsite;

	/**
	 * 电话号码
	 */
	private String phone;

    /**
     * 店铺名
     */
    private String name;
    /**
     * 图片
     */
    private String imgUrl;

	/**
	 * 头像
	 */
	private String headImgUrl;

    /**
     * 所在城市
     */
    private String city;
    /**
     * 所在国家
     */
    private String country;
    /**
     * 所在省份
     */
    private String province;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 详细介绍
     */
    private String detail;
	/**
	 * 微信商户号
	 */
	private String wxMchId;

}
