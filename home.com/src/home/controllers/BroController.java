package home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BroController {

//1. use @ResponseBody & @RequestMapping , view concept is not yet used, show return context in page
	
//	@ResponseBody
//	@RequestMapping("/cricket")
//	public String giveCricket() {
//		return "text";
//	}
	
	
//2. return certain jsp page, but the path is hard coded, need to be improved
	
//		@RequestMapping("/cricket")
//		public String giveCricket() {
//			return "/WEB-INF/view/cricketPage.jsp";
//		}

//3. use InternalResourceViewResolver
	
	@RequestMapping("/cricket")
	public String giveCricket() {
		return "cricketPage";
	}
	
}
