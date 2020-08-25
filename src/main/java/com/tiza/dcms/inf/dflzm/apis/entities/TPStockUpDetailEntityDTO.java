package com.tiza.dcms.inf.dflzm.apis.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author lj
 * @author zpp
 */
@Data
public class TPStockUpDetailEntityDTO {
	private Integer id;
	/**
	 * 备货单id
	 */
	private Integer stockUpId;
	/**
	 * 销售单id
	 */
	private Integer psoId;
	/**
	 * 销售单号
	 */
	private String psoCode;
	/**
	 * 销售单明细id
	 */
	private Integer psoDetailId;
	/**
	 * 零件id
	 */
	private Integer partId;
	/**
	 * 零件编码
	 */
	private String partCode;
	/**
	 * 零件名称
	 */
	private String partName;
	/**
	 * 颜色
	 */
	private String color;
	/**
	 * 计量单位
	 */
	private String Unit;
	/**
	 * 供应商编码
	 */
	private String channelCode;
	/**
	 * 供应商名称
	 */
	private String channelName;
	/**
	 * 零件价格
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private BigDecimal partPrice;
	/**
	 * 物料编码
	 */
	private String materialCode;
	/**
	 * 库存id
	 */
	private Integer inventoryId;

	/**
	 * 库存id集合
	 */

	private Map<Integer, Integer> inventoryIds;
	/**
	 * 仓库id
	 */

	private Integer warehouseId;
	/**
	 * 库区id
	 */
	private Integer warehouseAreaId;
	/**
	 * 货位id
	 */
	private Integer locationId;

	/**
	 * 仓库
	 */
	private String warehouse;
	/**
	 * 库区
	 */
	private String warehouseArea;
	/**
	 * 货位
	 */
	private String location;
	/**
	 * 备货数量
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private Integer stockUpNum;
	/**
	 * 出库数量
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private Integer inoutNum;
	/**
	 * 配货数量
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private Integer distributionNum;
	/**
	 * 箱号id
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private Integer boxId;
	/**
	 * 箱号
	 */
	private String boxCode;
	/**
	 * 备注
	 */
	private String remark;

}
