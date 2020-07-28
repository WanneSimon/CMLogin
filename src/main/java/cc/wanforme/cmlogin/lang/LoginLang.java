package cc.wanforme.cmlogin.lang;

//import org.springframework.stereotype.Component;

import cc.wanforme.nukkit.spring.plugins.lang.ConfigFileType;
import cc.wanforme.nukkit.spring.plugins.lang.PluginLangHolder;
import cn.nukkit.plugin.Plugin;

/**
 * @author wanne
 * 2020-07-27
 */
//@Component
public class LoginLang extends PluginLangHolder{

	public LoginLang(Plugin plugin, ConfigFileType type, String basePackage, String lang) {
		super(plugin, type, basePackage, lang);
	}

//	public LoginLang() {
//		super(ConfigFileType.YML, "lang", "en");
//	}

	
}
