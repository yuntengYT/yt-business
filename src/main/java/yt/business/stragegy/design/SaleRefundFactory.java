package yt.business.stragegy.design;

import yt.business.stragegy.design.vars.SaleRefundEnum;

/**
 * @author yunteng
 */
public class SaleRefundFactory {

	public static ISaleRefundService getSaleRefund(SaleRefundEnum saleRefundEnum) {

		ISaleRefundService saleRefundService = null;
		try {
			saleRefundService = (ISaleRefundService) Class.forName(saleRefundEnum.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return saleRefundService;
	}
}
