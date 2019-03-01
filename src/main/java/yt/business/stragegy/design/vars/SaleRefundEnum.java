package yt.business.stragegy.design.vars;

import java.util.stream.Stream;

/**
 * @author yunteng
 */

public enum SaleRefundEnum {

	SALE_REFUND_FIRST(1,"yt.business.stragegy.design.impl.SaleRefundFirstServiceImpl"),

	SALE_REFUND_SECOND(2,"yt.business.stragegy.design.impl.SaleRefundSecondServiceImpl"),

	SALE_REFUND_THIRD(3,"yt.business.stragegy.design.impl.SaleRefundThirdServiceImpl");

	int code;
	String value = "";
	SaleRefundEnum(int code, String value){
		this.code = code;
		this.value = value;
	}
	// get set 方法
	public String getName() {
		return value;
	}

	public void setName(String name) {
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public static SaleRefundEnum getSaleRefund(int code){
		return Stream.of(SaleRefundEnum.values()).filter(saleRefundEnum -> saleRefundEnum.code == code).findFirst().orElse(null);
	}
}
