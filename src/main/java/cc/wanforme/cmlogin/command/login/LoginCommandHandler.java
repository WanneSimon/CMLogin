package cc.wanforme.cmlogin.command.login;

import org.springframework.stereotype.Component;

import cc.wanforme.nukkit.spring.plugins.command.FixedArgumentsHandler;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

/**
 * @author wanne
 * 2020年7月22日
 */
@Component
public class LoginCommandHandler extends FixedArgumentsHandler{

	public LoginCommandHandler(String... args) {
		super(args);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		return false;
	}

	
}
