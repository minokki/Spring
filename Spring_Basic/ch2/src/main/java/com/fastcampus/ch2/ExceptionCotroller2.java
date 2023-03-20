package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //500-> 400 ���� �ڵ庯��
class MyException extends RuntimeException{
	public MyException(String msg) {
		super(msg);
	}
	MyException(){ this(""); }
}

@Controller
public class ExceptionCotroller2 {

// �ڵ鷯�� ���� ��Ʈ�ѷ��� ó���� �ȵȴ�.
	
	@RequestMapping("/ex3") 
	public String main() throws Exception{
			throw new MyException("���ܰ� �߻��մϴ�");		
	}
	@RequestMapping("/ex4") 
	public String main2() throws Exception{
	
			throw new NullPointerException("���ܰ� �߻��մϴ�");
		}
		
	}
