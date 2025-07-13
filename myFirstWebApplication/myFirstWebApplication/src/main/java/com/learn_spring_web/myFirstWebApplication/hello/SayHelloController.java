package com.learn_spring_web.myFirstWebApplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	//"say - hello" => "Hello! What are you learning today !"
	
	//http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today !";
	}
	
	//This is a bit complex to handle as for the webpages with more than 100 lines of html code it will not be feasible to append it in the string buffer 
	//So we use JSP Java server pages 
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First HTML page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("\"My first html page with body!\"");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	//SayHelloJsp => sayHello.jsp
	//instead of the above code and the responseBody we will use the jsp now which will be connected to the method for output 
	//src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	//src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
