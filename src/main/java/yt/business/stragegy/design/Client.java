package yt.business.stragegy.design;


/**
 * @author yunteng
 */
public class Client {

	public static void main(String[] args) {

		boolean result = SaleRefundExecute.saleRefund(123,2);
		System.out.println(result);
	}
}
