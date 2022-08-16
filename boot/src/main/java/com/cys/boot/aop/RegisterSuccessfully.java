package com.cys.boot.aop;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import com.cys.boot.service.EmailService;
import com.cys.boot.entity.User;
import com.cys.boot.manager.UserManager;
@Service
@Aspect
public class RegisterSuccessfully  {
	private EmailService emailservice;
	public RegisterSuccessfully(EmailService emailservice) {
		super();
		this.emailservice = emailservice;
	}
	@Pointcut("execution(* com.cys.boot.service.UserService.insertUser(com.cys.boot.entity.User))&&args(user)")
	public void point(com.cys.boot.entity.User user) {}
	@AfterReturning("point(com.cys.boot.entity.User)&&args(user)")
	public void adv(com.cys.boot.entity.User user) {
		emailservice.sendEmail(user);
	}
}
