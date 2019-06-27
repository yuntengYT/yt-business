package yt.business.thread.service.impl;

import org.springframework.stereotype.Service;
import yt.business.thread.service.ICountService;

@Service
public class CountServiceImpl implements ICountService {
	@Override
	public int addTwoNumber(int a, int b) {
		System.out.println(a+b);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return a+b;
	}
}
