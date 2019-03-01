package yt.business.stragegy.design.impl;

import org.springframework.stereotype.Service;
import yt.business.stragegy.design.ISaleRefundService;


/**
 * @author yunteng
 */
@Service
public class SaleRefundSecondServiceImpl implements ISaleRefundService {
	@Override
	public void exec(int clueId) {
		System.out.println(clueId + ",退费逻辑2");
	}
}
