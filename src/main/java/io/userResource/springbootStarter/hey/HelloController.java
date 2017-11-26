package io.userResource.springbootStarter.hey;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hey")
	public String sayHey()
	{
		return "Hey";
	}
}
