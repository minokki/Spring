package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionCotroller {

	@ExceptionHandler(NullPointerException.class)
	public String catcher1(Exception ex , Model model) {
		model.addAttribute("ex",ex);
		return "error";
	}
	
	//�ڵ鷯�� ��������μ� try catch���� ���ټ���
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //�����ڵ� 500������ ����
	//ExceptionHandler�� ������� ���  ������ �����ڵ带 �����ֱ����� @ResponseStatus�� �����ڵ带 ���� ���־���Ѵ�.(���̻��) 
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex",ex);
		return "error";
	}
	
	@RequestMapping("/ex") 
	public String main() throws Exception{
			throw new Exception("���ܰ� �߻��մϴ�");		
	}
	@RequestMapping("/ex2") 
	public String main2() throws Exception{
	
			throw new NullPointerException("���ܰ� �߻��մϴ�");
		}
		
	}
