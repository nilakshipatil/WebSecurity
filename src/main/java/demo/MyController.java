package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/")
public class MyController {

	@GetMapping(value="help")
	public String method1(){
		System.out.println("Help");
		return "/help1.html";
	}
	
	@GetMapping(value="admin/m1")
	@ResponseBody
	public String m1(){
		System.out.println("in M1");
		return "<h1>in M1</h1>";
	}
	
	@GetMapping(value="admin/m2")
	@ResponseBody
	public String m2(){
		System.out.println("in M2");
		return "<h1>in M2</h1>";
	}
	
}
