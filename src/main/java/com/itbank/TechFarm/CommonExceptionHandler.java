package com.itbank.TechFarm;
import java.util.zip.DataFormatException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.itbank.TechFarm")
public class CommonExceptionHandler {
	
	@ExceptionHandler(DataFormatException.class)
	public String handleRuntimeException(){
		return "error/commonException";
	}
}
