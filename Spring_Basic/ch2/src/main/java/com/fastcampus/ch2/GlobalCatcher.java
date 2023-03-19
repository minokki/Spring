package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch3") // 지정된 패키지 안에서 발생하는 Exception 처리
//@ControllerAdvice  // 모든 패키지에 적용
// 해당 어노테이션을 걸어두면 모든 컨트롤러에서 발생하는 예외처리를 핸들러에서 받을수 있다. 
//같은 컨트롤러 핸들러가 우선순위 
public class GlobalCatcher {
	@ExceptionHandler(NullPointerException.class)
	public String catcher1(Exception ex , Model model) {
		model.addAttribute("ex",ex);
		return "error";
	}
	
	//핸들러를 사용함으로서 try catch문을 없앨수잇
	@ExceptionHandler(Exception.class)
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex",ex);
		return "error";
	}
}
