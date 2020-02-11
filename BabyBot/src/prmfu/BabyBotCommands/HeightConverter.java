package prmfu.BabyBotCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import prmfu.BabyBot.BabyBot;

public class HeightConverter extends ListenerAdapter {

	public static double cmToInches(double cm) {
		double inches = cm * 0.39;
		return inches;
	}
	
	public static double inchesToCm(int inch) {
		double cm = inch * 2.54;
		return cm;
	}
	
	public static String inchesToFeet(double x) {
		int feet = (int) x / 12;
		int inches =  ((int) x % 12) + 1; //final result in inches rounded out to be an inch off so adding 1 to make it correct measurements
		String feetInches = feet + "'" + inches;
		
		return feetInches;
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
		double cm = 0;
		String feetInches = "";
		
		if(args[0].equalsIgnoreCase(BabyBot.prefix + "in")) {
			if(args.length < 2) {
				EmbedBuilder error = new EmbedBuilder();
				error.setTitle("Enter measurement in centimeters");
				error.setDescription("Command will convert centimeters to feet and inches");
				event.getChannel().sendMessage(error.build()).queue();
			}
			else if(isInteger(args[1]) == true || isDouble(args[1]) == true) {
				if(isInteger(args[1]) == true) {
					feetInches = inchesToFeet(cmToInches(Integer.parseInt(args[1])));
				}
				if(isDouble(args[1]) == true) {
					feetInches = inchesToFeet(cmToInches(Double.parseDouble(args[1])));
				}
				//String result = String.valueOf(feetInches);
				event.getChannel().sendMessage(feetInches).queue();
			}
			else {
				EmbedBuilder error = new EmbedBuilder();
				error.setTitle("Enter measurement in centimeters");
				error.setDescription("Command will convert centimeters to feet and inches");
				event.getChannel().sendMessage(error.build()).queue();
			}
		}
		
		if(args[0].equalsIgnoreCase(BabyBot.prefix + "cm")) {
			//convert ft ' in into a number. times ft by 12 then add the in. then convert to cm
			if(args.length < 2) {
				EmbedBuilder error = new EmbedBuilder();
				error.setTitle("Enter measurement in inches");
				error.setDescription("Command will convert centimeters to feet and inches");
				event.getChannel().sendMessage(error.build()).queue();
			}
		}
	}
}
