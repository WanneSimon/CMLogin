package cc.wanforme.cmlogin.command.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.wanforme.nukkit.spring.plugins.command.MultiCommandHandler;

/** 登录处理器
 * @author wanne
 * 2020年7月22日
 */
@Component
public class LoginMainCommandHandler extends MultiCommandHandler{
	
	@Autowired
	private LoginCommandHandler loginCommandHandler;
	
	public LoginMainCommandHandler() {
		super("login");
//		this.initLoginCommand();
	}
	
	/** 初始化所有命令*/
	public void initLoginCommand() {
//		this.addFixedArgumentsHandler(new LoginCommandHandler( this, "{{username}}", "{{password}}"));
		this.addFixedArgumentsHandler(loginCommandHandler);
	}
	
	
}
