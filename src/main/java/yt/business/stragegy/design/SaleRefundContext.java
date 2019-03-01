package yt.business.stragegy.design;

/**
 * @author yunteng
 */
public class SaleRefundContext {

	private ISaleRefundService saleRefundService = null;

	public SaleRefundContext(ISaleRefundService saleRefundService) {
		this.saleRefundService = saleRefundService;
	}

	public void exec (int clueId){
		this.saleRefundService.exec(clueId);
	}
}
