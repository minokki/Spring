package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	
	@RequestMapping("/rollDice")  //url을 요청 받고 
	public void main(HttpServletResponse response) throws IOException{
		
		//작업
		int idx1= (int)(Math.random()*6)+1;  //랜덤한 값
		int idx2= (int)(Math.random()*6)+1;
		
		/// 호출
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		
		out.println("<body>");
		out.println("<img src='resources/image/dice"+idx1+".jpg'>");
		out.println("<img src='resources/image/dice"+idx2+".jpg'>");
		out.println("<body>");
		out.println("</body>");
		
		out.println("</head>");
		out.println("</html>");
		
		
		
	}

}
