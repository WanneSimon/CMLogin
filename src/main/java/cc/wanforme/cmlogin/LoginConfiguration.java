package cc.wanforme.cmlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cc.wanforme.cmlogin.lang.LoginLang;
import cc.wanforme.nukkit.spring.plugins.lang.ConfigFileType;

//import cc.wanforme.cmlogin.command.login.LoginCommandHandler;
//import cc.wanforme.cmlogin.command.login.LoginMainCommandHandler;

/**
 * @author wanne
 *
 * 2020年7月24日
 */
@Configuration
public class LoginConfiguration {
	
	// 登录处理bean
//	@Bean
//	public LoginCommandHandler loginCommandHandler() {
//		return new LoginCommandHandler();
//	}
//	@Bean
//	public LoginMainCommandHandler loginMainCommandHandler(
//			@Autowired LoginCommandHandler loginCommandHandler) {
//		LoginMainCommandHandler mainHandler = new LoginMainCommandHandler();
//		mainHandler.addFixedArgumentsHandler(loginCommandHandler);
//		return mainHandler;
//	}

	// 主程序bean
//	@Bean
//	public CMLogin cmLogin(
//			@Autowired LoginMainCommandHandler loginMainCommandHandler) {
//		CMLogin main = new CMLogin();
//		main.putMultiCommandHandler("login", loginMainCommandHandler);
//		return main;
//	}
//	
	
	// 语言文件
//	@Bean
//	public LoginLang loginLang(@Autowired CMLogin cmlogin) {
//		LoginLang lang = new LoginLang(cmlogin, ConfigFileType.YML, cmlogin.getDataFolder().getName()+"/lang/", "en");
//		return lang;
//	}
}
