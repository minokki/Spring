package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//년월 일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {

	@RequestMapping("/getYoil")
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException{

		//HttpServletResponse response 객체를 톰켓이 만들어줌. 그것을 가지고 브라우저에 출력

		//1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2. 작업
		int yyyy=Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm -1 , dd);
		
		int dayofWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일, 2: 월요일....
		char yoil = " 일월화수목금토일".charAt(dayofWeek);
		
		//3. 출력
		response.setContentType("text/html"); //텍스트로 출력하겟다
		response.setCharacterEncoding("utf-8");  // 한글깨짐방지
		PrintWriter out = response.getWriter(); // response객체에서 브라우저로서의 출력 스트림을 얻는다.
		out.println(year+"년 " + month + "월 " + day + "일은 ");
		out.println(yoil+"요일입니다.");
		

	}

}
