package com.emc.awg.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloEndpoint {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@RequestMapping(method=RequestMethod.GET)
	public String sayHello()  {
		return "hello world";
	}
	
	@RequestMapping(value="/ping",method=RequestMethod.GET)
	public String pingRedis() {
		return redisTemplate.getConnectionFactory().getConnection().ping();
	}
}
