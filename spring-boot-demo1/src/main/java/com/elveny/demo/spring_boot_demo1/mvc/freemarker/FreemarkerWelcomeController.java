package com.elveny.demo.spring_boot_demo1.mvc.freemarker;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mvc/freemarker")
public class FreemarkerWelcomeController {
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	@RequestMapping("welcome")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "freemarker/welcome";
	}
}
