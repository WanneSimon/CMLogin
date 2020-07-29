package cc.wanforme.cmlogin.task;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.wanforme.cmlogin.command.login.LoginCommandHandler;
import cc.wanforme.cmlogin.lang.LoginLang;
import cn.nukkit.player.Player;
import cn.nukkit.scheduler.Task;

/**
 * @author wanne
 * 2020年7月29日
 */
@Component
public class LoginTask extends Task{
	@Autowired
	private LoginCommandHandler loginHandler;
	@Autowired
	private LoginLang lang;
	
	@Override
	public void onRun(int currentTick) {
//		this.owner.getConfig().getInt("login.tick", 60);
		Vector<Player> ps = loginHandler.getNotLogin();
		for (Player p : ps) {
			p.sendMessage(lang.get("login.notLogin"));
		}
	}
	
	
	
}
