package com.emc.awg.endpoint;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloEndpoint {

	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(method=RequestMethod.GET)
	public String sayHello()  {
		return "hello world";
	}
	
	@RequestMapping(value="datasource",method=RequestMethod.GET)
	public boolean hasDatabaseConnection() throws Exception {
		return (dataSource.getConnection().isClosed() == false ? true : false);
	}
	
}
