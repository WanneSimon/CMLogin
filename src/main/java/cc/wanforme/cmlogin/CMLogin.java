package cc.wanforme.cmlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cc.wanforme.cmlogin.command.login.LoginMainCommandHandler;
import cc.wanforme.cmlogin.lang.LoginLang;
import cc.wanforme.nukkit.spring.plugins.command.MultiCommandPluginBase;

/**
 * @author wanne
 * 2020年7月22日
 */
@Component
public class CMLogin extends MultiCommandPluginBase{
	
	@Autowired
	private LoginMainCommandHandler loginMainCommandHandler;
	@Autowired
	private LoginLang lang;
	
	@Override
	public void onLoad() {
		super.onLoad();
		this.saveConfig();
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
		loginMainCommandHandler.initLoginCommand();
		this.putMultiCommandHandler("login", loginMainCommandHandler);
	}
	
	
}
