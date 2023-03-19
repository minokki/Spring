package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch3") // ������ ��Ű�� �ȿ��� �߻��ϴ� Exception ó��
//@ControllerAdvice  // ��� ��Ű���� ����
// �ش� ������̼��� �ɾ�θ� ��� ��Ʈ�ѷ����� �߻��ϴ� ����ó���� �ڵ鷯���� ������ �ִ�. 
//���� ��Ʈ�ѷ� �ڵ鷯�� �켱���� 
public class GlobalCatcher {
	@ExceptionHandler(NullPointerException.class)
	public String catcher1(Exception ex , Model model) {
		model.addAttribute("ex",ex);
		return "error";
	}
	
	//�ڵ鷯�� ��������μ� try catch���� ���ټ���
	@ExceptionHandler(Exception.class)
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex",ex);
		return "error";
	}
}
