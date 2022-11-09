
package com.saasopen.api.client.domain.res;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
* 租户Gas钱包
*
* @author Dora
* @date 2022-01-24 20:52:58
*/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TenantGasAccountRes implements Serializable {

	private static final long serialVersionUID = 79589049150904712L;
	
	/** ID */
	private String id;

	/** 租户ID */
	private String tenantId;

	/** 店铺ID */
	private String shopId;

	/** 类型 */
	private Integer type;

	/** 总余额  Gas 费用 */
	private Long totalAmount;

	/** 可用余额  Gas 费用 */
	private Long availableAmount;

	/** 冻结余额  Gas 费用 */
	private Long freezeAmount;

	/** 状态0正常 1 冻结 2 禁用 */
	private Integer status;

	/** Gas 钱包签名 */
	private String signature;

	/** 上个交易时间 */
	private Date lastTradeTime;

	/** 总收入 Gas */
	private Long totalIncomeAmount;

	/** 总支出 Gas */
	private Long totalOutAmount;

	/** 总充值 单位分 */
	private Long totalRechargeAmount;

	/** 创建时间 */
	private String createTime;


}
