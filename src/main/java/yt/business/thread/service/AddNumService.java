package yt.business.thread.service;



import java.util.concurrent.Callable;

public class AddNumService implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		ICountService countService = (ICountService) Class.forName("yt.business.thread.service.impl.CountServiceImpl").newInstance();
		return countService.addTwoNumber(1,2);
	}
}
