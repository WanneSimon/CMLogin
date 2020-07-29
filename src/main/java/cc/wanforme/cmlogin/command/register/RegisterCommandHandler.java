package cc.wanforme.cmlogin.command.register;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
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

/**注册处理<br>
 * 用户名至少4个字符，密码至少6个字符
 * @author wanne
 * 2020年7月29日
 */
@Component
public class RegisterCommandHandler extends FixedArgumentsHandler{
	
	@Autowired
	private LoginLang lang;
	
	@Autowired
	private IUserService userService;
	@Autowired
	private INPlayerService nPlayerService;
	
	public RegisterCommandHandler() {
		super("{{username}}", "{{password}}");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.isPlayer()) {
			String username = args[0];
			String password = args[1];
			Player player = (Player) sender;
			String pwd = password;
			
			if(StringUtils.isAnyBlank(username, password)) {
				sender.sendMessage(lang.get("register.information.invalid"));
				return true;
			} else if(username.length() < 4) {
				sender.sendMessage(lang.get("register.username.tooShort"));
				return true;
			} else if(password.length() < 6) {
				sender.sendMessage(lang.get("register.password.tooShort"));
				return true;
			} else {
				// 是否已经注册过
				if(userService.selectByUserName(username) != null) {
					sender.sendMessage(lang.get("register.username.existed"));
					return true;
				}
			}
			
			pwd = userService.encodePassword(password);
			
			User user = new User();
			user.setUserName(username);
			user.setPwd(pwd);
			user.setRegisterTime(LocalDateTime.now());
			
			NPlayer nplayer = new NPlayer();
			nplayer.setUsername(username);
			nplayer.setName(player.getName());
			nplayer.setCreateTime(user.getRegisterTime());
			
			userService.save(user);
			nPlayerService.save(nplayer);
			sender.sendMessage(lang.get("register.sucess") + " ["+username+" - "+password+"]");
		} else {
			sender.sendMessage(lang.get("command.only.player.allowed"));
		}
		return true;
	}
	
}
