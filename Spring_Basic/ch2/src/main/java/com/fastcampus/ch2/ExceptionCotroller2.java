package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //500-> 400 오류 코드변경
class MyException extends RuntimeException{
	public MyException(String msg) {
		super(msg);
	}
	MyException(){ this(""); }
}

@Controller
public class ExceptionCotroller2 {

// 핸들러가 없는 컨트롤러는 처리가 안된다.
	
	@RequestMapping("/ex3") 
	public String main() throws Exception{
			throw new MyException("예외가 발생합니다");		
	}
	@RequestMapping("/ex4") 
	public String main2() throws Exception{
	
			throw new NullPointerException("예외가 발생합니다");
		}
		
	}

