package prmfu.BabyBotCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import prmfu.BabyBot.BabyBot;

public class InfoCommands extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
				
		if(args[0].equalsIgnoreCase(BabyBot.prefix + "info")) {
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("🐯 Baby Bot Information");
			info.setDescription("I'm a bot made by Tyger. "
					+ "\n"
					+ "\n COMMANDS:"
					+ "\n /f or /c2f - converts °Celsius to °Fahrenheit"
					+ "\n /c or /f2c - converts °Fahrenheit to °Celsius"
					+ "\n /in - converts Centimeters to Feet and Inches");
			
			
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
	}
}
