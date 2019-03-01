package yt.business.stragegy.design;

import yt.business.stragegy.design.vars.SaleRefundEnum;

/**
 * @author yunteng
 */
public class SaleRefundExecute {

	public static boolean saleRefund(int clueId,int code){
		SaleRefundEnum saleRefundEnum = SaleRefundEnum.getSaleRefund(code);
		if(null != saleRefundEnum){
			ISaleRefundService saleRefundService = SaleRefundFactory.getSaleRefund(saleRefundEnum);
			SaleRefundContext saleRefundContext = new SaleRefundContext(saleRefundService);
			saleRefundContext.exec(clueId);
			return true;
		}
		return false;
	}
}
