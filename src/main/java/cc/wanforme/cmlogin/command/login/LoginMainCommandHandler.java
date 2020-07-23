package cc.wanforme.cmlogin.command.login;

import cc.wanforme.nukkit.spring.plugins.command.MultiCommandHandler;

/** 登录处理器
 * @author wanne
 * 2020年7月22日
 */
public class LoginMainCommandHandler extends MultiCommandHandler{
	
	public LoginMainCommandHandler() {
		super("login");
//		this.initLoginCommand();
	}

//	private void initLoginCommand() {
//		this.addFixedArgumentsHandler(new LoginCommandHandler( this, "{{username}}", "{{password}}"));
//	}
	
	
}
