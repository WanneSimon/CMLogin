package cc.wanforme.cmlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cc.wanforme.cmlogin.command.login.LoginCommandHandler;
import cc.wanforme.cmlogin.command.login.LoginMainCommandHandler;

@Configuration
public class LoginConfiguration {
	
	// 登录处理bean
	@Bean
	public LoginCommandHandler loginCommandHandler() {
		return new LoginCommandHandler( "{{username}}", "{{password}}");
	}
	@Bean
	public LoginMainCommandHandler loginMainCommandHandler(
			@Autowired LoginCommandHandler loginCommandHandler) {
		LoginMainCommandHandler mainHandler = new LoginMainCommandHandler();
		mainHandler.addFixedArgumentsHandler(loginCommandHandler);
		return mainHandler;
	}

	// 主程序bean
	public CMLogin cmLogin(
			@Autowired LoginMainCommandHandler loginMainCommandHandler) {
		CMLogin main = new CMLogin();
		main.putMultiCommandHandler("login", loginMainCommandHandler);
		return main;
	}
	
	
}
