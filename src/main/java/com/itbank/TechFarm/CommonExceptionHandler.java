package com.itbank.TechFarm;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.itbank.TechFarm")
public class CommonExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleRuntimeException(){
		return "error/commonException";
	}
}
