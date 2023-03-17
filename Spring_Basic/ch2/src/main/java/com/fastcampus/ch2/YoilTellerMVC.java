package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//년월 일을 입력하면 요일을 알려주는 프로그램  
@Controller
public class YoilTellerMVC { //MVC로 분리 작업 
	//반환타입이 void면 맵핑되어있는 이름 뷰로 이동한다.
	@RequestMapping("/getYoilMVC") //http://localhost:8080/ch2/getYoilMVC?year=2023&month=3&day=1
	public String main(int year, int month, int day, Model model) throws IOException{

		//1. 유효성 검사
		if(!isValid(year,month,day))
			return "yoilError";
		
		//2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		
		//3. 계산한 결과를 model에 저장
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil",yoil);
		
		return "yoil"; //yoil.jsp 로 반환 해라 


		

	}

private boolean isValid(int year, int month, int day) {
	// TODO Auto-generated method stub
	return true;
}

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, month -1 , day);
	
	int dayofWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일, 2: 월요일....
	return " 일월화수목금토일".charAt(dayofWeek);
}

}
