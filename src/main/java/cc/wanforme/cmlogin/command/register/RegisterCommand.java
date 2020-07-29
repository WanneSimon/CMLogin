package cc.wanforme.cmlogin.command.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.wanforme.nukkit.spring.plugins.command.NSCommand;

/** 注册处理类
 * @author wanne
 *
 * 2020年7月29日
 */
@Component
public class RegisterCommand extends NSCommand{

	@Autowired
	private RegisterCommandHandler registerHandler;
	
	public RegisterCommand() {
		super("register");
	}

	@Override
	protected void initCommand() {
		this.addFixedArgumentsHandler(registerHandler);
	}
	
	
}
