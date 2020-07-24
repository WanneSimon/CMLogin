package cc.wanforme.cmlogin.command.login;

import java.util.Arrays;
import java.util.Vector;

import cc.wanforme.nukkit.spring.plugins.command.FixedArgumentsHandler;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.player.Player;

/**
 * @author wanne
 * 2020年7月22日
 */
//@Component
public class LoginCommandHandler extends FixedArgumentsHandler{
	
	private volatile Vector<Player> notLogin = new Vector<>(10);
	
	public LoginCommandHandler(String... args) {
		super(args);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String username = args[0];
		String password = args[1];
		
		System.out.println(Arrays.toString(args));
		System.out.println("logined");
		System.out.println("["+username + "" + password+"]");
		return false;
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
