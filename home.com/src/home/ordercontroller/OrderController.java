package home.ordercontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	@RequestMapping("/orderWelcome")
	public String showWelcomePage(Model model) {
		
		//String  name = "carol";
		//model.addAttribute("nameValue", name);
		
		return "welcome-page";
	}
	@RequestMapping("/processOrder")
	public String processOrder(HttpServletRequest request,Model model) {
		//capture data
		String userInputValue= request.getParameter("foodType");
		//add data to model
		model.addAttribute("userInput",userInputValue);
		return "processOrder";
	}
}
