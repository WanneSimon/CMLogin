package cc.wanforme.cmlogin;

import cc.wanforme.nukkit.spring.plugins.command.MultiCommandPluginBase;

/**
 * @author wanne
 * 2020年7月22日
 */
public class CMLogin extends MultiCommandPluginBase{
	
	@Override
	public void onLoad() {
		super.onLoad();
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		this.initCommands();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	private void initCommands() {
		
	}
}
