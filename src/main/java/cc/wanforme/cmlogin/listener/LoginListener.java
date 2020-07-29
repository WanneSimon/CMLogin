package cc.wanforme.cmlogin.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import cc.wanforme.cmlogin.CMLogin;
import cc.wanforme.cmlogin.command.login.LoginCommandHandler;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.event.player.PlayerMoveEvent;

/**
 * @author wanne
 * 2020-0727
 */
@Component
public class LoginListener implements Listener{

	@Autowired
	private LoginCommandHandler login;
	@Autowired
	@Lazy
	private CMLogin main;
	
	// 监听移动事件
	@EventHandler(priority = EventPriority.HIGH)
	public void playerMoveEvent(PlayerMoveEvent e) {
		if(login.isNotLogin(e.getPlayer())) {
			e.setCancelled();
		}
	}
	
	// 监听执行命令事件
	@EventHandler(priority = EventPriority.HIGH)
	public void playerOnCommand(PlayerCommandPreprocessEvent e) {
		if(login.isNotLogin(e.getPlayer())) {
			String msg = e.getMessage();
			String cmd = msg;
			
			int index = msg.indexOf(' ');
			if(index != -1) {
				cmd = msg.substring(0, index);
			}
			
			if(!main.containCommand(cmd)) {
				e.setCancelled();
			}
		}
	}
	
}
