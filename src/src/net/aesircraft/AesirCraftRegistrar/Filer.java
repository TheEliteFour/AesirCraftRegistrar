package net.aesircraft.AesirCraftRegistrar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class Filer
{
	public static boolean exist(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
		if (file.exists()){
			return true;
		}
		return false;
	}
	public static boolean failExist(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "fails" +File.separator +player.getName().toLowerCase()+".yml");
		if (file.exists()){
			return true;
		}
		return false;
	}
	public static boolean warns(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "warns" +File.separator +player.getName().toLowerCase()+".yml");
		if (file.exists()){
			return true;
		}
		return false;
	}
	public static void failDelete(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "fails" +File.separator +player.getName().toLowerCase()+".yml");
		if (!file.exists()){
			return;
		}
		if (!failReason(player)){
			return;
		}
		file.delete();
		return;
	}
	public static void failedProxy(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "fails" +File.separator +player.getName().toLowerCase()+".yml");
        try
		{
			if (file.exists())
				file.delete();
			file.createNewFile();
			FileWriter fileWriter = null;
				BufferedWriter bufferWriter = null;
				fileWriter = new FileWriter(file);
				bufferWriter = new BufferedWriter(fileWriter);
				bufferWriter.append("---");
				bufferWriter.newLine();
				bufferWriter.append("failed: proxy-aesircraft");
				bufferWriter.flush();
				bufferWriter.close();
				fileWriter.close();
		}				
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue writing fails file for "+player.getName(), ex);
		}
		return;
	}
	public static void failedPromote(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "fails" +File.separator +player.getName().toLowerCase()+".yml");
        try
		{
			file.createNewFile();
			FileWriter fileWriter = null;
				BufferedWriter bufferWriter = null;
				fileWriter = new FileWriter(file);
				bufferWriter = new BufferedWriter(fileWriter);
				bufferWriter.append("---");
				bufferWriter.newLine();
				bufferWriter.append("failed: proxy-promotion");
				bufferWriter.flush();
				bufferWriter.close();
				fileWriter.close();
		}				
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue writing fails file for "+player.getName(), ex);
		}
		return;
	}
	public static void setPromote(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		config.set("promote", (int) 0);		
		try
		{
			config.save(file);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue saving file for "+player.getName(), ex);
		}
	}
	public static void setOverride(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		config.set("override", (int) 0);		
		try
		{
			config.save(file);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue saving file for "+player.getName(), ex);
		}
	}
	public static void setRank(Player player,String str){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		config.set("rank", str);
		CommandSender cs = AesirCraftRegistrar.getStatic().getServer().getConsoleSender();
		AesirCraftRegistrar.getStatic().getServer().dispatchCommand(cs, "pex user "+player.getName()+" group set "+str);
		try
		{
			config.save(file);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue saving file for "+player.getName(), ex);
		}
	}
	public static void setRankSafe(Player player,String str){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		config.set("rank", str);
		try
		{
			config.save(file);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue saving file for "+player.getName(), ex);
		}
	}
	public static void setJoined(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		config.set("joined", (int) 0);
		try
		{
			config.save(file);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue saving file for "+player.getName(), ex);
		}
	}
	public static boolean failReason(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "fails" +File.separator +player.getName().toLowerCase()+".yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		String val=config.getString("failed");
		if (val.equals("proxy-simplyaesir"))
			return false;
		return true;
	}
	public static boolean joined(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		int val=config.getInt("joined", 0);
		if (val==1)
			return true;
		return false;
	}
	public static boolean promote(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirCraftRegistrar - Issue loading file for "+player.getName(), ex);
		}
		int val=config.getInt("promote", 0);
		if (val==1)
			return true;
		return false;
	}
	public static String getRank(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		String val=config.getString("rank");
		return val;
	}
	public static boolean override(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		int val=config.getInt("override", 0);
		if (val==1)
			return true;
		return false;
	}
	public static String nextRank(String rank){
		rank=rank.toLowerCase();
		if (rank.equals("nopromote"))
				return "nopromote";
		if (rank.equals("fenrie"))
				return "nopromote";
		if (rank.equals("helmeir"))
				return "Fenrie";
		if (rank.equals("jotnar"))
				return "Helmeir";
		if (rank.equals("valkyr"))
				return "JotNar";
		if (rank.equals("grendalian"))
				return "Valkyr";
		if (rank.equals("vanir"))
				return "Grendalian";
		if (rank.equals("neoval"))
				return "Vanir";
		if (rank.equals("zojan"))
				return "NeoVal";
		if (rank.equals("salvar"))
				return "Zojan";
		if (rank.equals("alvar"))
				return "SalVar";
		return "AlVar";
	}
	public static String rank(Player player){
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.nopromote"))
				return "nopromote";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.fenrie"))
				return "fenrie";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.helmeir"))
				return "helmeir";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.jotnar"))
				return "jotnar";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.valkyr"))
				return "valkyr";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.grendalian"))
				return "grendalian";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.vanir"))
				return "vanir";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.neoval"))
				return "neoval";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.zojan"))
				return "zojan";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.salvar"))
				return "salvar";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.alvar"))
				return "alvar";
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.midguardian"))
				return "midguardian";
		return "showcase";
	}
	public static boolean plus(Player player){
		if (AesirCraftRegistrar.getStatic().permissionHandler.has(player, "aesircraft.registrar.plus"))
				return true;		
		return false;
	}
	public static String ip(Player player){
		File file = new File(AesirCraftRegistrar.getStatic().getDataFolder().toString() + File.separator + "registrations" +File.separator +player.getName().toLowerCase()+"reg.yml");
        FileConfiguration config;
		config = new YamlConfiguration();
		try
		{
			config.load(file);
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE,"AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		catch (InvalidConfigurationException ex)
		{
			Logger.getLogger(Filer.class.getName()).log(Level.SEVERE, "AesirRegistrar - Issue loading file for "+player.getName(), ex);
		}
		String val=config.getString("ip");
		return val;
	}
}
