package cc.wanforme.cmlogin.command.login;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.wanforme.cmlogin.lang.LoginLang;
import cc.wanforme.nukkit.spring.plugins.command.FixedArgumentsHandler;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.player.Player;

/**
 * @author wanne
 * 2020年7月22日
 */
@Component
public class LoginCommandHandler extends FixedArgumentsHandler{
	
	private volatile Vector<Player> notLogin = new Vector<>(10);
	
	@Autowired
	private LoginLang lang;
	
	public LoginCommandHandler() {
		super("{{username}}", "{{password}}");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.isPlayer()) {
			String username = args[0];
			String password = args[1];
			
//			System.out.println(Arrays.toString(args));
//			System.out.println("logined");
//			System.out.println("["+username + "" + password+"]");
			
			this.logined((Player)sender);
		} else {
			
		}
		return true;
	}

	/**是否未登录*/
	public boolean isNotLogin(Player player) {
		return notLogin.contains(player);
	}
	
	/** 移除一个登录的玩家*/
	public void logined(Player player) {
		notLogin.remove(player);
	}
	
}
