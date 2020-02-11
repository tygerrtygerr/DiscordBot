package prmfu.BabyBotCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import prmfu.BabyBot.BabyBot;

public class DegreesConverter extends ListenerAdapter {
	
	public static double CelciusToFahrenheitFormula(double c) {
		double fahr = c * 1.8 + 32;
		return fahr;
	}
		
	public static double FahrenheitToCelciusFormula(double f) {
		double celsius = (f - 32) / 1.8;
		return celsius;
	}
	
	public boolean isInteger(String string) {
	    try {
	        Integer.valueOf(string);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public boolean isDouble(String string) {
	    try {
	        Double.valueOf(string);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		double fahr = 0;
		double celsius = 0;
		
		if(args[0].equalsIgnoreCase(BabyBot.prefix + "F") || (args[0].equalsIgnoreCase(BabyBot.prefix + "c2f"))) {
			if(args.length < 2) {
				//error when user only enters prefix+command
				EmbedBuilder error = new EmbedBuilder();
				error.setTitle("Enter degrees in Celsius ");
				error.setDescription("Command will convert degrees from °C to °F");
				event.getChannel().sendMessage(error.build()).queue();
			}
			
			else if(isInteger(args[1]) == true || (isDouble(args[1])) == true) {
				if(isInteger(args[1]) == true) {
					fahr = CelciusToFahrenheitFormula(Integer.parseInt(args[1]));
				}
				if(isDouble(args[1]) == true) {
					fahr = CelciusToFahrenheitFormula(Double.parseDouble(args[1]));
				}
				String result = String.valueOf(String.format("%.2f", fahr));
				event.getChannel().sendMessage(result + "°F").queue();	
			}
			
			else {
				EmbedBuilder error = new EmbedBuilder();
				error.setTitle("Enter degrees in Celsius ");
				error.setDescription("Command will convert degrees from °C to °F");
				event.getChannel().sendMessage(error.build()).queue();
			}
		}
	
	
		
		if(args[0].equalsIgnoreCase(BabyBot.prefix + "C") || (args[0].equalsIgnoreCase(BabyBot.prefix + "f2c")))  {
			if(args.length < 2) {
				// error when user only enters prefix+command
				EmbedBuilder error = new EmbedBuilder();
				error.setTitle("Enter degrees in Fahrenheit");
				error.setDescription("Command will convert degrees from °F to °C");
				event.getChannel().sendMessage(error.build()).queue();
			}
			
			else if(isInteger(args[1]) == true || (isDouble(args[1])) == true) { 
				if(isInteger(args[1]) == true) {
					celsius = FahrenheitToCelciusFormula(Integer.parseInt(args[1]));
				}
				if(isDouble(args[1]) == true) {
					celsius = FahrenheitToCelciusFormula(Double.parseDouble(args[1]));
				}
				//String alsoResult = String.format("%.2f", celsius);
				String result = String.valueOf(String.format("%.2f", celsius));
				event.getChannel().sendMessage(result + "°C").queue();
			}
			
			else{
				EmbedBuilder error = new EmbedBuilder();
				error.setTitle("Enter degrees in Celsius ");
				error.setDescription("Command will convert degrees from °C to °F");
				event.getChannel().sendMessage(error.build()).queue();
			}
		}
	}
	
}
