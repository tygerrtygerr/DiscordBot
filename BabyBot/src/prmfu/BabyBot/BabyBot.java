package prmfu.BabyBot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import prmfu.BabyBotCommands.InfoCommands;
import prmfu.BabyBotCommands.DegreesConverter;
import prmfu.BabyBotCommands.HeightConverter;

public class BabyBot {
	public static JDA jda;
	public static String prefix = "/";
	
	// Main method
	public static void main(String[] args) throws LoginException {
		String token = "redacted";
		jda = new JDABuilder(AccountType.BOT).setToken(token).build();

		jda.getPresence().setStatus(OnlineStatus.IDLE);
		jda.getPresence().setActivity(null);
		
		
		jda.addEventListener(new InfoCommands());
		jda.addEventListener(new DegreesConverter());
		jda.addEventListener(new HeightConverter());
		
		
	}
}
