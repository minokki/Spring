package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//��� ���� �Է��ϸ� ������ �˷��ִ� ���α׷�  
@Controller
public class YoilTellerMVC { //MVC�� �и� �۾� 
	//��ȯŸ���� void�� ���εǾ��ִ� �̸� ��� �̵��Ѵ�.
	@RequestMapping("/getYoilMVC") //http://localhost:8080/ch2/getYoilMVC?year=2023&month=3&day=1
	public String main(int year, int month, int day, Model model) throws IOException{

		//1. ��ȿ�� �˻�
		if(!isValid(year,month,day))
			return "yoilError";
		
		//2. ���� ���
		char yoil = getYoil(year, month, day);
		
		
		//3. ����� ����� model�� ����
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);
		model.addAttribute("yoil",yoil);
		
		return "yoil"; //yoil.jsp �� ��ȯ �ض� 


		

	}

private boolean isValid(int year, int month, int day) {
	// TODO Auto-generated method stub
	return true;
}

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, month -1 , day);
	
	int dayofWeek = cal.get(Calendar.DAY_OF_WEEK); //1:�Ͽ���, 2: ������....
	return " �Ͽ�ȭ���������".charAt(dayofWeek);
}

}
