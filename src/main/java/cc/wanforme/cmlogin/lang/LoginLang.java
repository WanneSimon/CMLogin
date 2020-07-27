package cc.wanforme.cmlogin.lang;

import org.springframework.stereotype.Component;

import cc.wanforme.nukkit.spring.plugins.lang.ConfigFileType;
import cc.wanforme.nukkit.spring.plugins.lang.PluginLangHolder;

/**
 * @author wanne
 * 2020-07-27
 */
@Component
public class LoginLang extends PluginLangHolder{

	public LoginLang() {
		super(ConfigFileType.YML, "lang", "chs");
	}

	
}
