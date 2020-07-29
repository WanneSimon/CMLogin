package cc.wanforme.cmlogin.command.login;

import java.time.LocalDateTime;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.wanforme.cmcore.base.po.NPlayer;
import cc.wanforme.cmcore.base.po.User;
import cc.wanforme.cmcore.base.service.INPlayerService;
import cc.wanforme.cmcore.base.service.IUserService;
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
	
	@Autowired
	private IUserService userService;
	@Autowired
	private INPlayerService nPlayerService;
	
	public LoginCommandHandler() {
		super("{{username}}", "{{password}}");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.isPlayer()) {
			String username = args[0];
			String password = args[1];
			String pwd = password;
			
			Player player = (Player)sender;
			
//			User user = new User();
//			user.setUserName(username);
//			user.setPwd(password);
//			
//			if( userService.loginCheck(user) ) {
//				this.logined((Player)sender);
//				sender.sendMessage(lang.get("login.success"));
//			} else {
//				sender.sendMessage(lang.get("login.fail"));
//			}
			
			User user = userService.selectByUserName(username);
			if(user == null) {
				sender.sendMessage(lang.get("login.username.notExisted"));
			}
			
			pwd = userService.encodePassword(password);
			if(!pwd.equals(user.getPwd())) {
				sender.sendMessage(lang.get("login.fail"));
			} else {
				// 检查 nplayer 是否存在，不存在则新建
				NPlayer nPlayer = nPlayerService.selectByName(username);
				if(nPlayer == null) {
					sender.sendMessage(lang.get("login.player.creating"));
					nPlayer = new NPlayer();
					nPlayer.setUsername(username);
					nPlayer.setName(player.getName());
					nPlayer.setCreateTime(LocalDateTime.now());
					
					// 再次检查
					if(nPlayerService.selectByName(username) != null) {
						sender.sendMessage(lang.get("login.username.existed"));
						return true;
					}
					nPlayerService.save(nPlayer);
					sender.sendMessage(lang.get("login.username.created"));
					
					this.logined(player);
					sender.sendMessage(lang.get("login.success"));
				} else if(!username.equals(nPlayer.getUsername())) {
					sender.sendMessage(lang.get("login.username.existed"));
				} else {
					this.logined(player);
					sender.sendMessage(lang.get("login.success"));
				}
			}
			
			
		} else {
			sender.sendMessage(lang.get("command.only.player.allowed"));
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
	
	public Vector<Player> getNotLogin() {
		return notLogin;
	}
}
