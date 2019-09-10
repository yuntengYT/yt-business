package yt.business.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yt.business.delaytask.DelayTaskConsumer;
import yt.business.delaytask.DelayTaskProducer;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yunteng
 */
@RestController
@Configuration
public class DelayTaskController {

	@Autowired
	private DelayTaskProducer delayTaskProducer;
	@Autowired
	private DelayTaskConsumer delayTaskConsumer;
	@RequestMapping(value = "delay-redis",method = RequestMethod.GET)
	public String DelayRedis(){
		//DelayTaskProducer delayTaskProducer = new DelayTaskProducer();
		long now = System.currentTimeMillis();

		System.out.println("start=======now:" + now);

		delayTaskProducer.producer("1",now + TimeUnit.SECONDS.toMillis(5));

		delayTaskProducer.producer("2",now + TimeUnit.SECONDS.toMillis(10));

		delayTaskProducer.producer("3",now + TimeUnit.SECONDS.toMillis(15));

		delayTaskProducer.producer("4",now + TimeUnit.SECONDS.toMillis(20));

		delayTaskConsumer.start();

		return "1";
	}
}
