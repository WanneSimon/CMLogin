package cc.wanforme.cmlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.wanforme.cmlogin.command.login.LoginCommand;
import cc.wanforme.cmlogin.command.register.RegisterCommand;
import cc.wanforme.cmlogin.lang.LoginLang;
import cc.wanforme.nukkit.spring.plugins.command.NSPluginBase;

/**
 * @author wanne
 * 2020年7月22日
 */
@Component
public class CMLogin extends NSPluginBase{
	
	@Autowired
	private LoginCommand loginCommand;
	@Autowired
	private RegisterCommand registerCommand;
	@Autowired
	private LoginLang lang;
	
	@Override
	public void onLoad() {
		super.onLoad();
//		this.saveConfig(); // 该方法失效了
		this.saveResource("config.yml");
		this.lang.init(true);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		// 启动时，根据配置重新设置语言
		this.lang.setLang(this.getConfig().getString("lang"));
		// 注册指令
		this.initCommands();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	/**初始化所有指令*/
	private void initCommands() {
		this.registerNSCommand("login", loginCommand);
		this.registerNSCommand("register", registerCommand);
	}
	
	public LoginLang getLang() {
		return lang;
	}
}
