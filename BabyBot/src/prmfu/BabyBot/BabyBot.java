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
		String token = "NTgxMjMyNDIzMjU0MDk3OTI0.XgEveQ.t3nIXY9uyemXj3fyPkpbcYw6HNc";
		jda = new JDABuilder(AccountType.BOT).setToken(token).build();
		//JDABuilder builder = new JDABuilder(AccountType.BOT);
		//String token = "NTgxMjMyNDIzMjU0MDk3OTI0.XgEveQ.t3nIXY9uyemXj3fyPkpbcYw6HNc";
		//builder.setToken(token);
		//builder.setActivity(Activity.playing("Under Construction"));
		//builder.build();

		jda.getPresence().setStatus(OnlineStatus.IDLE);
		jda.getPresence().setActivity(null);
		
		
		jda.addEventListener(new InfoCommands());
		jda.addEventListener(new DegreesConverter());
		jda.addEventListener(new HeightConverter());
		
		
	}
}
