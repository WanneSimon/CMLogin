package cc.wanforme.cmlogin.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.wanforme.cmlogin.command.login.LoginCommandHandler;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;

/**
 * @author wanne
 * 2020-0727
 */
@Component
public class LoginListener implements Listener{

	@Autowired
	private LoginCommandHandler login;
	
	@EventHandler(priority = EventPriority.HIGH)
	public void playerMoveEvent(PlayerMoveEvent e) {
		if(login.isNotLogin(e.getPlayer())) {
			e.setCancelled();
		}
	}
	
	
	
}
