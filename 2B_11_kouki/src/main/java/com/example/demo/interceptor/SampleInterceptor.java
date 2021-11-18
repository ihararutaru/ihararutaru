package com.example.demo.interceptor;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class SampleInterceptor {
	@Autowired
	private HttpSession session;
	
	/*
	 * @Before は 割り込むタイミング。Beforeは実行前に割り込む。
	 * exampleの後ろにはどのプログラムに対して割り込みを行うかを書く。
	*/
	@Before("execution(* com.example.demo.controller.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void outputMessage(JoinPoint joinPoint) {
		String userName = (String) session.getAttribute("userName");
		System.out.println("AOPで出力してるよ。ユーザ名は：" + userName);
	}
}

//Github pw mayomayo1204